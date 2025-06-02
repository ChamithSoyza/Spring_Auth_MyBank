package cms.auth.spring_auth_mybank.controller;

import cms.auth.spring_auth_mybank.dto.UserDTO;
import cms.auth.spring_auth_mybank.entity.UserEntity;
import cms.auth.spring_auth_mybank.repository.UserRepository;
import cms.auth.spring_auth_mybank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/verifyUser")
    public ResponseEntity<String> verifyUser(@RequestBody UserDTO userDTO) {
        String jwtToken = "";

        return ResponseEntity.status(HttpStatus.OK).body(jwtToken);
    }


}
