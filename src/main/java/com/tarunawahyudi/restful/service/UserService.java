package com.tarunawahyudi.restful.service;

import com.tarunawahyudi.restful.entity.Product;
import com.tarunawahyudi.restful.model.ProductResponse;
import com.tarunawahyudi.restful.model.RegisterUserRequest;
import com.tarunawahyudi.restful.entity.User;
import com.tarunawahyudi.restful.exception.ApiException;
import com.tarunawahyudi.restful.model.UserResponse;
import com.tarunawahyudi.restful.repository.UserRepository;
import com.tarunawahyudi.restful.security.BCrypt;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import jakarta.validation.Validator;

import java.util.Set;

@Slf4j
@Service
public class UserService {

    private final ValidationService validationService;
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository, ValidationService validationService) {
        this.userRepository = userRepository;
        this.validationService = validationService;
    }

    public void register(RegisterUserRequest request) {

        validationService.validate(request);

        if (userRepository.existsUsername(request.getUsername())) {
            throw new ApiException("Username already register");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        user.setName(request.getName());

        userRepository.save(user);
    }

    private UserResponse convertToUserResponse(User user) {
        return UserResponse.builder()
                .username(user.getUsername())
                .name(user.getName())
                .build();
    }
}
