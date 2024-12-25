package org.service;

import java.util.List;

import org.model.ExpenseModel;
import org.repository.ExpenseRepository;
import org.repository.ExpenseRepositoryImpl;

public class ExpenseServiceImpl  implements ExpenseService{
     ExpenseRepository er= new ExpenseRepositoryImpl();

	@Override
	public boolean AddNewExpenses(ExpenseModel expens) {
		// TODO Auto-generated method stub
		return er.AddNewExpenses(expens);
	}

	@Override
	public List<ExpenseModel> showAllExpenses() {
		
		return er.showAllExpenses();
	}

	@Override
	public float getTotalExpensesByUserId(int userId) {
		// TODO Auto-generated method stub
		return er.getTotalExpensesByUserId(userId);
	}


}
