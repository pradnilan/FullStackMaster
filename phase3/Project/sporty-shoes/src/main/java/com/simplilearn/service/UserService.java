package com.simplilearn.service;

import com.simplilearn.entity.UserEntity;
import com.simplilearn.repository.UserRepo;
import com.simplilearn.repository.UserRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data@NoArgsConstructor@AllArgsConstructor
public class UserService {

    @Autowired
    private UserRepo repo;

    public UserEntity save(UserEntity entity){

        return repo.save(entity);
    }

    public List<UserEntity> getAll(){
        return repo.findAll();
    }

    public UserEntity findById(int id){
        if(repo.findById(id).isPresent())
            return repo.findById(id).get();
        else return null;
    }

    public UserEntity updateById(UserEntity entity, int id){
        if(repo.findById(id).isPresent()){
            UserEntity object= repo.findById(id).get();
            object.setFirstName(entity.getLastName());
            object.setLastName(entity.getUserName());
            object.setPassword(entity.getPassword());
            object.setMobile(entity.getMobile());
            object.setEmail(entity.getEmail());
            object.setAddress(entity.getAddress());
            object.setProfile(entity.getProfile());

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

    public UserEntity getUserByUserName(String userName){
        UserEntity user=repo.findUserEntitiesByUserName(userName);
        if(user!=null)
            return user;
        else
            return null;

    }


}
