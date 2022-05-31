package sbnz.integracija.example.facts;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class DestinationsResponse {

	private Set<Destination> destinations;
	
	public DestinationsResponse() {
		this.destinations = new HashSet<Destination>();
	}
	
	public void addDestination(Destination d) {
		destinations.add(d);
	}
}
