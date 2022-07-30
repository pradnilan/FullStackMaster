package com.example.controller;

import com.example.entity.PersonEntity;
import com.example.entity.Response;
import com.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api1/person")
public class MainController {

    @Autowired
    PersonService svc;

    @PostMapping("")
    public ResponseEntity<Object> addPerson(@RequestBody PersonEntity entity){
        PersonEntity obj= svc.addPerson(entity);
        if(obj!=null) return new ResponseEntity<Object>(obj, HttpStatus.CREATED);
        else return new ResponseEntity<Object>("Error creating person",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("")
    public List<PersonEntity> getAll(){
        return svc.getAll();
    }

    @GetMapping("/{personId}")
    public ResponseEntity<Object> getPersonWithHobby(@PathVariable int personId){
        Response response=svc.getPersonWithHobby(personId);
        if(response!=null)
            return new ResponseEntity<Object>(response,HttpStatus.OK);
        else return new ResponseEntity<Object>("User not found",HttpStatus.NOT_FOUND);
    }

}
