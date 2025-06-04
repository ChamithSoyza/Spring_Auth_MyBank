package cms.auth.spring_auth_mybank.repository;

import cms.auth.spring_auth_mybank.entity.GoldEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository For Gold Loans
 */
@Repository
public interface GoldRepository extends JpaRepository<GoldEntity, Integer> {
}
