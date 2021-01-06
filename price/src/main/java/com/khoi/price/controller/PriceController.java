/*package com.khoi.price.controller;

import com.khoi.price.dto.Price;
import com.khoi.price.service.IPriceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("price")
public class PriceController {

  @Autowired
  private IPriceService priceService;

  @GetMapping("findAll")
  public ResponseEntity<List<Price>> findAll() {
    List<Price> list = priceService.findAll();
    return new ResponseEntity<List<Price>>(list, HttpStatus.OK);
  }

  @GetMapping("{id}")
  public ResponseEntity<Price> findByid(@PathVariable("id") int id) {
    Price obj = priceService.findByid(id);
    return new ResponseEntity<Price>(obj, HttpStatus.OK);
  }

  @PostMapping("create")
  public ResponseEntity<Void> create(@RequestBody Price price) {
    Boolean flag = priceService.create(price);
    if (flag.equals(true)) {
      return new ResponseEntity<Void>(HttpStatus.CREATED);
    } else {
      return new ResponseEntity<Void>(HttpStatus.CONFLICT);
    }
  }

  @PutMapping("update")
  public ResponseEntity<Void> update(@RequestBody Price price) {
    Boolean flag = priceService.update(price);
    if (flag.equals(true)) {
      return new ResponseEntity<Void>(HttpStatus.OK);
    } else {
      return new ResponseEntity<Void>(HttpStatus.CONFLICT);
    }
  }

  @DeleteMapping("delete/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") int id) {
    Boolean flag = priceService.delete(id);
    if (flag.equals(true)) {
      return new ResponseEntity<Void>(HttpStatus.OK);
    } else {
      return new ResponseEntity<Void>(HttpStatus.CONFLICT);
    }
  }

  @DeleteMapping("deleteByProductId/{id}")
  public ResponseEntity<Void> deleteByProductId(@PathVariable("id") int pid) {
    Boolean flag = priceService.deleteByProductId(pid);
    if (flag.equals(true)) {
      return new ResponseEntity<Void>(HttpStatus.OK);
    } else {
      return new ResponseEntity<Void>(HttpStatus.CONFLICT);
    }
  }

  @GetMapping("findProductPrice/{product_id}")
  @ResponseBody
  public int findProductPrice2(
      @PathVariable("product_id") int product_id) {
    int i = priceService.findPrice2(product_id);
    return i;
  }

  @GetMapping("findProductPrices/{product_id}")
  public ResponseEntity<List<Integer>> findProductPrices(
      @PathVariable("product_id") int product_id) {
    List<Integer> list = priceService.findPrices(product_id);
    return new ResponseEntity<List<Integer>>(list, HttpStatus.OK);
  }

  @GetMapping("findProductPriceHistory/{product_id}")
  public ResponseEntity<List<Price>> findProductPriceHistory(
      @PathVariable("product_id") int product_id) {
    List<Price> list = priceService.findProductPriceHistory(product_id);
    return new ResponseEntity<List<Price>>(list, HttpStatus.OK);
  }
}
*/