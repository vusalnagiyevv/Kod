package com.example.TikintiMateriallari.controllers.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class PaymentsController {


    @GetMapping("/payments")
    public String payments() {
        return "admin/payments/index.html";
    }

}
