package com.khoi.supplier.dao;

import com.khoi.supplier.dto.Supplier_Product;
import java.util.List;

public interface ISuppProdDAO {

  /**
   * <p>This method inserts into database with given information</p>
   *
   * @param sp Supplier_Product object contains information
   * @return a boolean value according to result
   */
  Boolean create(Supplier_Product sp);

  /**
   * <p>This method update database with given information</p>
   *
   * @param sp Supplier_Product object contains information
   * @return a boolean value according to result
   */
  Boolean update(Supplier_Product sp);

  /**
   * <p>This method gets a list of product ID sold by given supplier ID</p>
   *
   * @param supplier_id Supplier ID needs to be retrieves product ids list
   * @return List of product ID sold by given supplier
   */
  List<Integer> getListProductIdBySupplierId(int supplier_id);

  /**
   * <p>This method gets a list of supplier ID supply given product</p>
   *
   * @param product_id product ID needs to be retrieves supplier list
   * @return List of supplier ID supply given product
   */
  List<Integer> getListSupplierIdByProductId(int product_id);

  int deleteByProductId(int product_id);
}
