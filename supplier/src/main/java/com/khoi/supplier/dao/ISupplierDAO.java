package com.khoi.supplier.dao;

import com.khoi.basecrud.dao.IBaseDAO;
import com.khoi.supplier.dto.Supplier;

public interface ISupplierDAO extends IBaseDAO<Supplier, Integer> {

  /**
   * <p>This method gets Supplier name of given supplier ID</p>
   * @param supplier_id supplier ID needs to retrieves its name
   * @return supplier name of an given supplier ID
   */
  String getSupplierNameById(int supplier_id);
}
