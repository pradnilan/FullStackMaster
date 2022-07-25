package com.example.service;

import com.example.entity.UserEntity;
import com.example.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

   @Autowired
    private UserRepository repository;

   public UserEntity saveUser(UserEntity entity){
       return repository.save(entity);
   }

   public List<UserEntity> getAllUsers(){
       return repository.findAll();
   }

   public UserEntity findById(int id){
       if(repository.findById(id).isPresent()) return repository.findById(id).get();
       else return null;
   }

   public UserEntity updateUser(UserEntity entity,int id){
       if(repository.findById(id).isPresent()){
           UserEntity oldEntity=new UserEntity();
           oldEntity.setName(entity.getName());
           oldEntity.setEmail(entity.getEmail());
           oldEntity.setCity(entity.getCity());
           return repository.save(oldEntity);
       }else return null;

   }

   public boolean deleteUserByID(int id){
       if(repository.findById(id).isPresent()){
           repository.deleteById(id);
           return true;
       }else return false;
   }

}
