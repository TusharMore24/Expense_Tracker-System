package org.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class BudgetModel {
	private int  budget_id;
	private int  user_id  ;
	private float budget_amount;
}
