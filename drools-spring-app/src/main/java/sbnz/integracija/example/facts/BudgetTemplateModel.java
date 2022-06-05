package sbnz.integracija.example.facts;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sbnz.integracija.example.enums.BudgetCategory;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BudgetTemplateModel {
	private Double minBudget;
	private Double maxBudget;
	private BudgetCategory budgetCategory;
}
