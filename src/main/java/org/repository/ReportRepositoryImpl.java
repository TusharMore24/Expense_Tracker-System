package org.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportRepositoryImpl extends DBState implements ReportRepository {
	  float total_Budget=0;
	  float total_Expense=0;
	@Override
	public int getReportOfOneDay(String date,int user_id) {
		  try {
			  stmt=conn.prepareStatement("SELECT b.budget_amount,SUM(e.amount) AS total_expense FROM budgets b LEFT JOIN expenses e ON b.user_id = e.user_id AND e.date= ? WHERE b.user_id = ? GROUP BY b.budget_amount");
			  stmt.setString(1, date);
			  stmt.setInt(2, user_id);
			  ResultSet v= stmt.executeQuery();
			  while(v.next()) {
				  total_Budget=v.getFloat(1);
				  total_Expense=v.getFloat(2);
			  }
			  
			  System.out.println("Total_Budget Of User:- "+total_Budget+"  Total_Expense of User:- "+total_Expense  );
			  System.out.println("Total Income Of User:- "+(total_Expense+total_Budget));
			  System.out.println("Remain parse of User:- "+(total_Budget-total_Expense));
		  }
		  catch(SQLException ex) {
			  System.out.println("Error is"+ex);
		  }
		return 0;
	}
	@Override
	public int getReportOfMonth(String date1, String date2, int user_id) {
		try {
			stmt=conn.prepareStatement("SELECT b.budget_amount,SUM(e.amount) AS total_expense FROM budgets b LEFT JOIN expenses e ON b.user_id = e.user_id AND e.date BETWEEN ? AND ? WHERE b.user_id = ? GROUP BY b.budget_amount");
			stmt.setString(1, date1);
			stmt.setString(2, date2);
			stmt.setInt(3, user_id);
			ResultSet v= stmt.executeQuery();
			  while(v.next()) {
				  total_Budget=v.getFloat(1);
				  total_Expense=v.getFloat(2);
			  }
			  System.out.println("Total_Budget Of User:- "+total_Budget+"  Total_Expense of User:- "+total_Expense  );
			  System.out.println("Total Income Of User:- "+(total_Expense+total_Budget));
			  System.out.println("Remain parse of User:- "+(total_Budget-total_Expense));
			 
		}catch(SQLException ex) {
			System.out.println("Error is"+ex);
		}
		return 0;
	}
	@Override
	public int getReportOfYear(String date1, String date2, int user_id) {
		try {
			stmt=conn.prepareStatement("SELECT b.budget_amount,SUM(e.amount) AS total_expense FROM budgets b LEFT JOIN expenses e ON b.user_id = e.user_id AND e.date BETWEEN ? AND ? WHERE b.user_id = ? GROUP BY b.budget_amount");
			stmt.setString(1, date1);
			stmt.setString(2, date2);
			stmt.setInt(3, user_id);
			ResultSet v= stmt.executeQuery();
			  while(v.next()) {
				  total_Budget=v.getFloat(1);
				  total_Expense=v.getFloat(2);
			  }
			  System.out.println("Total_Budget Of User:- "+total_Budget+"  Total_Expense of User:- "+total_Expense  );
			  System.out.println("Total Income Of User:- "+(total_Expense+total_Budget));
			  System.out.println("Remain parse of User:- "+(total_Budget-total_Expense));
		}catch(SQLException ex) {
			System.out.println("Error is"+ex);
		}
		return 0;
	}
	@Override
	public int getAmountDiscriptionOfUser(int user_id) {
		
		
		try {
			stmt= conn.prepareStatement("select amount, description from expenses where user_id=?");
			stmt.setInt(1, user_id);
			ResultSet v=stmt.executeQuery();
			System.out.println("Amount\t\t"+"Description");
			System.out.println("_______________________________________________");
			while(v.next()) {
				System.out.println(v.getFloat(1)+"\t\t"+v.getString(2));
			}
			
		}
		catch(SQLException ex) {
			System.out.println("Error is"+ex);
		}
		
		return 0;
	}

}
