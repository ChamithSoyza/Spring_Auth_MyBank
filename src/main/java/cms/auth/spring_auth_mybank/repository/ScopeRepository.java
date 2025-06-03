package cms.auth.spring_auth_mybank.repository;

import cms.auth.spring_auth_mybank.entity.ScopeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScopeRepository extends JpaRepository<ScopeEntity, Integer> {
    @Query(value = "SELECT permission_id, permission FROM permission P INNER JOIN role_permission RP ON P.id = RP.permission_id INNER JOIN role R ON RP.role_id = R.id WHERE role_id =:roleId;", nativeQuery = true)
    public abstract List<ScopeEntity> findScopes(@Param("roleId") Integer roleId);
}
