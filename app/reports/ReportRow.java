package reports;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.lang3.StringUtils;


@Entity
public class ReportRow {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long reportRowId;
	
	@ElementCollection
	@Column(nullable = true, columnDefinition="varchar(4000)")
	private Map<String, String> cells = new LinkedHashMap<String, String>();

	public long getReportRowId() {
		return reportRowId;
	}

	public void setReportRowId(long reportRowId) {
		this.reportRowId = reportRowId;
	}

	public Map<String, String> getCells() {
		return cells;
	}
	
	public String getCell(String key) {
		return cells.get(key);
	}
	
	public String putCell(String key, String value) {
		return cells.put(key, StringUtils.abbreviate(value, 4000));
	}

}
