package ess.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ess.dao.ReportDao;
import ess.model.Report;

@Service
public class ReportService {
	
	@Autowired
	private ReportDao reportDao;
	
	public Report getReport(String name) {
		return reportDao.getReport(name);
	}
}
