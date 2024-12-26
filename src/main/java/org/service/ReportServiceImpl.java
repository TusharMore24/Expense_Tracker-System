package org.service;


import org.repository.ReportRepository;
import org.repository.ReportRepositoryImpl;

public class ReportServiceImpl implements ReportService {
	ReportRepository rr = new ReportRepositoryImpl();

	@Override
	public int getReportOfOneDay(String date, int user_id) {
		// TODO Auto-generated method stub
		return rr.getReportOfOneDay(date, user_id);
	}

	@Override
	public int getReportOfMonth(String date1, String date2, int user_id) {
		// TODO Auto-generated method stub
		return rr.getReportOfMonth(date1, date2, user_id);
	}

	@Override
	public int getReportOfYear(String date1, String date2, int user_id) {
		// TODO Auto-generated method stub
		return rr.getReportOfYear(date1, date2, user_id);
	}

	@Override
	public int getAmountDiscriptionOfUser(int user_id) {
		// TODO Auto-generated method stub
		return rr.getAmountDiscriptionOfUser(user_id);
	}

}
