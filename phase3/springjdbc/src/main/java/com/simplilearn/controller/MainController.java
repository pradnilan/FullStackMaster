package com.simplilearn.controller;

import com.simplilearn.entity.EProductDao;
import com.simplilearn.entity.EProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@SuppressWarnings("ALL")
@Controller

public class MainController {

    @Autowired
    private EProductDao dao;

    @GetMapping("/getdata")
    public String getData(ModelMap map){
        List<EProductEntity> list=dao.getAllProducts();
        map.addAttribute("list",list);
        return "display";
    }

    @PostMapping("/details")
    public String getById(ModelMap map, HttpServletRequest request){
        String id=request.getParameter("id");
        long uid=Long.parseLong(id);
        EProductEntity entity=dao.getProductById(uid);
        if(entity!=null){
            map.addAttribute("product",entity);
            return "details";
        }else return "error";
    }

    @GetMapping("/edit")
    public String updateProduct(@PathVariable String id, HttpServletRequest request){

        return "edit";
    }





}
