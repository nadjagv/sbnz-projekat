package sbnz.integracija.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BudgetSettingsDTO {
	private Double standardBudgetMin;
	private Double luxBudgetMin;

}
