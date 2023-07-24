package rendra.prames.test.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rendra.prames.test.dto.AuthenticationResponse;
import rendra.prames.test.dto.LoginDto;
import rendra.prames.test.dto.RegisterRequest;
import rendra.prames.test.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.register(request));
    }

    // Build Login REST API
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody LoginDto request){
        return ResponseEntity.ok(authService.login(request));
    }
}