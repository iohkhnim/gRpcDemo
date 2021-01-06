/*package com.khoi.price.service.service.impl;

import com.khoi.basecrud.service.service.impl.BaseServiceImpl;
import com.khoi.price.dao.IPriceDAO;
import com.khoi.price.dto.Price;
import com.khoi.price.service.IPriceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceServiceImpl extends BaseServiceImpl<Price, Integer> implements IPriceService {

  @Autowired
  private IPriceDAO priceDAO;

  @Override
  public List<Integer> findPrice(int product_id) {
    return priceDAO.findPrice(product_id);
  }

  @Override
  public List<Integer> findPrices(int product_id) {
    return priceDAO.findPrices(product_id);
  }

  @Override
  public List<Price> findProductPriceHistory(int product_id) {
    return priceDAO.findProductPriceHistory(product_id);
  }

  @Override
  public int findPrice2(int product_id) {
    return priceDAO.findPrice2(product_id);
  }

  @Override
  public Boolean deleteByProductId(int product_id) {
    return priceDAO.deleteByProductId(product_id);
  }
}
*/