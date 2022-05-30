package sbnz.integracija.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sbnz.integracija.example.dto.RequestDTO;
import sbnz.integracija.example.facts.AttractionsResponse;
import sbnz.integracija.example.service.AttractionService;

@RestController
@RequestMapping("/attraction")
public class AttractionController {
	
	@Autowired
	private AttractionService attractionService;
	
	@PostMapping("")
	public ResponseEntity<Object> getAttractions(@RequestBody RequestDTO dto,@RequestParam Integer destinationId){
		AttractionsResponse response=attractionService.findAttractions(destinationId, dto);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

}
