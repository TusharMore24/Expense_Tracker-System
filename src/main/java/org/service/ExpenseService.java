package org.service;

import java.util.List;

import org.model.ExpenseModel;

public interface ExpenseService {
	public boolean AddNewExpenses( ExpenseModel expens );
	public List<ExpenseModel> showAllExpenses();
	public float getTotalExpensesByUserId(int userId);
}
