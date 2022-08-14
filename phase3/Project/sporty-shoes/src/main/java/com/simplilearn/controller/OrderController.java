package com.simplilearn.controller;

import com.simplilearn.entity.OrderEntity;
import com.simplilearn.entity.ProductEntity;
import com.simplilearn.service.OrderService;
import com.simplilearn.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService svc;

    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody OrderEntity Order){
        OrderEntity resp=svc.save(Order);
        if(resp!=null)
            return new ResponseEntity<Object>(resp, HttpStatus.CREATED);
        else
            return new ResponseEntity<Object>("Entity creation failed", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("")
    public ResponseEntity<Object> findAll(){
        List<OrderEntity> resp=svc.getAll();
        if(!resp.isEmpty())
            return new ResponseEntity<Object>(resp,HttpStatus.OK);
        else
            return new ResponseEntity<Object>("Records not found",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable int id){
        OrderEntity resp=svc.findById(id);
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
    public ResponseEntity<Object> updateById(@RequestBody OrderEntity Order, @PathVariable int id){
        OrderEntity resp=svc.updateById(Order,id);
        if(resp!=null)
            return new ResponseEntity<Object>(resp,HttpStatus.CREATED);
        else
            return new ResponseEntity<Object>("Record not found",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/bydate/{date}")
    public ResponseEntity<Object> getByDate(LocalDateTime dateTime){
        return new ResponseEntity<Object>(svc.getOrderByDate(dateTime),HttpStatus.OK);
    }

}
