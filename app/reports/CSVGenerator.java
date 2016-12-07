package reports;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;


public class CSVGenerator {
	
	public static void printReport(Report report) throws IOException {
		System.out.println("printing report : " + report.getName());
		report.acquireColumnNamesFromRows();
		List<String[]> rows = new ArrayList<String[]>();
		String[] headers = report.getColumnLabels().toArray(new String[report.getColumnLabels().size()]);
		rows.add(headers);
		for(ReportRow reportRow : report.getReportRows().values()){
			List<String> cells = new ArrayList<String>();
			for(String header : headers){
				cells.add(reportRow.getCell(header));
			}
			String[] row = cells.toArray(new String[cells.size()]);
			rows.add(row);
		}
		
		String targetFilename = "./" + report.getName();
		if(report.isAppendDate()){
			targetFilename += System.currentTimeMillis();  
		}
		targetFilename += ".csv";
		File target = new File(targetFilename);
		FileWriter fileOut = new FileWriter(target);
		CSVPrinter printer = new CSVPrinter(fileOut, CSVFormat.EXCEL);
		printer.printRecords(rows);
		printer.close();
		fileOut.close();
	}
	
	public static void writeReport(CSVReport report) throws IOException{
		System.out.println("Writing to file ");
		
		String targetFilename = "./" + report.getName();
		if(report.isAppendDate()){
			targetFilename += " " + System.currentTimeMillis();  
		}
		targetFilename += ".csv";
		File target = new File(targetFilename);
		FileWriter fileOut = new FileWriter(target);
		CSVPrinter printer = new CSVPrinter(fileOut, CSVFormat.EXCEL);
		printer.printRecords(report.getRows());
		printer.close();
		fileOut.close();
	}
	
	

}
