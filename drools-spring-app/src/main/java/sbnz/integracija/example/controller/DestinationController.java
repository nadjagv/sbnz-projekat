package sbnz.integracija.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sbnz.integracija.example.dto.RequestDTO;
import sbnz.integracija.example.facts.Request;
import sbnz.integracija.example.service.DestinationService;

@RestController
public class DestinationController {
	@Autowired
	private DestinationService destinationService;
	
	@PostMapping
	public ResponseEntity<Request> createRealEstate(@RequestBody RequestDTO dto){
        Request request = destinationService.recommendDestination(dto);
        return new ResponseEntity<Request>(request, HttpStatus.OK);
    }

}
