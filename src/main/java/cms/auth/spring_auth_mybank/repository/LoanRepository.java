package cms.auth.spring_auth_mybank.repository;

import cms.auth.spring_auth_mybank.entity.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<LoanEntity, Integer> {
}
