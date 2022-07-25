package com.simplileran;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class FileUpload {

    @PostMapping("/upload")
    public String fileUpload(@RequestParam("file")MultipartFile file){

        String msg="";

        try{
            byte[] bytes=file.getBytes();
            Path path= Paths.get("C:\\Programming\\file\\"+file.getOriginalFilename());
            Files.write(path,bytes);
            msg="File uploaded successfully";
        }catch (Exception e){
            msg="Error Occurred "+e.getMessage();
        }
        return msg;
    }

}
