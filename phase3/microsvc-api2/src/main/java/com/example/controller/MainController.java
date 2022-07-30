package com.example.controller;

import com.example.entity.HobbyEntity;
import com.example.service.HobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Repository
@RequestMapping("/api2/hobby")
public class MainController {

    @Autowired
    HobbyService svc;

    @PostMapping("")
    public ResponseEntity<Object> addHobby(@RequestBody HobbyEntity entity){
        HobbyEntity resp=svc.addHobby(entity);

        if(resp!=null)
            return new ResponseEntity<Object>(resp, HttpStatus.CREATED);
        else
            return new ResponseEntity<Object>("error in saving hobby",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("")
    public List<HobbyEntity> getAllHobby(){
        return svc.getAll();
    }

    @GetMapping("/{personId}")
    public ResponseEntity<String> getHobbyByPersonId(@PathVariable int personId){
        String data=svc.getHobbyByPersonId(personId);
        if(data!=null)
            return new ResponseEntity<String>(data,HttpStatus.FOUND);
        else
            return new ResponseEntity<String>("No hobby found",HttpStatus.NOT_FOUND);
    }

}
