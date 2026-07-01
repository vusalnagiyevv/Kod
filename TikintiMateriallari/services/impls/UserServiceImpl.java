package com.example.TikintiMateriallari.services.impls;

import com.example.TikintiMateriallari.dtos.auth.RegisterDto;
import com.example.TikintiMateriallari.models.User;
import com.example.TikintiMateriallari.repositories.UserRepository;
import com.example.TikintiMateriallari.services.EmailService;
import com.example.TikintiMateriallari.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;

    @Override
    public void register(RegisterDto registerDto) {
        User user = new User();
        String password = passwordEncoder.encode(registerDto.getPassword());
        user.setEmail(registerDto.getEmail());
        user.setPassword(password);
        user.setFirstName(registerDto.getFirstName());
        user.setLastName(registerDto.getLastName());
        String activationCode = UUID.randomUUID().toString().replace("-", "");



        user.setConfirmationCode(activationCode);
        user.setEnabled(true);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);

        Date date = new Date();
        date.setTime(date.getTime() + 60000);
        user.setConfirmationExpiredCodeDate(date);
        emailService.getConfirmationEmail(activationCode,registerDto.getEmail());
        userRepository.save(user);


    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void verifyUser(String token) {

        User findUser = userRepository.findByConfirmationCode(token);
        if (findUser != null && findUser.getConfirmationExpiredCodeDate().after(new Date())) {
            findUser.setConfirmationCode(null);
            findUser.setEnabled(true);
            findUser.setConfirmationExpiredCodeDate(null);
            findUser.setAccountNonExpired(true);
            findUser.setAccountNonLocked(true);
            findUser.setCredentialsNonExpired(true);
            userRepository.save(findUser);
        }

    }
}
