package com.example.TikintiMateriallari.services;

public interface EmailService {

    boolean getConfirmationEmail(String token, String email);

}
