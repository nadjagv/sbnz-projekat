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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sbnz.integracija.example.dto.AttractionDTO;
import sbnz.integracija.example.dto.DestinationDTO;
import sbnz.integracija.example.dto.RequestDTO;
import sbnz.integracija.example.facts.Attraction;
import sbnz.integracija.example.facts.AttractionsResponse;
import sbnz.integracija.example.facts.Destination;
import sbnz.integracija.example.service.AttractionService;

@RestController
@RequestMapping("/attraction")
public class AttractionController {
	
	@Autowired
	private AttractionService attractionService;
	
	@PostMapping("/find")
	public ResponseEntity<Object> getAttractions(@RequestBody RequestDTO dto,@RequestParam Integer destinationId){
		AttractionsResponse response=attractionService.findAttractions(destinationId, dto);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<AttractionDTO> getOne(@PathVariable Integer id){
		Attraction d;
		try {
			d = attractionService.getOneAttraction(id);
			return new ResponseEntity<AttractionDTO>(new AttractionDTO(d), HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<AttractionDTO>(new AttractionDTO(), HttpStatus.BAD_REQUEST);
		}
        
    }
	
	@GetMapping()
	public ResponseEntity<ArrayList<AttractionDTO>> getAll(){
		try {
			List<Attraction> attractions = attractionService.getAllAttraction();
			ArrayList<AttractionDTO> dtos = new ArrayList<AttractionDTO>();
			for (Attraction attraction : attractions) {
				dtos.add(new AttractionDTO(attraction));
			}
			return new ResponseEntity<ArrayList<AttractionDTO>>(dtos, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<ArrayList<AttractionDTO>>(new ArrayList<AttractionDTO>(), HttpStatus.BAD_REQUEST);
		}
        
    }
	
	@PostMapping()
	public ResponseEntity<AttractionDTO> create(@RequestBody AttractionDTO dto){
		Attraction d;
		try {
			d = attractionService.createAttraction(dto);
			return new ResponseEntity<AttractionDTO>(new AttractionDTO(d), HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<AttractionDTO>(new AttractionDTO(), HttpStatus.BAD_REQUEST);
		}
        
    }
	
	@PutMapping()
	public ResponseEntity<AttractionDTO> update(@RequestBody AttractionDTO dto){
		Attraction d;
		try {
			d = attractionService.updateAttraction(dto);
			return new ResponseEntity<AttractionDTO>(new AttractionDTO(d), HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<AttractionDTO>(new AttractionDTO(), HttpStatus.BAD_REQUEST);
		}
        
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id){
		try {
			attractionService.deleteAttraction(id);
			return new ResponseEntity<String>("Success", HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>("Exception", HttpStatus.BAD_REQUEST);
		}
        
    }

}
