package com.khoi.supplier.dto;

import com.khoi.basecrud.dto.baseDTO;
import com.khoi.supplierproto.SupplierEntry;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "supplier")
public class Supplier extends baseDTO implements Serializable {

  @Column(name = "name")
  private String name;

  @Column(name = "address")
  private String address;

  @Transient
  private List<String> products;

  public int getProduct_id() {
    return product_id;
  }

  public void setProduct_id(int product_id) {
    this.product_id = product_id;
  }

  @Transient
  private int product_id;

  /**
   * <p>This method convert date in Date type to date in String type</p>
   * @param date date in Date type
   * @return date in String type
   */
  private String convertDate2String(Date date){
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    return dateFormat.format(date);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public List<String> getProducts() {
    return products;
  }

  public void setProducts(List<String> products) {
    this.products = products;
  }

  /**
   * <p>This method maps Supplier type to SupplierEntry type</p>
   * @return SupplierEntry object
   */
  public SupplierEntry toProto() {
    return SupplierEntry.newBuilder().setId(getId()).setName(getName())
        .setAddress(getAddress()).setCreatedTime(convertDate2String(getCreatedTime()))
        .setUpdatedTime(convertDate2String(getUpdatedTime())).build();
  }
}
