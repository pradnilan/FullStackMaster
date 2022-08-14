package com.simplilearn.service;

import com.simplilearn.entity.ProductEntity;
import com.simplilearn.repository.ProductRepo;
import com.simplilearn.repository.ProductRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data@NoArgsConstructor@AllArgsConstructor
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public ProductEntity save(ProductEntity entity){
        return repo.save(entity);
    }

    public List<ProductEntity> getAll(){
        return repo.findAll();
    }

    public ProductEntity findById(int id){
        if(repo.findById(id).isPresent())
            return repo.findById(id).get();
        else return null;
    }

    public ProductEntity updateById(ProductEntity entity, int id){
        if(repo.findById(id).isPresent()){
            ProductEntity object= repo.findById(id).get();
            object.setProductName(entity.getProductName());
            object.setPrice(entity.getPrice());
            object.setSize(entity.getSize());
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


}
