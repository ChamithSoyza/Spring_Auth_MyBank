package cms.auth.spring_auth_mybank.service;

import cms.auth.spring_auth_mybank.dto.GoldDTO;
import cms.auth.spring_auth_mybank.entity.GoldEntity;
import cms.auth.spring_auth_mybank.repository.GoldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoldService {

    @Autowired
    private GoldRepository goldRepository;

    public List<GoldDTO> getAllGold() {
        List<GoldEntity> goldEntities = goldRepository.findAll();
        return goldEntities.stream().map(GoldDTO::new).collect(Collectors.toList());
    }

    public void deleteGoldById(Integer id){
        goldRepository.deleteById(id);
    }
}
