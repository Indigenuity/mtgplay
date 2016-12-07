package mtg.definitions;

import java.util.regex.Pattern;

public enum ManaCostType {
	

	GENERIC		("([0-9]+)", false, false, false, false, false, false, false),
	X			("X", false, false, false, false, false, false, false),

	WHITE 		("W", true, true, false, false, false, false, false),
	BLUE 		("U", true, false, true, false, false, false, false),
	BLACK 		("B", true, false, false, true, false, false, false),
	RED 		("R", true, false, false, false, true, false, false),
	GREEN 		("G", true, false, false, false, false, true, false),
	COLORLESS	("C", true, false, false, false, false, false, true),
	
	GENERIC_WHITE 		("([0-9]+)/W", false, true, false, false, false, false, false),
	GENERIC_BLUE 		("([0-9]+)/U", false, false, true, false, false, false, false),
	GENERIC_BLACK 		("([0-9]+)/B", false, false, false, true, false, false, false),
	GENERIC_RED 		("([0-9]+)/R", false, false, false, false, true, false, false),
	GENERIC_GREEN 		("([0-9]+)/G", false, false, false, false, false, true, false),

	PHYREXIAN_WHITE 		("W/P", false, true, false, false, false, false, false),
	PHYREXIAN_BLUE 			("U/P", false, false, true, false, false, false, false),
	PHYREXIAN_BLACK 		("B/P", false, false, false, true, false, false, false),
	PHYREXIAN_RED 			("R/P", false, false, false, false, true, false, false),
	PHYREXIAN_GREEN 		("G/P", false, false, false, false, false, true, false),
	
	AZORIUS 	("W/U", true, true, true, false, false, false, false),
	ORZHOV 		("W/B", true, true, false, true, false, false, false),
	DIMIR 		("U/B", true, false, true, true, false, false, false),
	IZZET 		("U/R", true, false, true, false, true, false, false),
	RAKDOS 		("B/R", true, false, false, true, true, false, false),
	GOLGARI 	("B/G", true, false, false, true, false, true, false),
	GRUUL 		("R/G", true, false, false, false, true, true, false),
	BOROS 		("R/W", true, true, false, false, true, false, false),
	SELESNYA 	("G/W", true, true, false, false, false, true, false),
	SIMIC 		("G/U", true, false, true, false, false, true, false),
	
	SNOW		("S", true, false, false, false, false, false, false),
	
	;
	
	public final Pattern definition;
	public final boolean isWhite;
	public final boolean isBlue;
	public final boolean isBlack;
	public final boolean isRed;
	public final boolean isGreen;
	public final boolean isColorless;
	public final boolean isTyped;
	
	private ManaCostType(String regex, boolean typeRequired, boolean isWhite, boolean isBlue, boolean isBlack, boolean isRed, boolean isGreen, boolean isColorless){
		this.definition = Pattern.compile(regex);
		this.isWhite = isWhite;
		this.isBlue = isBlue;
		this.isBlack = isBlack;
		this.isRed = isRed;
		this.isGreen = isGreen;
		this.isColorless = isColorless;
		this.isTyped = isWhite || isBlue || isBlack || isRed || isGreen || isColorless;
	}
	
}
