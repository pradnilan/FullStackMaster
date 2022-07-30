package com.example.service;

import com.example.entity.PersonEntity;
import com.example.entity.Response;
import com.example.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PersonService {

    @Autowired
    PersonRepository repo;
    RestTemplate template=new RestTemplate();

    public PersonEntity addPerson(PersonEntity entity){
        return repo.save(entity);
    }

    public List<PersonEntity> getAll(){
        return repo.findAll();
    }

    public Response getPersonWithHobby(int personId){
        final String url="http://127.0.0.1:8082/api2/hobby/{personId}";
        Map<String,Integer> map=new HashMap<String,Integer>();
        map.put("personId",personId);
        String hobby=template.getForObject(url,String.class,map);

        if(repo.findById(personId).isPresent()) {
            PersonEntity entity = repo.findById(personId).get();
            Response response = new Response();
            response.setEntity(entity);
            response.setHobby(hobby);
            return response;
        } else return null;

    }

}
