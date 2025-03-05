package com.example.springboard.domain.user;

import com.example.springboard.global.response.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * fileName     : UserController.java
 * author       : hyunseo
 * date         : 2025. 3. 5.
 * description  : User Controller
 */
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestParam String userName, @RequestParam String password) {
        return ResponseEntity.ok(ResponseDTO.success("회원가입 성공", userService.register(userName, password)));
    }

    @GetMapping("/{userName}")
    public ResponseEntity<?> getUser(@PathVariable String userName) {
        return ResponseEntity.ok(ResponseDTO.success("사용자 조회 성공", userService.getUser(userName)));
    }
}
