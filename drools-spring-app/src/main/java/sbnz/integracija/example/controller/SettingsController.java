package sbnz.integracija.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sbnz.integracija.example.dto.AgeSettingsDTO;
import sbnz.integracija.example.dto.BudgetSettingsDTO;
import sbnz.integracija.example.dto.RequestDTO;
import sbnz.integracija.example.facts.DestinationsResponse;
import sbnz.integracija.example.service.SettingsService;

@RestController
@RequestMapping("/settings")
public class SettingsController {
	@Autowired
	SettingsService settingsService;
	
	@PostMapping("/age")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<String> updateAgeCategories(@RequestBody AgeSettingsDTO dto){
		try {
			settingsService.updateAgeCategories(dto);
			return new ResponseEntity<String>("Success", HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>("Exception", HttpStatus.BAD_REQUEST);
		}
        
    }
	
	@PostMapping("/budget")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<String> updateBudgetCategories(@RequestBody BudgetSettingsDTO dto){
		try {
			settingsService.updateBudgetCategories(dto);
			return new ResponseEntity<String>("Success", HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>("Exception", HttpStatus.BAD_REQUEST);
		}
        
    }

}
