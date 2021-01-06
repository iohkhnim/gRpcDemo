package com.khoi.price.dao;

import com.khoi.basecrud.dao.IBaseDAO;
import com.khoi.price.dto.Price;
import java.util.List;

public interface IPriceDAO extends IBaseDAO<Price, Integer> {

  /**
   * <p>This method gets all prices of given product ID</p>
   *
   * @param product_id product ID needs to be retrieved all prices
   * @return prices of given product ID
   */
  List<Integer> findPrices(int product_id);

  /**
   * <p>This method gets a list contains price history of a product</p>
   *
   * @param product_id product ID needs to be retrieved price history
   * @return List of Price objects
   */
  List<Price> findProductPriceHistory(int product_id);

  /**
   * <p>This method gets the newest price of given product ID</p>
   *
   * @param product_id product ID needs to be retrieved price
   * @return price of given product ID
   */
  int findPrice(int product_id);

  /**
   * <p>This method deletes all prices related to given product ID</p>
   *
   * @param product_id product ID needs to be deleted all its prices
   * @return Return a boolean value according to result
   */
  Boolean deleteByProductId(int product_id);
}
