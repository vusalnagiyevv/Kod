package com.example.TikintiMateriallari.services;

import com.example.TikintiMateriallari.dtos.auth.RegisterDto;
import com.example.TikintiMateriallari.models.User;

public interface UserService {
    void register(RegisterDto registerDto);
    User getUserByEmail(String email);

    void verifyUser(String token);
}
