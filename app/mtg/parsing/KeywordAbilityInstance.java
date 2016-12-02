package mtg.parsing;

import mtg.definitions.KeywordAbilityDef;

public class KeywordAbilityInstance {

	private KeywordAbilityDef definition;
	
	private String amountString;
	private Float amount;
	private String subject;
	
	private Boolean hasManaCost;
	private Boolean isWhite;
	private Boolean isBlue;
	private Boolean isBlack;
	private Boolean isRed;
	private Boolean isGreen;
	private Float cmc;
	
	private Boolean hasNonManaCost;
}
