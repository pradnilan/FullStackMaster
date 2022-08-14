package com.simplilearn.service;

import com.simplilearn.entity.CategoryEntity;
import com.simplilearn.repository.CategoryRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data@NoArgsConstructor@AllArgsConstructor
public class CategoryService {

    @Autowired
    private CategoryRepo repo;

    public CategoryEntity save(CategoryEntity entity){

        return repo.save(entity);
    }

    public List<CategoryEntity> getAll(){
        return repo.findAll();
    }

    public CategoryEntity findById(int id){
        if(repo.findById(id).isPresent())
            return repo.findById(id).get();
        else return null;
    }

    public CategoryEntity updateById(CategoryEntity entity, int id){
        if(repo.findById(id).isPresent()){
            CategoryEntity object= repo.findById(id).get();
            object.setCategoryName(entity.getCategoryName());
            object.setCategoryDescription(entity.getCategoryDescription());
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
