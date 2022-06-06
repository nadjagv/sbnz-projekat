package sbnz.integracija.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sbnz.integracija.example.dto.AttractionDTO;
import sbnz.integracija.example.dto.DestinationDTO;
import sbnz.integracija.example.dto.RequestDTO;
import sbnz.integracija.example.facts.Attraction;
import sbnz.integracija.example.facts.Destination;
import sbnz.integracija.example.facts.DestinationsResponse;
import sbnz.integracija.example.facts.Request;
import sbnz.integracija.example.service.DestinationService;

@RestController
@RequestMapping("/destination")
public class DestinationController {
	@Autowired
	private DestinationService destinationService;
	
	@PostMapping("/recommend")
	public ResponseEntity<DestinationsResponse> recommend(@RequestBody RequestDTO dto){
		DestinationsResponse request = destinationService.recommendDestination(dto);
        return new ResponseEntity<DestinationsResponse>(request, HttpStatus.OK);
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<DestinationDTO> getOne(@PathVariable Integer id){
		Destination d;
		try {
			d = destinationService.getOneDestination(id);
			return new ResponseEntity<DestinationDTO>(new DestinationDTO(d), HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<DestinationDTO>(new DestinationDTO(), HttpStatus.BAD_REQUEST);
		}
        
    }
	
	@GetMapping()
	public ResponseEntity<ArrayList<DestinationDTO>> getAll(){
		try {
			List<Destination> destinations = destinationService.getAllDestination();
			ArrayList<DestinationDTO> dtos = new ArrayList<DestinationDTO>();
			for (Destination destination : destinations) {
				dtos.add(new DestinationDTO(destination));
			}
			return new ResponseEntity<ArrayList<DestinationDTO>>(dtos, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<ArrayList<DestinationDTO>>(new ArrayList<DestinationDTO>(), HttpStatus.BAD_REQUEST);
		}
        
    }
	
	@PostMapping()
	public ResponseEntity<DestinationDTO> create(@RequestBody DestinationDTO dto){
		Destination d = destinationService.createDestination(dto);
        return new ResponseEntity<DestinationDTO>(new DestinationDTO(d), HttpStatus.OK);
    }
	
	@PutMapping()
	public ResponseEntity<DestinationDTO> update(@RequestBody DestinationDTO dto){
		Destination d;
		try {
			d = destinationService.updateDestination(dto);
			return new ResponseEntity<DestinationDTO>(new DestinationDTO(d), HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<DestinationDTO>(new DestinationDTO(), HttpStatus.BAD_REQUEST);
		}
        
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id){
		Destination d;
		try {
			destinationService.deleteDestination(id);
			return new ResponseEntity<String>("Success", HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>("Exception", HttpStatus.BAD_REQUEST);
		}
        
    }

}
