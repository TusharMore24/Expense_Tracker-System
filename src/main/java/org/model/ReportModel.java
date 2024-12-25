package org.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ReportModel {
	private int report_id;
	private int user_id;
	private float total_expenses;
	private float total_income;
	
}
