package com.example.springboard.domain.auth;

import com.example.springboard.domain.user.UserService;
import com.example.springboard.domain.user.entity.User;
import com.example.springboard.global.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * fileName     : AuthController.java
 * author       : hyunseo
 * date         : 2025. 3. 12.
 * description  : Auth Controller
 */

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> request) {
        User user = userService.addUser(request.get("username"), request.get("password"));
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.get("username"), request.get("password")));

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.get("username"));

        String token = jwtTokenProvider.generateToken(userDetails.getUsername());
        return ResponseEntity.ok(Map.of("token", token));

    }
}
