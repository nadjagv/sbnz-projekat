package sbnz.integracija.example.facts;

import java.io.Serializable;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sbnz.integracija.example.enums.DestinationType;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DestinationTypeCount implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DestinationType destinationType;
	private Integer count;
	

}
