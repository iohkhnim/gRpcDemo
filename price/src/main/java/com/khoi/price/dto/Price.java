package com.khoi.price.dto;

import com.khoi.basecrud.dto.baseDTO;
import com.khoi.proto.CreateRequest;
import com.khoi.proto.PriceEntry;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "price")
public class Price extends baseDTO implements Serializable {

  @Column(name = "product_id")
  private int product_id;

  @Column(name = "price")
  private int price;

  /**
   * <p>This method map CreateRequest type to Price type</p>
   *
   * @param proto CreateRequest object
   * @return Price object
   */
  public static Price fromProto(CreateRequest proto) {
    Price price = new Price();
    price.setPrice(proto.getPrice());
    price.setProduct_id(proto.getProductId());
    return price;
  }

  /**
   * <p>Convert date in Date type to String type</p>
   *
   * @param date date in Date type
   * @return Date in String type
   */
  private String convertDate2String(Date date) {
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    return dateFormat.format(date);
  }

  public int getProduct_id() {
    return product_id;
  }

  public void setProduct_id(int product_id) {
    this.product_id = product_id;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  /**
   * <p>This method map PriceEntry type to CreateRequest type</p>
   *
   * @return CreateRequest object
   */
  public PriceEntry toProto() {
    return PriceEntry.newBuilder().setId(getId()).setProductId(getProduct_id())
        .setPrice(getPrice()).setCreatedTime(convertDate2String(getCreatedTime()))
        .setUpdatedTime(convertDate2String(getUpdatedTime())).build();
  }
}
