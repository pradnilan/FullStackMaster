package com.simplilearn.repository;

import com.simplilearn.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<OrderEntity,Integer> {


    public List<OrderEntity> getOrderEntityByDate(LocalDateTime dateTime);


    //public OrderEntity getOrderEntityByProductCategory();

}
