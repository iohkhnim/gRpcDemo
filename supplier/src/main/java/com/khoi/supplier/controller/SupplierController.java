package com.khoi.supplier.controller;

import com.khoi.supplier.dto.Supplier;
import com.khoi.supplier.dto.Supplier_Product;
import com.khoi.supplier.service.ISuppProdService;
import com.khoi.supplier.service.ISupplierService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("supplier")
public class SupplierController {

  @Autowired
  private ISupplierService supplierService;

  @Autowired
  private ISuppProdService suppProdService;

  /**
   * <p>An API endpoint (/supplier/sp/create) with method POST creates a supplier_product</p>
   * @param sp Supplier_Product information
   * @return Https status according to result
   */
  @PostMapping("sp/create")
  public ResponseEntity<Void> createSP(@RequestBody Supplier_Product sp) {
    Boolean flag = suppProdService.create(sp);
    if (flag.equals(true)) {
      return new ResponseEntity<Void>(HttpStatus.CREATED);
    } else {
      return new ResponseEntity<Void>(HttpStatus.CONFLICT);
    }
  }

  /**
   * <p>An API endpoint (/supplier/sp/update) with method PUT updates a supplier_product</p>
   * @param sp supplier_product information
   * @return Https status according to result
   */
  @PutMapping("sp/update")
  public ResponseEntity<Void> updateSP(@RequestBody Supplier_Product sp) {
    Boolean flag = suppProdService.update(sp);
    if (flag.equals(true)) {
      return new ResponseEntity<Void>(HttpStatus.CREATED);
    } else {
      return new ResponseEntity<Void>(HttpStatus.CONFLICT);
    }
  }

  /**
   * <p>An API endpoint (/supplier/create) with method POST creates a supplier</p>
   * @param supplier supplier information
   * @return Https status according to result
   */
  @PostMapping("create")
  public ResponseEntity<Void> create(@RequestBody Supplier supplier) {
    int id = supplierService.create(supplier);
    if (id > 0) {
      return new ResponseEntity<Void>(HttpStatus.OK);
    } else {
      return new ResponseEntity<Void>(HttpStatus.CONFLICT);
    }
  }

  /**
   * <p>An API endpoint (/supplier/update) with method PUT updates a supplier</p>
   * @param supplier supplier information
   * @return Https status according to result
   */
  @PutMapping("update")
  public ResponseEntity<Void> update(@RequestBody Supplier supplier) {
    Boolean flag = supplierService.update(supplier);
    if (flag.equals(true)) {
      return new ResponseEntity<Void>(HttpStatus.OK);
    } else {
      return new ResponseEntity<Void>(HttpStatus.CONFLICT);
    }
  }

  /**
   * <p>An API endpoint (/supplier/findAll) with method GET gets information of all suppliers </p>
   * @return Return all suppliers information
   */
  @GetMapping("findAll")
  public ResponseEntity<List<Supplier>> findAll() {
    List<Supplier> list = supplierService.findAll();
    return new ResponseEntity<List<Supplier>>(list, HttpStatus.OK);
  }

  /**
   * <p>An API endpoint (/product/findById/{id}) with method GET gets information of given supplier ID</p>
   * @param id Supplier ID
   * @return Return information of given Supplier ID
   */
  @GetMapping("findById/{id}")
  public ResponseEntity<Supplier> findByid(@PathVariable("id") int id) {
    Supplier obj = supplierService.findById(id);
    return new ResponseEntity<Supplier>(obj, HttpStatus.OK);
  }
}
