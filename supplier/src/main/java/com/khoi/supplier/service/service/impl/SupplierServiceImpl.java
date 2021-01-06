package com.khoi.supplier.service.service.impl;

import com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer;
import com.googlecode.protobuf.format.JsonFormat;
import com.khoi.basecrud.service.service.impl.BaseServiceImpl;
import com.khoi.productproto.GetProductRequest;
import com.khoi.productproto.ProductEntry;
import com.khoi.productproto.ProductServiceGrpc;
import com.khoi.supplier.dto.Supplier;
import com.khoi.supplier.service.ISuppProdService;
import com.khoi.supplier.service.ISupplierService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.khoi.supplier.dto.Supplier_Product;

@Service
public class SupplierServiceImpl extends BaseServiceImpl<Supplier, Integer> implements
    ISupplierService {

  @Qualifier("productService")
  private final ProductServiceGrpc.ProductServiceBlockingStub productService;
  @Autowired
  ISuppProdService suppProdService;

  public SupplierServiceImpl(ProductServiceGrpc.ProductServiceBlockingStub productService) {
    this.productService = productService;
  }

  @Override
  public Boolean update(Supplier supplier) {
    if(super.update(supplier)) {
      Supplier_Product sp = new Supplier_Product();
      sp.setProduct_id(supplier.getProduct_id());
      sp.setSupplier_id(supplier.getId());
      suppProdService.update(sp);
      return true;
    }
    return false;
  }

  @Override
  public int create(Supplier supplier) {
    int id = super.create(supplier);
    if(id > 0) {
      if (supplier.getProduct_id() > 0) {
        Supplier_Product sp = new Supplier_Product();
        sp.setProduct_id(supplier.getProduct_id());
        sp.setSupplier_id(id);
        suppProdService.create(sp);
      }
      return id;
    }
    return -1;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Supplier findById(int id) {
    Supplier supplier = super.findByid(id);

    //get list of product
    List<Integer> idList = suppProdService.getListProductIdBySupplierId(id);

    List<ProductEntry> productEntryList = idList.stream().map(p -> productService.getProduct(
        GetProductRequest.newBuilder().setProductId(p).build())).collect(Collectors.toList());

    List<String> productList = productEntryList.stream().map(p -> new JsonFormat().printToString(p))
        .collect(Collectors.toList());
    supplier.setProducts(productList);

    return supplier;
  }
}
