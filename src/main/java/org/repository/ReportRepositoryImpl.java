package org.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.model.ReportModel;

public class ReportRepositoryImpl extends DBState implements ReportRepository {
	  int sum=0;
	@Override
	public int getReportOfOneDay(String date,int user_id) {
		  try {
			  stmt=conn.prepareStatement("select sum(total_expense) from reports r join usermaster u on r.user_id=u.user_id  join expenses e on  u.user_id=e.user_id where e.date=? and u.user_id=?");
			  stmt.setString(1, date);
			  stmt.setInt(2, user_id);
			  ResultSet v= stmt.executeQuery();
			  while(v.next()) {
				  sum=v.getInt(1);
			  }
			  return sum;
		  }
		  catch(SQLException ex) {
			  System.out.println("Error is"+ex);
		  }
		return sum;
	}
	@Override
	public int getReportOfMonth(String date1, String date2, int user_id) {
		try {
			stmt=conn.prepareStatement("select sum(total_expense) from reports r join usermaster u on r.user_id=u.user_id  join expenses e on  u.user_id=e.user_id where e.date>? and e.date<? and u.user_id=?");
			stmt.setString(1, date1);
			stmt.setString(2, date2);
			stmt.setInt(3, user_id);
			ResultSet v= stmt.executeQuery();
			  while(v.next()) {
				  sum=v.getInt(1);
			  }
			  return sum;
		}catch(SQLException ex) {
			System.out.println("Error is"+ex);
		}
		return sum;
	}
	@Override
	public int getReportOfYear(String date1, String date2, int user_id) {
		try {
			stmt=conn.prepareStatement("select sum(total_expense) from reports r join usermaster u on r.user_id=u.user_id  join expenses e on  u.user_id=e.user_id where e.date>? and e.date<? and u.user_id=?");
			stmt.setString(1, date1);
			stmt.setString(2, date2);
			stmt.setInt(3, user_id);
			ResultSet v= stmt.executeQuery();
			  while(v.next()) {
				  sum=v.getInt(1);
			  }
			  return sum;
		}catch(SQLException ex) {
			System.out.println("Error is"+ex);
		}
		return sum;
	}

}
