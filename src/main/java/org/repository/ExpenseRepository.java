package org.repository;

import java.util.List;

import org.model.ExpenseModel;

public interface ExpenseRepository {
    public boolean AddNewExpenses( ExpenseModel expens);
    public boolean isValidCategory_id(int category_id);
    public List<ExpenseModel> showAllExpenses();
    public float getTotalExpensesByUserId(int userId);
}
