package com.example.controller;

import com.example.entity.UserEntity;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/users")
    public ResponseEntity<Object> addUser(@RequestBody UserEntity entity){
        UserEntity resp=service.saveUser(entity);
        if(resp!=null){
            return new ResponseEntity<Object>(resp, HttpStatus.CREATED);
        } else return new ResponseEntity<Object>("Error while inserting data", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/users")
    public List<UserEntity> getAllUsers(){
        return service.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable int id){
        UserEntity obj=service.findById(id);
        if(obj!=null)
            return new ResponseEntity<Object>(obj,HttpStatus.FOUND);
        else return new ResponseEntity<Object>("No user found",HttpStatus.NOT_FOUND);
    }

    @PostMapping("/users/{id}")
    public ResponseEntity<Object> updateUser(@RequestBody UserEntity entity, @PathVariable int id){
        UserEntity obj=service.updateUser(entity,id);
        if(obj!=null)
            return new ResponseEntity<Object>(obj,HttpStatus.OK);
        else
            return new ResponseEntity<Object>("No user available to update",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable int id){
        if(service.deleteUserByID(id))
            return new ResponseEntity<Object>("Entity deleted",HttpStatus.OK);
        else
            return new ResponseEntity<Object>("No user found to delete",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/hi")
    public ResponseEntity<Object> hello(){
        return new ResponseEntity<Object>("Hello",HttpStatus.OK);
    }
}
