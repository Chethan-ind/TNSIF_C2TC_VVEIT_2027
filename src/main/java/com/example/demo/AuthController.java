package com.example.demo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserRepository userRepository;

    // =========================
    // POST - REGISTER
    // =========================
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest req) {
        try {
            return ResponseEntity.ok(authService.register(req));
        } catch (IllegalArgumentException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    // =========================
    // POST - LOGIN
    // =========================
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
        try {
            return ResponseEntity.ok(authService.login(req));
        } catch (IllegalArgumentException e) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(e.getMessage());
        }
    }

    // =========================
    // GET - CURRENT USER
    // =========================
    @GetMapping("/me")
    public ResponseEntity<?> me(Authentication authentication) {

        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Not authenticated");
        }

        String username = authentication.getName();

        return userRepository.findByUsername(username)
                .<ResponseEntity<?>>map(user ->
                        ResponseEntity.ok(
                                Map.of(
                                        "username", user.getUsername(),
                                        "email", user.getEmail(),
                                        "role", user.getRole()
                                )
                        )
                )
                .orElse(
                        ResponseEntity
                                .status(HttpStatus.NOT_FOUND)
                                .body("User not found")
                );
    }

    // =========================
    // PUT - UPDATE EMAIL
    // =========================
    @PutMapping("/update")
    public ResponseEntity<?> updateEmail(
            @RequestBody Updateemailrequest req,
            Authentication authentication) {

        String username = authentication.getName();

        User user = userRepository.findByUsername(username)
                .orElseThrow();

        user.setEmail(req.getEmail());

        userRepository.save(user);

        return ResponseEntity.ok(user);
    }
}
