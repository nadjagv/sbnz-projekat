package sbnz.integracija.example.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sbnz.integracija.example.facts.SearchResult;

@Repository
public interface SearchResultRepository extends JpaRepository<SearchResult, Integer> {

}
