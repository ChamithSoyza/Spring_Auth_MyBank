package cms.auth.spring_auth_mybank.controller;

import cms.auth.spring_auth_mybank.dto.GoldDTO;
import cms.auth.spring_auth_mybank.service.GoldService;
import cms.auth.spring_auth_mybank.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/gold")
public class GoldController {

    @Autowired
    private GoldService goldService;

    @GetMapping(value = "/getAllGold")
    @PreAuthorize("hasAuthority('" + Constants.GOLD_GET_ALL + "')")
    public ResponseEntity<List<GoldDTO>> getAllGold() {
        return ResponseEntity.status(HttpStatus.OK).body(goldService.getAllGold());
    }

    @DeleteMapping(value = "/{goldStockId}")
    // @PreAuthorize()
    public ResponseEntity<String> deleteGoldRecord(@PathVariable("goldStockId") Integer goldId) {
        goldService.deleteGoldById(goldId);
        return ResponseEntity.status(HttpStatus.OK).body("Gold stock deleted successfully!");
    }
}
