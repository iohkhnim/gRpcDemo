package com.khoi.supplier.dao.dao.impl;

import com.khoi.supplier.dao.ISuppProdDAO;
import com.khoi.supplier.dto.Supplier_Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Transactional
@Repository
public class SuppProdDAOImpl implements ISuppProdDAO {

  @PersistenceContext private EntityManager entityManager;

  /**
   * This method get a supplier_product information
   *
   * @param id supplier_product id needs to be retrieved information
   * @return Return a Supplier_Product object
   */
  private Supplier_Product findByid(int id) {
    Supplier_Product sp = entityManager.find(Supplier_Product.class, id);
    return sp;
  }

  /** {@inheritDoc} */
  @Override
  public Boolean create(Supplier_Product sp) {
    try {
      entityManager.persist(sp);
      return true;
    } catch (Exception ex) {
      return false;
    }
  }

  /** {@inheritDoc} */
  @Override
  public Boolean update(Supplier_Product sp) {
    try {
      entityManager.find(Supplier_Product.class, sp.getId());
      entityManager.merge(sp);
      return true;
    } catch (Exception ex) {
      return false;
    }
  }

  /** {@inheritDoc} */
  @Override
  public List<Integer> getListProductIdBySupplierId(int supplier_id) {
    String hql = "SELECT obj.product_id FROM Supplier_Product obj WHERE obj.supplier_id = :supid";
    Query query = entityManager.createQuery(hql);
    query.setParameter("supid", supplier_id);
    return (List<Integer>) query.getResultList();
  }

  /** {@inheritDoc} */
  @Override
  public List<Integer> getListSupplierIdByProductId(int product_id) {
    String hql = "SELECT obj.supplier_id FROM Supplier_Product obj WHERE obj.product_id = :prodid";
    Query query = entityManager.createQuery(hql);
    query.setParameter("prodid", product_id);
    return (List<Integer>) query.getResultList();
  }

  @Override
  public int deleteByProductId(int product_id) {
    String hql = "DELETE FROM Supplier_Product obj WHERE obj.product_id = :prodid";
    Query query = entityManager.createQuery(hql);
    query.setParameter("prodid", product_id);
    return query.executeUpdate();
  }
}
