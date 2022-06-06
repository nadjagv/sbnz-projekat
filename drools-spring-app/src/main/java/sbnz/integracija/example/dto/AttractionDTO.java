package sbnz.integracija.example.dto;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sbnz.integracija.example.enums.AttractionType;
import sbnz.integracija.example.enums.BudgetCategory;
import sbnz.integracija.example.enums.DestinationType;
import sbnz.integracija.example.enums.TownProximity;
import sbnz.integracija.example.facts.Attraction;
import sbnz.integracija.example.facts.Destination;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AttractionDTO {
	private Integer id;
	
    private boolean deleted;
    
	private String name;
    
	private String description;
    
	private boolean nearDestination;
    
	private boolean tickets;
    
	private boolean childFriendly;
    
	private AttractionType attractionType;
    
    private Integer destinationId;
    
    public AttractionDTO(Attraction a) {
    	this.id = a.getId();
    	this.deleted = a.isDeleted();
    	this.name = a.getName();
    	this.description = a.getDescription();
    	this.nearDestination = a.isNearDestination();
    	this.tickets = a.isTickets();
    	this.childFriendly = a.isChildFriendly();
    	this.attractionType = a.getAttractionType();
    	this.destinationId = a.getDestination().getId();
    }
}
