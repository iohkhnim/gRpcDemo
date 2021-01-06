package com.khoi.supplier.service;

import com.khoi.supplier.dto.Supplier_Product;
import java.util.List;

public interface ISuppProdService {

  /**
   * <p>This method passes value to DAO in order to create a Supplier_Product in database</p>
   *
   * @param sp Supplier_Product object contains information
   * @return Return a boolean value according to result
   */
  Boolean create(Supplier_Product sp);

  /**
   * <p>This method passes value to DAO in order to update a Supplier_Product in database</p>
   *
   * @param sp Supplier_Product object contains information
   * @return Return a boolean value according to result
   */
  Boolean update(Supplier_Product sp);

  /**
   * <p>This method passes value to DAO in order to get a list of product ID sold by given
   * supplier</p>
   *
   * @param supplier_id supplier ID needs to be retrieved its product id
   * @return List of product ID sold by given supplier
   */
  List<Integer> getListProductIdBySupplierId(int supplier_id);

  /**
   * <p>This method passes value to DAO in order to get a list of supplier ID supply given
   * product</p>
   *
   * @param product_id product ID needs to be retrieves its suppliers
   * @return List of supplier ID supply given product
   */
  List<Integer> getListSupplierIdByProductId(int product_id);
}
