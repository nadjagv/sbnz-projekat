package sbnz.integracija.example.facts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sbnz.integracija.example.dto.RequestDTO;
import sbnz.integracija.example.enums.AgeCategory;
import sbnz.integracija.example.enums.AttractionType;
import sbnz.integracija.example.enums.BudgetCategory;
import sbnz.integracija.example.enums.DestinationType;
import sbnz.integracija.example.enums.Interest;
import sbnz.integracija.example.enums.Transportation;
import sbnz.integracija.example.enums.TravelCompanion;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Request implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Transportation transportation;
	private Double budget;
	private Integer age;
	private TravelCompanion travelCompanion;
	private boolean children;
	private List<Interest> interests;
	
	private BudgetCategory budgetCategory;
	private AgeCategory ageCategory;
	private DestinationType destinationType;
	private List<AttractionType> types;
	
	public Request(RequestDTO dto) {
		this.transportation = dto.getTransportation();
		this.budget = dto.getBudget();
		this.age = dto.getAge();
		this.travelCompanion = dto.getTravelCompanion();
		this.children = dto.isChildren();
		this.interests = dto.getInterests();
		this.types=new ArrayList<AttractionType>();

	}
	
	public void addType(AttractionType type) {
		this.types.add(type);
	}

}
