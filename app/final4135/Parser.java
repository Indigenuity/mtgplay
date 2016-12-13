package final4135;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import javax.persistence.TypedQuery;

import play.db.jpa.JPA;

public class Parser {

	public static final Pattern LINE = Pattern.compile("([-a-zA-Z0-9\\.]+) (-) (-)[^\\[]+\\[([^\\]]+)\\] \"([A-Z]+) ([^ ]+) ([^\"]+)\" ([0-9]+) ([0-9-]+) \"([^\"]*)\" \"([^\"]+)\"");
	public static Integer count = 0;
	
	public static void removeQueries(){
		int count = 0;
		int limit = 1000;
		String queryString = "from LogLine ll where ll.ip is not null";
		
		TypedQuery query = JPA.em().createQuery(queryString, LogLine.class).setFirstResult(count).setMaxResults(limit);
		List<LogLine> lines = query.getResultList();
		
		while(lines.size() > 0){
			System.out.println("count : " + count);
			
			for(LogLine line : lines){
				line.setQuerylessUrl(removeQueryString(line.getUrl()));
			}
			count += limit;
			query.setFirstResult(count);
			lines = query.getResultList();
			JPA.em().getTransaction().commit();
			JPA.em().getTransaction().begin();
			JPA.em().clear();
		}
		
	}
	
	public static String removeQueryString(String original) {
		int queryPosition = original.indexOf('?');
		if(queryPosition > 0){
			return original.substring(0, queryPosition);
		}
		return original;
	}
	
	public static void readAccess() throws Exception{
		
		String fileName = "./access_all";

		//read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			stream.forEach((line) ->{
//				System.out.println("line : " + line);
				LogLine logLine = new LogLine();
				Matcher matcher = LINE.matcher(line);
				if(matcher.find()){
					String ip = matcher.group(1);
					String unknown1 = matcher.group(2);
					String unknown2 = matcher.group(3);
					String dateString = matcher.group(4);
					String method = matcher.group(5);
					String url = matcher.group(6);
					String protocol = matcher.group(7);
					String responseCodeString = matcher.group(8);
					String msString = matcher.group(9);
					String referrer = matcher.group(10);
					String userAgent = matcher.group(11);
					
					
					logLine.setIp(ip);
					logLine.setDateString(dateString);
					logLine.setMethod(method);
					logLine.setUrl(url);
					logLine.setProtocol(protocol);
					logLine.setResponseCodeString(responseCodeString);
					logLine.setMsString(msString);
					logLine.setReferrer(referrer);
					logLine.setUserAgent(userAgent);
				}
				
				logLine.setRawText(line);
				JPA.em().persist(logLine);
				
				count++;
				if(count %1000 == 0){
					System.out.println("count : " + count);
					JPA.em().getTransaction().commit();
					JPA.em().getTransaction().begin();
					JPA.em().clear();
				}
				
			});

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
