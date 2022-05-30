package sbnz.integracija.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sbnz.integracija.example.SampleAppService;
import sbnz.integracija.example.dto.RequestDTO;
import sbnz.integracija.example.enums.AttractionType;
import sbnz.integracija.example.enums.Interest;
import sbnz.integracija.example.facts.Attraction;
import sbnz.integracija.example.facts.AttractionsResponse;
import sbnz.integracija.example.facts.Destination;
import sbnz.integracija.example.facts.Request;
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
	

}
