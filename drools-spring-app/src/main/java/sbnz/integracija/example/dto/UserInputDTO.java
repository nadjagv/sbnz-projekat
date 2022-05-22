package sbnz.integracija.example.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sbnz.integracija.example.enums.Interest;
import sbnz.integracija.example.enums.Transportation;
import sbnz.integracija.example.enums.TravelCompanion;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInputDTO {
	private Transportation transportation;
	private Double budget;
	private Integer years;
	private TravelCompanion travelCompanion;
	private boolean children;
	private List<Interest> interests;

}
