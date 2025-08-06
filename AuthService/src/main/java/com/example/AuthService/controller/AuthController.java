package com.example.AuthService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.AuthService.Dto.AuthRequest;
import com.example.AuthService.Service.AuthService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/getToken")
    public ResponseEntity<?> getToken(@RequestBody AuthRequest request,HttpServletResponse response) {
    	String token = authService.getToken(request);
    	Cookie cookie = new Cookie("jwt", token);
        cookie.setHttpOnly(true);
        cookie.setSecure(false); // set to true in production (HTTPS only)
        cookie.setPath("/");
        cookie.setMaxAge(24 * 60 * 60); // 1 day
        response.addCookie(cookie);
        return ResponseEntity.ok(token);
    }

    @GetMapping("/validate")
    public ResponseEntity<?> validateToken(@RequestParam String token) {
        return ResponseEntity.ok(authService.validateToken(token));
    }
}

