package mtg.definitions;

import java.util.regex.Pattern;

public enum EffectFlag {

	PLUSX_COUNTERS				("\\+1/\\+1 counter"),
	MINUSX_COUNTERS				("-1/-1 counter"),
	
	PLUS_MINUS					("[+][a-zA-Z0-9*]{1,2}/[-][a-zA-Z0-9*]{1,2}(?! counter)"),
	PLUS_PLUS					("[+][a-zA-Z0-9*]{1,2}/[+][a-zA-Z0-9*]{1,2}(?! counter)"),
	MINUS_PLUS					("[-][a-zA-Z0-9*]{1,2}/[+][a-zA-Z0-9*]{1,2}(?! counter)"),
	MINUS_MINUS					("[-][a-zA-Z0-9*]{1,2}/[-][a-zA-Z0-9*]{1,2}(?! counter)"),
	
	
	//***** Attacking *********
	SELF_CANT_BLOCK				("cardself can't block\\."),
	CANT_BE_BLOCKED				("can't be blocked(?! except)"),

	ENTERS_TAPPED				("cardself enters the battlefield tapped"),
	AS_ENTERS					("As cardself enters the battlefield"),
	ENTERS_WITH					("enters the battlefield with"),
	
	DESTROY_THAT				("destroy that"),
	DESTROY_TARGET				("destroy( another)? target"),
	DESTROY_ALL					("destroy all"),
	
	EXILE_THAT					("exile that"),
	EXILE_TARGET				("exile( another)? target"),
	EXILE_ALL					("exile all"),
	
	RETURN_TARGET				("return( another)? target"),
	RETURN_ALL					("return all"),
	
	DEALS_DAMAGE				("deals ([a-zA-Z0-9*]{1,2}) damage"),			//deals 1 damage
	DEAL_DAMAGE					("deal ([a-zA-Z0-9*]{1,2}) damage"),
	PREVENT_DAMAGE				("prevent (the next|all|that damage)"),
	
	GAIN_LIFE					("gain ([a-zA-Z0-9*]{1,2}) life"), 
	
	DRAW_CARD					("draw (a|[0-9X]+) card"),
	ADD_MANA					("Add( [^m]+)? mana"),
	
	CREATURES_YOU_CONTROL		("creatures you control"),
	ENCHANTMENTS_YOU_CONTROL	("enchantments you control"),
	PERMANENTS_YOU_CONTROL		("permanents you control"),
	ARTIFACTS_YOU_CONTROL		("artifacts you control"),
	LANDS_YOU_CONTROL			("lands you control"),
	
	
	
	
	
	;
	
	public final Pattern definition;
	
	private EffectFlag(String regex){
		this.definition = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
	}
	
	private EffectFlag() {
		this.definition = null;
	}
}
