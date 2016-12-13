package mtg.definitions;

import java.util.regex.Pattern;

public enum CostFlag {
	
	AT_UPKEEP					("At the beginning of your upkeep"),
	AT_NEXT_END_STEP			("At the beginning of the next end step"),
	AT_THE_END_STEP				("At the beginning of the end step"),
	AT_EACH_END_STEP			("At the beginning of each end step"),
	AT_COMBAT					("At the beginning of combat"),
	AT_PRECOMBAT_MAIN			("At the beginning of your precombat main phase"),
	WHENEVER_ATTACKS			("Whenever cardself attacks"),
	BECOMES_BLOCKED				("Whenever cardself becomes blocked"),
	DEALS_COMBAT				("Whenever cardself deals combat damage"),
	WHENEVER_DIES				("Whenever.+(?:dies)"),
	WHEN_DIES					("When cardself.+(?:dies)"),
	WHENEVER_ENTERS				("Whenever.+(?:enters)"),
	WHEN_ENTERS					("When cardself.+(?:enters)"), 
	WHENEVER_LEAVES				("Whenever.+(?:leaves)"),
	WHEN_LEAVES					("When cardself.+(?:leaves)"), 
	SACRIFICE_CREATURE			("Sacrifice a creature"),
	SACRIFICE_PERMANENT			("Sacrifice a permanent"),
	SACRIFICE_LAND				("Sacrifice a land"),
	SACRIFICE_ANOTHER			("Sacrifice another"),
	SACRIFICE_SELF				("Sacrifice cardself"),
	DISCARD_CARD				("Discard (.+) card"),
	PAY_LIFE					("Pay ([^\\.]+) life"),
	PLUS_LOYALTY				("^\\+[0-9X]+"),
	MINUS_LOYALTY				("−[0-9X]+"),
	TAP							("\\{T\\}"),
	UNTAP						("\\{Q\\}"),
	PAY_ENERGY					("Pay \\{E\\}"),
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
