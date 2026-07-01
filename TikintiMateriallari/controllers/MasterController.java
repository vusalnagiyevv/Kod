package com.example.TikintiMateriallari.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MasterController {

    @GetMapping("/master")
    public String master(){
        return "master/master.html";
    }


    @GetMapping("/masterdetail")
    public String masterdetail(){
        return "service/masterdetail.html";
    }


}
