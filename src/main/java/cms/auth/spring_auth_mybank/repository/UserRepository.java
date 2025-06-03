package cms.auth.spring_auth_mybank.repository;

import cms.auth.spring_auth_mybank.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>, JpaSpecificationExecutor<UserEntity> {

    @Query(value = "SELECT * FROM user WHERE username =:username", nativeQuery = true)
    public abstract UserEntity findUserByName(@Param("username") String username);

    @Query(value = "SELECT permission_id, permission FROM permission P INNER JOIN role_permission RP on P.id = RP.permission_id INNER JOIN role R ON RP.role_id = R.id WHERE role = 'admin';", nativeQuery = true)
    public abstract String findScopes(Integer userId);

}
