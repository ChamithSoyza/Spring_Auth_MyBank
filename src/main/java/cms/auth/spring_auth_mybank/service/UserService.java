package cms.auth.spring_auth_mybank.service;

import cms.auth.spring_auth_mybank.dto.UserDTO;
import cms.auth.spring_auth_mybank.entity.ScopeEntity;
import cms.auth.spring_auth_mybank.entity.UserEntity;
import cms.auth.spring_auth_mybank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String verifyUser(UserDTO userDTO) {
        final UserEntity userEntity = userRepository.findUserByName(userDTO.getUsername());
        if (userEntity != null && Objects.equals(userEntity.getUsername(), userDTO.getUsername())
                && Objects.equals(userEntity.getPassword(), userDTO.getPassword())) {
            
        }
        return null;
    }
}
