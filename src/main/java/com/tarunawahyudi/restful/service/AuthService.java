package com.tarunawahyudi.restful.service;

import com.tarunawahyudi.restful.entity.User;
import com.tarunawahyudi.restful.model.LoginUserRequest;
import com.tarunawahyudi.restful.model.TokenResponse;
import com.tarunawahyudi.restful.repository.UserRepository;
import com.tarunawahyudi.restful.security.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class AuthService {

    private final ValidationService validationService;
    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository, ValidationService validationService) {
        this.userRepository = userRepository;
        this.validationService = validationService;
    }

    public TokenResponse login(LoginUserRequest request) {
        User user = userRepository.findById(request.getUsername());

        if (BCrypt.checkpw(request.getPassword(), user.getPassword())) {
            user.setToken(UUID.randomUUID().toString());
            user.setTokenExpiredAt(next30Days());
            userRepository.save(user);

            return TokenResponse.builder()
                    .token(user.getToken())
                    .expiredAt(user.getTokenExpiredAt())
                    .build();

        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username or password wrong");
        }
    }

    public Long next30Days() {
        return System.currentTimeMillis() + (1000 * 16 * 24 * 30);
    }
}
