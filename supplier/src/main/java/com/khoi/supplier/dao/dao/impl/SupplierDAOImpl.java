package com.khoi.supplier.dao.dao.impl;

import com.khoi.basecrud.dao.dao.impl.BaseDAOImpl;
import com.khoi.supplier.dao.ISupplierDAO;
import com.khoi.supplier.dto.Supplier;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class SupplierDAOImpl extends BaseDAOImpl<Supplier, Integer> implements ISupplierDAO {

  /**
   * {@inheritDoc}
   */
  @Override
  public String getSupplierNameById(int supplier_id) {
    String hql = "SELECT o.name FROM Supplier o WHERE o.id = :id";
    Query query = entityManager.createQuery(hql);
    query.setParameter("id", supplier_id);
    return query.getSingleResult().toString();
  }
}
