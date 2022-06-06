package sbnz.integracija.example.dto;

import java.util.Set;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sbnz.integracija.example.enums.BudgetCategory;
import sbnz.integracija.example.enums.DestinationType;
import sbnz.integracija.example.enums.TownProximity;
import sbnz.integracija.example.facts.Destination;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DestinationDTO {
	
	private Integer id;
	
    private boolean deleted;
    
	private String location;
    
	private BudgetCategory price;
    
    private TownProximity proximity;
    
    private boolean airport;
    
    private boolean rentACar;
    
    private boolean beach;
    
    private boolean sightseeings;
    
    private boolean shops;
    
    private boolean restaurants;
    
    private boolean childrenActivities;
    
    private DestinationType destinationType;
    
    public DestinationDTO(Destination d) {
    	this.id = d.getId();
    	this.deleted = d.isDeleted();
    	this.location = d.getLocation();
    	this.price = d.getPrice();
    	this.proximity = d.getProximity();
    	this.airport = d.isAirport();
    	this.rentACar = d.isRentACar();
    	this.beach = d.isBeach();
    	this.sightseeings = d.isSightseeings();
    	this.shops = d.isShops();
    	this.restaurants = d.isRestaurants();
    	this.childrenActivities = d.isChildrenActivities();
    	this.destinationType = d.getDestinationType();
    }

}
