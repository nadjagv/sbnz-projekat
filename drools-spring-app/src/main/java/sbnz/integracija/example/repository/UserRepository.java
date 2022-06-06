package sbnz.integracija.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sbnz.integracija.example.facts.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findOneByUsername(String username);

}
