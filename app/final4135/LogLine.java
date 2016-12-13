package final4135;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LogLine {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int logLineId;
	
	private String ip;
	private String dateString;
	private String method;
	@Column(nullable = true, columnDefinition="varchar(1000)")
	private String url;
	@Column(nullable = true, columnDefinition="varchar(1000)")
	private String querylessUrl;
	private String protocol;
	private String responseCodeString;
	private String msString;
	@Column(nullable = true, columnDefinition="varchar(1000)")
	private String referrer;
	@Column(nullable = true, columnDefinition="varchar(1000)")
	private String userAgent;
	
	private Date date;
	private Integer responseCode;
	private Integer ms;
	
	@Column(nullable = true, columnDefinition="varchar(4000)")
	private String rawText;
	
	public int getLogLineId() {
		return logLineId;
	}
	public void setLogLineId(int logLineId) {
		this.logLineId = logLineId;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getDateString() {
		return dateString;
	}
	public void setDateString(String dateString) {
		this.dateString = dateString;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public String getResponseCodeString() {
		return responseCodeString;
	}
	public void setResponseCodeString(String responseCodeString) {
		this.responseCodeString = responseCodeString;
	}
	public String getMsString() {
		return msString;
	}
	public void setMsString(String msString) {
		this.msString = msString;
	}
	public String getReferrer() {
		return referrer;
	}
	public void setReferrer(String referrer) {
		this.referrer = referrer;
	}
	public String getUserAgent() {
		return userAgent;
	}
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}
	public Integer getMs() {
		return ms;
	}
	public void setMs(Integer ms) {
		this.ms = ms;
	}
	public String getRawText() {
		return rawText;
	}
	public void setRawText(String rawText) {
		this.rawText = rawText;
	}
	public String getQuerylessUrl() {
		return querylessUrl;
	}
	public void setQuerylessUrl(String querylessUrl) {
		this.querylessUrl = querylessUrl;
	}
	
	
}
