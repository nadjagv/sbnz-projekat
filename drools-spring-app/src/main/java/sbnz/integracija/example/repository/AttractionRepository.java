package sbnz.integracija.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sbnz.integracija.example.facts.Attraction;

public interface AttractionRepository extends JpaRepository<Attraction, Integer> {
	
	public List<Attraction> findAllByDestinationId(Integer destinationId);
}
