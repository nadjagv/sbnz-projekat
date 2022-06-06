package sbnz.integracija.example.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sbnz.integracija.example.enums.DestinationType;
import sbnz.integracija.example.facts.Destination;
import sbnz.integracija.example.service.DestinationService;

@RestController
@RequestMapping("/query")
public class QueryController {
	
	@Autowired
	private DestinationService destinationService;
	
	@GetMapping("/type")
	public ResponseEntity<Object> getADestinationsForType(@RequestParam DestinationType dt){
		ArrayList<Destination> destinations=(ArrayList<Destination>) destinationService.findDestinationType(dt);
        return new ResponseEntity<Object>(destinations, HttpStatus.OK);
    }
	
	@GetMapping("/popular")
	public ResponseEntity<Object> getPopularDestinations(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end){
		ArrayList<Destination> destinations=(ArrayList<Destination>) destinationService.popularDestinations(start,end);
        return new ResponseEntity<Object>(destinations, HttpStatus.OK);
    }

}
