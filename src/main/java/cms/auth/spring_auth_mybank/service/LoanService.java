package cms.auth.spring_auth_mybank.service;

import cms.auth.spring_auth_mybank.dto.LoanDTO;
import cms.auth.spring_auth_mybank.entity.LoanEntity;
import cms.auth.spring_auth_mybank.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    public List<LoanDTO> getAllLoans(){
        List<LoanEntity> loanEntityList = loanRepository.findAll();
        return loanEntityList.stream().map(LoanDTO::new).collect(Collectors.toList());
    }

    public void deleteLoanById(Integer loanID){
        loanRepository.deleteById(loanID);
    }
}
