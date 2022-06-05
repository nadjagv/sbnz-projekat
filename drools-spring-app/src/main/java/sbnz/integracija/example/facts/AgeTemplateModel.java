package sbnz.integracija.example.facts;

import java.util.Set;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sbnz.integracija.example.enums.AgeCategory;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AgeTemplateModel {
	
	private int minAge;
	private int maxAge;
	private AgeCategory ageCategory;

}
