package com.simplilearn.service;

import com.simplilearn.entity.ProfileEntity;
import com.simplilearn.repository.ProfileRepo;
import com.simplilearn.repository.ProfileRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data@NoArgsConstructor@AllArgsConstructor
public class ProfileService {

    @Autowired
    private ProfileRepo repo;

    public ProfileEntity save(ProfileEntity entity){

        return repo.save(entity);
    }

    public List<ProfileEntity> getAll(){
        return repo.findAll();
    }

    public ProfileEntity findById(int id){
        if(repo.findById(id).isPresent())
            return repo.findById(id).get();
        else return null;
    }

    public ProfileEntity updateById(ProfileEntity entity, int id){
        if(repo.findById(id).isPresent()){
            ProfileEntity object= repo.findById(id).get();
            object.setRole(entity.getRole());
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
