package com.example.gameshop.models.utils;

import com.example.gameshop.models.User;
import com.example.gameshop.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class LoginUtil {

    public static UserRepository userRepository;
    public static boolean isLoggedIn() {
        UserDetails loggedUser = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (loggedUser != null){
            return true;
        }else {
            return false;
        }
    }
}
