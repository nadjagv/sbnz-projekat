package sbnz.integracija.example.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sbnz.integracija.example.enums.AttractionType;
import sbnz.integracija.example.facts.Attraction;
import sbnz.integracija.example.facts.Destination;
import sbnz.integracija.example.facts.Review;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AgeSettingsDTO {
	private int adultAgeMin;
	private int oldAgeMin;

}
