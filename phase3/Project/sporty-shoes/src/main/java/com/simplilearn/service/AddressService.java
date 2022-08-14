package com.simplilearn.service;

import com.simplilearn.entity.AddressEntity;
import com.simplilearn.repository.AddressRepo;
import com.simplilearn.repository.AddressRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data@NoArgsConstructor@AllArgsConstructor
public class AddressService {

    @Autowired
    private AddressRepo repo;

    public AddressEntity save(AddressEntity entity){

        return repo.save(entity);
    }

    public List<AddressEntity> getAll(){
        return repo.findAll();
    }

    public AddressEntity findById(int id){
        if(repo.findById(id).isPresent())
            return repo.findById(id).get();
        else return null;
    }

    public AddressEntity updateById(AddressEntity entity, int id){
        if(repo.findById(id).isPresent()){
            AddressEntity object= repo.findById(id).get();
            object.setAddressId(entity.getAddressId());
            object.setUnitNo(entity.getUnitNo());
            object.setStreet(entity.getStreet());
            object.setCity(entity.getCity());
            object.setCountry(entity.getCountry());
            object.setZipCode(entity.getZipCode());
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
