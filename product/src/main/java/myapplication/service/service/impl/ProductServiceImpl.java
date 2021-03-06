package myapplication.service.service.impl;

import com.googlecode.protobuf.format.JsonFormat;
import com.khoi.proto.*;
import com.khoi.stockproto.GetStockRequest;
import com.khoi.stockproto.GetStockResponse;
import com.khoi.stockproto.StockServiceGrpc;
import com.khoi.supplierproto.*;
import myapplication.dao.IProductDAO;
import myapplication.dto.Product;
import myapplication.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService {

  @Qualifier("stockService")
  private final StockServiceGrpc.StockServiceBlockingStub stockService;

  @Qualifier("priceService")
  private final PriceServiceGrpc.PriceServiceBlockingStub priceService;

  @Qualifier("supplierService")
  private final SupplierServiceGrpc.SupplierServiceBlockingStub supplierService;

  @Autowired private IProductDAO productDAO;

  public ProductServiceImpl(
      PriceServiceGrpc.PriceServiceBlockingStub priceService,
      StockServiceGrpc.StockServiceBlockingStub stockService,
      SupplierServiceGrpc.SupplierServiceBlockingStub supplierService) {
    this.priceService = priceService;
    this.stockService = stockService;
    this.supplierService = supplierService;
  }

  /**
   * This method converts Iterator to Iterable
   *
   * @param iterator Iterator object
   * @param <T> Type of Iterator object
   * @return Iterable object has the same type of provided Iterator object
   */
  private static <T> Iterable<T> toIterable(final Iterator<T> iterator) {
    return new Iterable<T>() {
      @Override
      public Iterator<T> iterator() {
        return iterator;
      }
    };
  }

  /** {@inheritDoc} */
  @Override
  public List<Product> findAll() {
    List<Product> list = productDAO.findAll();
    list.stream().forEach(p -> findByid(p.getId()));
    return list;
  }

  /** {@inheritDoc} */
  @Override
  public Product findByid(int id) {

    javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
        new javax.net.ssl.HostnameVerifier() {

          public boolean verify(String hostname, javax.net.ssl.SSLSession sslSession) {
            return true;
          }
        });

    Product prod = productDAO.findByid(id);
    try {
      // get PriceHistory
      Iterable<PriceEntry> entries =
          toIterable(
              priceService.getPriceHistory(
                  GetPriceHistoryRequest.newBuilder().setProductId(id).build()));

      List<PriceEntry> list1 = new ArrayList<>();
      entries.forEach(list1::add);

      // cach ta dao
      /*List<String> strings = list1.stream()
      .map(object -> Objects.toString(object, null))
      .collect(Collectors.toList());*/

      // cach khong ta dao?
      List<String> strings =
          list1.stream().map(p -> new JsonFormat().printToString(p)).collect(Collectors.toList());

      prod.setPriceEntries(strings);

      GetPriceResponse rs =
          priceService.getPrice(GetPriceRequest.newBuilder().setProductId(id).build());
      prod.setPrice(rs.getPrice());
    } catch (Exception ex) {
      ex.printStackTrace();
      prod.setPriceEntries(null);
      prod.setPrice(-1);
    }
    try {
      // get stock
      GetStockResponse rs2 =
          stockService.getStock(GetStockRequest.newBuilder().setProductId(id).build());
      prod.setStock(rs2.getStock());
    } catch (Exception ex) {
      prod.setStock(-1);
      ex.printStackTrace();
    }
    try {
      // get list of suppliers selling this product
      List<SupplierEntry> supplierEntryList = new ArrayList<>();
      // get result from gRPC server
      Iterable<SupplierEntry> supplierEntryIterable =
          toIterable(
              supplierService.getSupplierListByProductId(
                  GetSupplierListRequest.newBuilder().setProductId(id).build()));
      // convert Iterable -> list<Entry>
      supplierEntryIterable.forEach(supplierEntryList::add);

      // convert list<entry> -> list<String>
      // result of list<entry> -> list<String>
      List<String> supplierList =
          supplierEntryList.stream()
              .map(s -> new JsonFormat().printToString(s))
              .collect(Collectors.toList());

      prod.setSupplierEntries(supplierList);
    } catch (Exception ex) {
      ex.printStackTrace();
      prod.setSupplierEntries(null);
    }
    return prod;
  }

  /** {@inheritDoc} */
  @Override
  public int create(Product product) {
    if (productDAO.create(product) > 0) {

      // create new price
      CreateResponse rs =
          priceService.create(
              CreateRequest.newBuilder()
                  .setPrice(product.getPrice())
                  .setProductId(product.getId())
                  .build());
      return product.getId();
    } else {
      return -1;
    }
  }

  /** {@inheritDoc} */
  @Override
  public int update(Product product) {
    Product prod_old = findByid(product.getId());

    if (prod_old.getPrice() != product.getPrice()) {
      CreateResponse rs =
          priceService.create(
              CreateRequest.newBuilder()
                  .setPrice(product.getPrice())
                  .setProductId(product.getId())
                  .build());
      if (rs.getId() >= 0) {
        return productDAO.update(product);
      } else {
        return -1;
      }
    } else {
      return productDAO.update(product);
    }
  }

  /** {@inheritDoc} */
  @Override
  public Boolean delete(int id) {
    if (productDAO.delete(id)) {
      DeleteResponse rs = priceService.delete(DeleteRequest.newBuilder().setProductId(id).build());
      DeleteSPResponse rs1 =
          supplierService.deleteSPByProductId(
              DeleteSPRequest.newBuilder().setProductId(id).build());
      return true;
    } else {
      return false;
    }
  }
}
