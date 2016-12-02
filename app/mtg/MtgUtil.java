package mtg;

import java.util.Objects;

public class MtgUtil {
	
	public static String booleanColumn(String text){
		return "is_" + column(text); 
	}
	
	public static String column(String text){
		Objects.nonNull(text);
		return text.toLowerCase().replaceAll("[^a-zA-Z0-9]+", "_");
	}

}
