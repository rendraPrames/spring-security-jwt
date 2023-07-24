package rendra.prames.test.service;

import rendra.prames.test.dto.AuthenticationResponse;
import rendra.prames.test.dto.LoginDto;
import rendra.prames.test.dto.RegisterRequest;

public interface AuthService {
    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse login(LoginDto request);
}
