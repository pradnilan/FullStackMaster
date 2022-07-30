package com.example.service;

import com.example.entity.HobbyEntity;
import com.example.repository.HobbyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HobbyService {

    @Autowired
    HobbyRepository repo;

    public HobbyEntity addHobby(HobbyEntity entity){
        return repo.save(entity);
    }

    public List<HobbyEntity> getAll(){
        return repo.findAll();
    }

    public String getHobbyByPersonId(int personId){
        return repo.findHobbyByPersonId(personId);
    }


}
