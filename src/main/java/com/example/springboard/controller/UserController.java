package com.example.springboard.controller;

import com.example.springboard.domain.user.dto.UserRequestDTO;
import com.example.springboard.domain.user.dto.UserResponseDTO;
import com.example.springboard.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * fileName     : null.java
 * author       : hyunseo
 * date         : 2025. 4. 13.
 * description  :
 */
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 회원 가입 페이지
     * @return
     */
    @GetMapping("/user/join")
    public String joinPage() {
        return "join";
    }

    /**
     * 회원가입 수행
     * @param dto
     * @return
     */
    @PostMapping("/user/join")
    public String joinProcess(UserRequestDTO dto) {
        userService.createOneUser(dto);
        return "redirect:/login";
    }

    /**
     * 회원 수정 페이지
     * @param username
     * @param model
     * @return
     */
    @GetMapping("/user/update/{username}")
    public String updatePage(@PathVariable("username") String username, Model model) {

        // 본인 또는 Admin 권한만 접근 가능
        if(userService.isAccess(username)) {
            UserResponseDTO dto = userService.readOneUser(username);
            model.addAttribute("USER", dto);
            return "update";
        }

        return "redirect:/login";
    }

    @PostMapping("/user/update/{username}")
    public String updateProcess(@PathVariable("username") String username, UserRequestDTO dto) {

        // 본인 또는 Admin 권한만 접근 가능
        if(userService.isAccess(username)) {
            userService.updateOneUser(dto, username);
        }

        return "redirect:/user/update/" + username;
    }
}
