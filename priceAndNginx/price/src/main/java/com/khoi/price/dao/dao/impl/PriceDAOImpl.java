package com.khoi.price.dao.dao.impl;

import com.khoi.basecrud.dao.dao.impl.BaseDAOImpl;
import com.khoi.price.dao.IPriceDAO;
import com.khoi.price.dto.Price;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class PriceDAOImpl extends BaseDAOImpl<Price, Integer> implements IPriceDAO {

  /**
   * {@inheritDoc}
   */
  @Override
  public int findPrice(int product_id) {
    String hql = "SELECT obj.price FROM Price obj WHERE obj.product_id = :prodid ORDER BY obj.createdTime DESC";
    Query query = entityManager.createQuery(hql);
    query.setParameter("prodid", product_id);
    return Integer.parseInt(query.setMaxResults(1).getSingleResult().toString());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Integer> findPrices(int product_id) {
    String hql = "SELECT obj.price FROM Price obj WHERE obj.product_id = " + product_id
        + " ORDER BY obj.createdTime DESC";
    Query query = entityManager.createQuery(hql, Integer.class);
    List<Integer> a = (List<Integer>) query.getResultList();
    return a;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Price> findProductPriceHistory(int product_id) {
    String hql = "FROM Price as price WHERE price.product_id = " + product_id
        + " ORDER BY price.createdTime DESC";
    return (List<Price>) entityManager.createQuery(hql, Price.class).getResultList();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Boolean deleteByProductId(int product_id) {
    try {
      String hql = "DELETE FROM Price p WHERE p.product_id = :pid";
      Query query = entityManager.createQuery(hql).setParameter("pid", product_id);
      query.executeUpdate();
      return true;
    } catch (Exception ex) {
      return false;
    }
  }

}
