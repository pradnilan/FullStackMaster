package com.simplilearn.service;

import com.simplilearn.entity.OrderEntity;
import com.simplilearn.repository.OrderRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Data@NoArgsConstructor@AllArgsConstructor
public class OrderService {

    @Autowired
    private OrderRepo repo;

    public OrderEntity save(OrderEntity entity){

        return repo.save(entity);
    }

    public List<OrderEntity> getAll(){
        return repo.findAll();
    }

    public OrderEntity findById(int id){
        if(repo.findById(id).isPresent())
            return repo.findById(id).get();
        else return null;
    }

    public OrderEntity updateById(OrderEntity entity, int id){
        if(repo.findById(id).isPresent()){
            OrderEntity object= repo.findById(id).get();
            object.setUser(entity.getUser());
            object.setProduct(entity.getProduct());
            object.setDate(entity.getDate());
            object.setPaymentMode(entity.getPaymentMode());
            object.setTotal(entity.getTotal());
            return repo.save(object);
        } else return null;
    }

    public boolean deleteById(int id){
        if(repo.findById(id).isPresent()){
            repo.deleteById(id);
            return true;
        } else
        return false;
    }

    public List<OrderEntity> getOrderByDate(LocalDateTime dateTime){
       return repo.getOrderEntityByDate(dateTime);
    }


}
