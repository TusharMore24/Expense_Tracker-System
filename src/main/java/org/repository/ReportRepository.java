package org.repository;

import java.util.Date;
import java.util.List;

import org.model.ReportModel;

public interface ReportRepository {
   public  int getReportOfOneDay(String date,int user_id );
   public int getReportOfMonth(String date1 ,String date2,int user_id);
   public int getReportOfYear(String date1 ,String date2,int user_id);
   public int getAmountDiscriptionOfUser(int user_id);
}
