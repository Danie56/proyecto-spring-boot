package com.example.proyecto_spring_boot.user.infrastructura;

import com.example.proyecto_spring_boot.common.infrastructure.services.JwtService;
import com.example.proyecto_spring_boot.user.infrastructura.dto.LoginRequestDto;
import com.example.proyecto_spring_boot.user.infrastructura.dto.LoginResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final JwtService jwtService;
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> generateToken (@RequestBody LoginRequestDto loginRequest){
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        String token = jwtService.generateToken(user);
        return ResponseEntity.ok(new LoginResponseDto(token));

    }

}
