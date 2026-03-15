package com.community.api.controller;

import com.community.api.dto.LoginRequest;
import com.community.api.dto.LoginResponse;
import com.community.api.dto.SignupRequest;
import com.community.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignupRequest request) {
        userService.signup(request);
        return ResponseEntity.ok("회원가입 성공!");
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody
                                                   LoginRequest request) {
        return ResponseEntity.ok(userService.login(request));
    }
}
