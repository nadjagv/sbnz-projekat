package sbnz.integracija.example.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import sbnz.integracija.example.facts.Destination;

public interface DestinationRepository extends JpaRepository<Destination, Integer> {
	
}
