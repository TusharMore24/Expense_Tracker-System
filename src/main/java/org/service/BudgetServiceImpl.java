package org.service;

import java.util.List;

import org.model.BudgetModel;
import org.repository.BudgetRepository;
import org.repository.BudgetRepositoryImpl;

public class BudgetServiceImpl implements BudgetService {
     BudgetRepository br= new BudgetRepositoryImpl();
	@Override
	public boolean isAddNewBudget(BudgetModel bmodel) {
		// TODO Auto-generated method stub
		return br.isAddNewBudget(bmodel);
	}
	@Override
	public List<BudgetModel> showAllBudget() {
		// TODO Auto-generated method stub
		return br.showAllBudget();
	} 
	@Override
	public boolean IsDeleteByBudget_id(int budget_id) {
		// TODO Auto-generated method stub
		return br.IsDeleteByBudget_id(budget_id);
	}
	@Override
	public boolean updateNewBudget(int user_id, float newBudgetAmount) {
		// TODO Auto-generated method stub
		return br.updateNewBudget(user_id, newBudgetAmount);
	}

}
