package mtg.definitions;

import java.util.regex.Pattern;

public enum CostFlag {
	
	
	WHENEVER_ATTACKS			("Whenever cardself attacks"),
	BECOMES_BLOCKED				("Whenever cardself becomes blocked"),
	DEALS_COMBAT				("Whenever cardself deals combat damage"),
	
	WHENEVER_DIES				("Whenever.+(?:dies)"),
	WHEN_DIES					("When cardself.+(?:dies)"),
	WHENEVER_ENTERS				("Whenever.+(?:dies)"),
	WHEN_ENTERS					("When cardself.+(?:dies)"), 
	WHENEVER_LEAVES				("Whenever.+(?:dies)"),
	WHEN_LEAVES					("When cardself.+(?:dies)"), 
	
	OTHER_TRIGGER,
	
	SACRIFICE_CREATURE			("Sacrifice a creature"),
	SACRIFICE_PERMANENT			("Sacrifice a permanent"),
	SACRIFICE_LAND				("Sacrifice a land"),
	DISCARD_CARD				("Discard (.+) card"),
	PAY_LIFE					("Pay ([^\\.]+)) life"),
	
	PLUS_LOYALTY				("\\+[0-9X]+"),
	MINUS_LOYALTY				("-[0-9X]+"),
	
	TAP							("{T}"),
	UNTAP						("{Q}"),
	PAY_ENERGY					("Pay {E}"),
	EXILE_CARD					("exile ([^\\.]+) card"),
	
	OTHER_COST
	
	
;
	
	public final Pattern definition;
	
	private CostFlag(String regex){
		this.definition = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
	}
	private CostFlag(){
		this.definition = null;
	}
}
