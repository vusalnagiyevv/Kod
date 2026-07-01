package com.example.TikintiMateriallari.repositories;

import com.example.TikintiMateriallari.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String username);

    User findByConfirmationCode(String token);
}
