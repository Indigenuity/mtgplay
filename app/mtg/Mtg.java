package mtg;

import java.util.regex.Pattern;

import model.Card;

public class Mtg {
	
	private static final Pattern ACTIVATED_ABILITY = Pattern.compile("([^:]+):(.+)");
	private static final Pattern ABILITY_WORD = Pattern.compile("([^—]+)—(.+)");
	
	
	/*********  keyword abilities***************/
	
	

	public static void parseParagraph(Card card, String paragraphText) {
		
	}
}
