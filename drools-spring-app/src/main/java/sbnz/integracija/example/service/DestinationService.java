package sbnz.integracija.example.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.kie.api.runtime.Globals;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sbnz.integracija.example.SampleAppService;
import sbnz.integracija.example.dto.RequestDTO;
import sbnz.integracija.example.enums.DestinationType;
import sbnz.integracija.example.facts.Destination;
import sbnz.integracija.example.facts.DestinationTypeCount;
import sbnz.integracija.example.facts.DestinationsResponse;
import sbnz.integracija.example.facts.Request;
import sbnz.integracija.example.facts.SearchResult;
import sbnz.integracija.example.repository.DestinationRepository;
import sbnz.integracija.example.repository.SearchResultRepository;

@Service
public class DestinationService {
	private static Logger log = LoggerFactory.getLogger(SampleAppService.class);

	private final KieContainer kieContainer;
	
	@Autowired
	private DestinationRepository destinationRep;
	
	@Autowired
	private SearchResultRepository searchResultRepository;

	@Autowired
	public DestinationService(KieContainer kieContainer) {
		log.info("Initialising a new session.");
		this.kieContainer = kieContainer;
	}

	public DestinationsResponse recommendDestination(RequestDTO dto) {
		Request request = new Request(dto);
		
		List<Destination> destinations =  destinationRep.findAll();
	
		DestinationsResponse response = new DestinationsResponse();
		
		DestinationTypeCount dtc1 = new DestinationTypeCount(DestinationType.YOUNGER, 0);
		DestinationTypeCount dtc2 = new DestinationTypeCount(DestinationType.COUPLES, 0);
		DestinationTypeCount dtc3 = new DestinationTypeCount(DestinationType.SINGLE, 0);
		DestinationTypeCount dtc4 = new DestinationTypeCount(DestinationType.FAMILY, 0);
		DestinationTypeCount dtc5 = new DestinationTypeCount(DestinationType.OLDER, 0);
//		
		ArrayList<DestinationTypeCount> destinationTypeCounts = new ArrayList<DestinationTypeCount>();
		destinationTypeCounts.add(dtc1);
		destinationTypeCounts.add(dtc2);
		destinationTypeCounts.add(dtc3);
		destinationTypeCounts.add(dtc4);
		destinationTypeCounts.add(dtc5);
		
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(request);
		kieSession.insert(response);
		for (Destination destination : destinations) {
			System.out.println(destination.getLocation());
			kieSession.insert(destination);
		}
		
		kieSession.getAgenda().getAgendaGroup("age").setFocus();
		kieSession.fireAllRules();
		kieSession.getAgenda().getAgendaGroup("budget").setFocus();
		kieSession.fireAllRules();
		System.out.println("budget: " + request.getBudgetCategory());
//		kieSession.setGlobal("destinationTypeCounts", destinationTypeCounts);
//		Globals globals = kieSession.getGlobals();
//		System.out.println( globals.getGlobalKeys() );
		kieSession.insert(dtc1);
		kieSession.insert(dtc2);
		kieSession.insert(dtc3);
		kieSession.insert(dtc4);
		kieSession.insert(dtc5);
		kieSession.getAgenda().getAgendaGroup("destination-type").setFocus();
		kieSession.fireAllRules();
		
		
		
		kieSession.getAgenda().getAgendaGroup("destination").setFocus();
		kieSession.fireAllRules();
		
		kieSession.dispose();
		
		
		for (Destination d : response.getDestinations()) {
			SearchResult sr = new SearchResult();
			sr.setDestination(d);
			sr.setTimestamp(new Timestamp(System.currentTimeMillis()));
			searchResultRepository.save(sr);
		}
		return response;
	}
	
	public List<Destination> findDestinationType(DestinationType dt) {
		List<Destination> destinations =  destinationRep.findAll();
		
		KieSession kieSession = kieContainer.newKieSession();
		
		for (Destination destination : destinations) {
			kieSession.insert(destination);
		}
		
		QueryResults results=kieSession.getQueryResults("Get destinations of a type", dt);
		ArrayList<Destination> destinationsFound=new ArrayList<Destination>();
		
		for(QueryResultsRow row: results) {
			Destination d=(Destination) row.get("$d");
			destinationsFound.add(d);
			System.out.println(d.getLocation());
		}
		
				
		kieSession.dispose();
		
		return destinationsFound;
	}

}
