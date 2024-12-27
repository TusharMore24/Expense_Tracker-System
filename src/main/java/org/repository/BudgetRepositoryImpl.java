package org.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.model.BudgetModel;
import org.service.CurrentUser_Id;

public class BudgetRepositoryImpl extends DBState implements BudgetRepository {
            List list;
            
            float beforeBudget=0;
            @Override
            public boolean isAddNewBudget(BudgetModel bmodel) {
                try {
             
                    stmt = conn.prepareStatement("INSERT INTO budgets (user_id, budget_amount) VALUES (?, ?)");
                    stmt.setInt(1, bmodel.getUser_id());
                    stmt.setFloat(2, bmodel.getBudget_amount());
                    int value = stmt.executeUpdate();

                    return value > 0 ?true:false;
                } catch (SQLException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
                return false;
            }

	@Override
	public List<BudgetModel> showAllBudget() {
		  List<BudgetModel> list= new ArrayList();
		  try {
			  
			  stmt=conn.prepareStatement("Select * from Budgets");
			  ResultSet v=stmt.executeQuery();
			  while(v.next()) {
				  list.add(new BudgetModel(v.getInt(1),v.getInt(2),v.getFloat(3)));
			  }
			  return list.size()>0?list:null;
		  }
		  catch(SQLException ex ) {
			  System.out.println("Error is"+ex);
		  }
		return null;
	}

	@Override
	public boolean IsDeleteByBudget_id(int budget_id) {
		try {
			stmt=conn.prepareStatement("delete from budgets where budget_id=?");
			stmt.setInt(1,budget_id);
		int	value=stmt.executeUpdate();
		return value>0?true:false;
		}
		catch(SQLException ex) {
			System.out.println("Error is"+ex);
		}
		return false;
	}

	@Override
	public boolean updateNewBudget(int user_id, float newBudgetAmount) {
		try {
			stmt=conn.prepareStatement("SELECT budget_amount FROM Budgets WHERE user_id = ?");
			stmt.setInt(1, user_id);
			ResultSet v=stmt.executeQuery();
			while(v.next()) {
				beforeBudget=v.getFloat(1);
				float totalBudget=beforeBudget+newBudgetAmount;
				stmt=conn.prepareStatement("update  budgets set budget_amount=? where user_id=?");
				stmt.setFloat(1, totalBudget);
				stmt.setInt(2, user_id);
				int value=stmt.executeUpdate();
				return value>0?true:false;
				
			}
		}
		catch(SQLException ex) {
			System.out.println("Error is"+ex);
		}
		
		return false;
	}

}
