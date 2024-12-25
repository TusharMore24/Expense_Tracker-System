package org.repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.model.ExpenseModel;
import org.service.CurrentUser_Id;

import lombok.Data;

public class ExpenseRepositoryImpl extends DBState implements ExpenseRepository {
	CurrentUser_Id id;
	@Override
	public boolean isValidCategory_id(int category_id) {
		 try {
	            stmt = conn.prepareStatement("SELECT COUNT(*) FROM categories WHERE category_id = ?");
	            stmt.setInt(1, category_id); 
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next() && rs.getInt(1) > 0) {
	                return true; 
	            }
	        } catch (SQLException ex) {
	            System.out.println("Error checking category: " + ex);
	        }
	        return false; 
	    }
	
	
	@Override
	public boolean AddNewExpenses( ExpenseModel expens ) {
	   try {
		   
		   if (!isValidCategory_id(expens.getCategory_id())) {
               System.out.println("Invalid category ID: " + expens.getCategory_id());
               return false;
           }
		   
		  stmt=conn.prepareStatement("insert into  expenses (expense_id, user_id, amount, category_id, description, date) values (?,?,?,?,?,?)");
		  stmt.setInt(1,expens.getExpense_id()); 
		  stmt.setInt(2,id.getUser_Id());
		  stmt.setFloat(3,  expens.getAmount());
		  stmt.setFloat(4,  expens.getCategory_id());
		  stmt.setString(5, expens.getDescription());
		  stmt.setDate(6, new java.sql.Date(expens.getDate().getTime()));
		   int value= stmt.executeUpdate();
		  
		   return value>0?true:false;
	   }
	   catch(SQLException ex) {
		   System.out.println("Error is"+ex);
		   
	   }
		return false;
	}


	@Override
	public List<ExpenseModel> showAllExpenses() {
		List<ExpenseModel> list= new ArrayList();
		try {
			stmt=conn.prepareStatement("Select * from Expenses");
			ResultSet v=stmt.executeQuery();
			
			while(v.next()) {
				list.add(new ExpenseModel(v.getInt(1),v.getFloat(2),v.getInt(3),v.getString(4),v.getDate(5),v.getInt(6)));
			}
			return list.size() > 0 ? list : null;
		}
		catch(SQLException ex) {
			System.out.println("Error is"+ex);
		}
		
		
		return null;
	}
	
	public float getTotalExpensesByUserId(int userId) {
	    try {
	      stmt = conn.prepareStatement("SELECT SUM(amount) FROM Expenses WHERE user_id = ?");
	        stmt.setInt(1, userId);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            return rs.getFloat(1); // Return the sum of expenses
	        }
	    } catch (SQLException ex) {
	        System.err.println("Error fetching total expenses: " + ex.getMessage());
	    }
	    return 0; // Default to 0 if no data or an error occurs
	}


	
}
