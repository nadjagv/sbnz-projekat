package sbnz.integracija.example.facts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AttractionsResponse implements Serializable{
	
	private boolean hasCar;
	private List<Attraction> attractions;
	
	public AttractionsResponse() {
		super();
		this.attractions=new ArrayList<Attraction>();
	}
	
	public void addAttraction(Attraction a) {
		this.attractions.add(a);
	}
	
	

}
