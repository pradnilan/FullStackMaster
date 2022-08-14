package com.simplilearn.controller;

import com.simplilearn.entity.ProductEntity;
import com.simplilearn.service.CategoryService;
import com.simplilearn.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService svc;

    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody ProductEntity product){
        ProductEntity resp=svc.save(product);
        if(resp!=null)
            return new ResponseEntity<Object>(resp, HttpStatus.CREATED);
        else
            return new ResponseEntity<Object>("Entity creation failed", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("")
    public ResponseEntity<Object> findAll(){
        List<ProductEntity> resp=svc.getAll();
        if(!resp.isEmpty())
            return new ResponseEntity<Object>(resp,HttpStatus.OK);
        else
            return new ResponseEntity<Object>("Records not found",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable int id){
        ProductEntity resp=svc.findById(id);
        if(resp!=null)
            return new ResponseEntity<Object>(resp, HttpStatus.FOUND);
        else
            return new ResponseEntity<Object>("Record not found", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable int id){
        if(svc.deleteById(id))
            return new ResponseEntity<Object>("Record deleted",HttpStatus.OK);
        else
            return new ResponseEntity<Object>("No user found to delete",HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateById(@RequestBody ProductEntity product, @PathVariable int id){
        ProductEntity resp=svc.updateById(product,id);
        if(resp!=null)
            return new ResponseEntity<Object>(resp,HttpStatus.CREATED);
        else
            return new ResponseEntity<Object>("Record not found",HttpStatus.NOT_FOUND);
    }

}
