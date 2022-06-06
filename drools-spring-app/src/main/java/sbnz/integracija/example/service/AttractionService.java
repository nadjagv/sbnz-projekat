package sbnz.integracija.example.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Attr;

import sbnz.integracija.example.SampleAppService;
import sbnz.integracija.example.dto.AttractionDTO;
import sbnz.integracija.example.dto.RequestDTO;
import sbnz.integracija.example.enums.AttractionType;
import sbnz.integracija.example.enums.Interest;
import sbnz.integracija.example.facts.Attraction;
import sbnz.integracija.example.facts.AttractionsResponse;
import sbnz.integracija.example.facts.Destination;
import sbnz.integracija.example.facts.Request;
import sbnz.integracija.example.facts.Review;
import sbnz.integracija.example.repository.AttractionRepository;
import sbnz.integracija.example.repository.DestinationRepository;

@Service
public class AttractionService {
	private static Logger log = LoggerFactory.getLogger(SampleAppService.class);
	
	private final KieContainer kieContainer;
	
	@Autowired
	private DestinationRepository destinationRepository;
	
	@Autowired
	private AttractionRepository attractionRepository;
	
	@Autowired
	public AttractionService(KieContainer kieContainer) {
		log.info("Initialising a new session.");
		this.kieContainer = kieContainer;
	}
	
	public AttractionsResponse findAttractions(Integer destinationId,RequestDTO dto) {
		Request request = new Request(dto);
		Optional<Destination> dest=destinationRepository.findById(destinationId);
		AttractionsResponse response=new AttractionsResponse();
		List<Attraction> attractions=attractionRepository.findAllByDestinationId(destinationId);
		
		KieSession kieSession = kieContainer.newKieSession();
		
		for(Attraction a: attractions) {
			kieSession.insert(a);
		}
		
		kieSession.insert(request);
		kieSession.insert(response);
		kieSession.insert(dest.get());
		kieSession.getAgenda().getAgendaGroup("budget").setFocus();
		kieSession.fireAllRules();
		
		kieSession.getAgenda().getAgendaGroup("transport").setFocus();
		kieSession.fireAllRules();
		
		kieSession.getAgenda().getAgendaGroup("types").setFocus();
		kieSession.fireAllRules();
		
		kieSession.getAgenda().getAgendaGroup("attraction").setFocus();
		kieSession.fireAllRules();
		
		kieSession.dispose();
		
		return response;
	}
	
	public Attraction getOneAttraction(Integer id) throws Exception {
		
		Attraction attraction = attractionRepository.getOne(id);
		if (attraction == null) {
			throw new Exception("Not found.");
		}
		
		return attraction;
	}
	
	public List<Attraction> getAllAttraction() throws Exception {
		return attractionRepository.findAll();
	}
	
	
	public Attraction createAttraction(AttractionDTO dto) throws Exception {
		Destination destination = destinationRepository.getOne(dto.getDestinationId());
		if (destination == null) {
			throw new Exception("Not found.");
		}
		
		Attraction attraction = Attraction.builder().attractionType(dto.getAttractionType())
				.childFriendly(dto.isChildFriendly())
				.deleted(false)
				.description(dto.getDescription())
				.destination(destination)
				.name(dto.getName())
				.nearDestination(dto.isNearDestination())
				.tickets(dto.isTickets())
				.reviews(new HashSet<Review>())
				.build();
		
		return attractionRepository.save(attraction);
	}
	
	public void deleteAttraction(Integer id) throws Exception {
		
		Attraction attraction = attractionRepository.getOne(id);
		if (attraction == null) {
			throw new Exception("Not found.");
		}
		
		attractionRepository.delete(attraction);
	}
	
	public Attraction updateAttraction(AttractionDTO dto) throws Exception {
		Destination destination = destinationRepository.getOne(dto.getDestinationId());
		if (destination == null) {
			throw new Exception("Not found.");
		}
		
		Attraction attraction = attractionRepository.getOne(dto.getId());
		if (attraction == null) {
			throw new Exception("Not found.");
		}
		
		attraction.setAttractionType(dto.getAttractionType());
		attraction.setChildFriendly(dto.isChildFriendly());
		attraction.setDescription(dto.getDescription());
		attraction.setDestination(destination);
		attraction.setName(dto.getName());
		attraction.setNearDestination(dto.isNearDestination());
		attraction.setTickets(dto.isTickets());
		return attractionRepository.save(attraction);
	}
	

}
