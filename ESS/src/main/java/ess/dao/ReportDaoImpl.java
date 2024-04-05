package ess.dao;

import java.io.File;

import org.springframework.stereotype.Repository;

import ess.model.Report;

@Repository
public class ReportDaoImpl implements ReportDao {

	private static final String REPORTS_DIRECTORY = "/home/varshil/Downloads/";

	@Override
	public Report getReport(String name) {
		String filePath = REPORTS_DIRECTORY + "ESSUserGuide.pdf";

		File file = new File(filePath);
		if (file.exists()) {
			Report report = new Report();
			report.setName(name);
			report.setPath(filePath);
			return report;
		} else {
			return null; // Report not found
		}
	}
}
