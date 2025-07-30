package com.example.AuthService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.AuthService.Config.JwtUtil;
import com.example.AuthService.Dto.AuthRequest;
import com.example.AuthService.Entity.Users;
import com.example.AuthService.Repository.UserRepository;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    public String register(AuthRequest request) {
        if (userRepo.findByUsername(request.getUsername()).isPresent()) {
        	return "user exists";
//            throw new RuntimeException("User already exists");
        }

        Users user = new Users();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole("ROLE_USER");
        userRepo.save(user);
        return "User registered";
    }

    public String getToken(AuthRequest request) throws UsernameNotFoundException {
        Optional<Users> user = userRepo.findByUsername(request.getUsername());
        if (user.isPresent() && passwordEncoder.matches(request.getPassword(), user.get().getPassword())) {
        	UserDetails userDetails;
			userDetails = userDetailsService.loadUserByUsername(user.get().getUsername());
        	String token = jwtUtil.generateToken(userDetails);
        	return token;
        }
        throw new RuntimeException("Invalid credentials");
    }

    public boolean validateToken(String token) {
    	UserDetails userDetails = userDetailsService.loadUserByUsername(jwtUtil.extractUsername(token));
    	boolean isValid = jwtUtil.validateToken(token, userDetails);
    	return isValid;
    }

    public String extractUsername(String token) {
        return jwtUtil.extractUsername(token);
    }
}
