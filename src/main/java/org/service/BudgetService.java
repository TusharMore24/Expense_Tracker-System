package org.service;

import java.util.List;

import org.model.BudgetModel;

public interface BudgetService {
	public boolean isAddNewBudget(BudgetModel bmodel);
	public List<BudgetModel> showAllBudget();
	public boolean IsDeleteByBudget_id(int budget_id);
	public boolean updateNewBudget(int user_id, float newBudgetAmount);
}
