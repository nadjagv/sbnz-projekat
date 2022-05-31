package sbnz.integracija.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sbnz.integracija.example.dto.RequestDTO;
import sbnz.integracija.example.facts.DestinationsResponse;
import sbnz.integracija.example.facts.Request;
import sbnz.integracija.example.service.DestinationService;

@RestController
@RequestMapping("/destination")
public class DestinationController {
	@Autowired
	private DestinationService destinationService;
	
	@PostMapping
	public ResponseEntity<DestinationsResponse> createRealEstate(@RequestBody RequestDTO dto){
		DestinationsResponse request = destinationService.recommendDestination(dto);
        return new ResponseEntity<DestinationsResponse>(request, HttpStatus.OK);
    }

}
