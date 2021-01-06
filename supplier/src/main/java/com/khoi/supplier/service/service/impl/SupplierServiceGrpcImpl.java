package com.khoi.supplier.service.service.impl;

import com.khoi.supplier.dao.ISuppProdDAO;
import com.khoi.supplier.dao.ISupplierDAO;
import com.khoi.supplier.dto.Supplier;
import com.khoi.supplierproto.*;
import io.grpc.stub.StreamObserver;
import java.util.List;
import java.util.stream.Collectors;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GRpcService
public class SupplierServiceGrpcImpl extends SupplierServiceGrpc.SupplierServiceImplBase {

  @Autowired
  ISupplierDAO supplierDAO;

  @Autowired
  ISuppProdDAO suppProdDAO;

  /**
   * <p>This method gets supplier ID list that supply given product</p>
   *
   * @param request Contains product ID needs to be retrieved supplier ID list that supply this
   * product
   * @param responseObserver Contains List of supplier ID supply given product and send back to gRPC
   * client
   */
  @Override
  public void getSupplierListByProductId(GetSupplierListRequest request,
      StreamObserver<SupplierEntry> responseObserver) {
    //get supplier id list
    List<Integer> supplierIdList = suppProdDAO.getListSupplierIdByProductId(request.getProductId());
    List<Supplier> supplierList = supplierIdList.stream().map(p -> supplierDAO.findByid(p)).
        collect(Collectors.toList());

    supplierList.stream().forEach(e -> {
      responseObserver.onNext(e.toProto());
    });
    responseObserver.onCompleted();
  }

  /**
   * <p>This method gets Supplier name of given supplier ID</p>
   *
   * @param request Contains supplier ID needs to retrieves its name
   * @param streamObserver Contains name of given supplier ID and send it back to gRPC client
   */
  @Override
  public void getSupplierNameById(GetSupplierNameByIdRequest request,
      StreamObserver<GetSupplierNameByIdResponse> streamObserver) {
    String supplier_name = supplierDAO.getSupplierNameById(request.getSupplierId());
    streamObserver.onNext(
        GetSupplierNameByIdResponse.newBuilder().setSupplierName(supplier_name).buildPartial());
    streamObserver.onCompleted();
  }

  @Override
  public void deleteSPByProductId(DeleteSPRequest request, StreamObserver<DeleteSPResponse> streamObserver ) {
    int result = suppProdDAO.deleteByProductId(request.getProductId());
    if(result >= 0) {
      streamObserver.onNext(DeleteSPResponse.newBuilder().setResponse(result).build());
      streamObserver.onCompleted();
    }
  }

}
