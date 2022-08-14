package com.example.resttemp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.ServerRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class FCUController {


    List<FCU>  fcus;

    public FCUController() {

        FCU fcu1=new FCU(1,true,false, (float) (Math.random()*10+20),25,false);
        FCU fcu2=new FCU(2,true,false, (float) (Math.random()*10+20),25,false);
        FCU fcu3=new FCU(3,true,false, (float) (Math.random()*10+20),25,false);

        fcus=new ArrayList<FCU>();

        fcus.add(fcu1);
        fcus.add(fcu2);
        fcus.add(fcu3);


    }



    @GetMapping("fcu")
    public ResponseEntity<Object> getAll(){
        return new ResponseEntity<Object> (fcus, HttpStatus.OK);
    }

    @GetMapping("fcu/{id}")
    public ResponseEntity<Object> getById(@PathVariable int id){
        if(id<=fcus.size())
            return new ResponseEntity<Object>(fcus.get(id-1),HttpStatus.OK);
        else
            return new ResponseEntity<Object>("FCU can not find",HttpStatus.NOT_FOUND);
    }

    @PostMapping("fcu/cmd/{id}")
    public ResponseEntity<Object> setCmd(@RequestHeader("cmd") boolean cmd,@PathVariable int id){
        if(id<=fcus.size()) {

            FCU oldFcu = fcus.get(id - 1);
            oldFcu.setCmd(cmd);
            int i=id-1;
//            fcus.remove(2);
            fcus.remove(i);
            fcus.add(i, oldFcu);

            return new ResponseEntity<Object>(fcus.get(id - 1), HttpStatus.OK);
        }
        else return new ResponseEntity<Object>("FCU can not find",HttpStatus.NOT_FOUND);
    }

    @PostMapping("fcu/rmtsp/{id}")
    public ResponseEntity<Object> setRmtSp(@RequestHeader("rmtsp") float rmtSp ,@PathVariable int id){

        if(id<=fcus.size()) {

            FCU oldFcu = fcus.get(id - 1);
            oldFcu.setRmt_sp(rmtSp);
            int i=id-1;
            fcus.remove(i);
            fcus.add(i, oldFcu);

            return new ResponseEntity<Object>(fcus.get(i), HttpStatus.OK);
        }
        else return new ResponseEntity<Object>("FCU can not find",HttpStatus.NOT_FOUND);

    }

}
