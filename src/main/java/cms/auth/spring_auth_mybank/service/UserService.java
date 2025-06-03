package cms.auth.spring_auth_mybank.service;

import cms.auth.spring_auth_mybank.dto.UserDTO;
import cms.auth.spring_auth_mybank.entity.ScopeEntity;
import cms.auth.spring_auth_mybank.entity.UserEntity;
import cms.auth.spring_auth_mybank.repository.ScopeRepository;
import cms.auth.spring_auth_mybank.repository.UserRepository;
import cms.auth.spring_auth_mybank.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScopeRepository scopeRepository;

    @Autowired
    private JwtUtil jwtUtil;

    public String verifyUser(UserDTO userDTO) {
        final UserEntity userEntity = userRepository.findUserByName(userDTO.getUsername());
        if (userEntity != null && Objects.equals(userEntity.getUsername(), userDTO.getUsername()) &&
                Objects.equals(userEntity.getPassword(), userDTO.getPassword())) {
            List<ScopeEntity> scopeList = scopeRepository.findScopes(userEntity.getRoleId());
            final StringBuilder scopes = new StringBuilder();
            scopeList.forEach(scope -> {
                scopes.append(scope.getPermission_state());
                scopes.append(",");
            });
            return jwtUtil.generateToken(userDTO.getUsername(), scopes.toString());
        }
        return null;
    }
}
