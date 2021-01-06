package com.khoi.supplier.service;

import com.khoi.basecrud.service.IBaseService;
import com.khoi.supplier.dto.Supplier;

public interface ISupplierService extends IBaseService<Supplier, Integer> {

  /**
   * <p>This method get information of a supplier using given supplier ID</p>
   *
   * @param supplier_id Supplier ID needs to be retrieved its information
   * @return Information of a supplier in Supplier type
   */
  Supplier findById(int supplier_id);
}
