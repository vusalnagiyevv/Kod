package com.example.TikintiMateriallari.dtos.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class RegisterDto {



    @Length(min = 3, max = 20 , message = "Firstname must be between 3 and 20 characters ")
    private String firstName;
    @Length(min = 3 , max = 20 , message = "Lastname must be between 3 and 20 characters")
    private String lastName;
    @Email(message = "Invalid email address")
    private String email;
    @Pattern(regexp = "^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^\\w\\d\\s:])([^\\s]){8,16}$", message = "Password must Include symbols")
    private String password;


}
