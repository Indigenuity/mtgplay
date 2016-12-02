package mtg.definitions;

import java.util.regex.Pattern;

public enum AbilityWordDef {

	BATTALION				("Battalion — ([^\\n]+)"),
	BLOODRUSH				("Bloodrush — ([^\\n]+)"),
	CHANNEL					("Channel — ([^\\n]+)"),
	CHROMA					("Chroma — ([^\\n]+)"),
	COHORT					("Cohort — ([^\\n]+)"),
	CONSTELLATION			("Constellation — ([^\\n]+)"),
	CONVERGE				("Converge — ([^\\n]+)"),
	COUNCILS_DILEMMA		("Council's Dilemma — ([^\\n]+)"),
	DELIRIUM				("Delirium — ([^\\n]+)"),
	DOMAIN					("Domain — ([^\\n]+)"),
	FATEFUL_HOUR			("Fateful Hour — ([^\\n]+)"),
	FEROCIOUS				("Ferocious — ([^\\n]+)"),
	FORMIDABLE				("Formidable — ([^\\n]+)"),
	GRANDEUR				("Grandeur — ([^\\n]+)"),
	HELLBENT				("Hellbent — ([^\\n]+)"),
	HEROIC					("Heroic — ([^\\n]+)"),
	IMPRINT					("Imprint — ([^\\n]+)"),
	INSPIRED				("Inspired — ([^\\n]+)"),
	JOIN_FORCES				("Join Forces — ([^\\n]+)"),
	KINSHIP					("Kinship — ([^\\n]+)"),
	LANDFALL				("Landfall — ([^\\n]+)"),
	LIEUTENANT				("Lieutenant — ([^\\n]+)"),
	METALCRAFT				("Metalcraft — ([^\\n]+)"),
	MORBID					("Morbind — ([^\\n]+)"),
	PARLEY					("Parley — ([^\\n]+)"),
	RADIANCE				("Radiance — ([^\\n]+)"),
	RAID					("Raid — ([^\\n]+)"),
	RALLY					("Rally — ([^\\n]+)"),
	SPELL_MASTERY			("Spell Mastery — ([^\\n]+)"),
	STRIVE					("Strive — ([^\\n]+)"),
	SWEEP					("Sweep — ([^\\n]+)"),
	TEMPTING_OFFER			("Tempting Offer — ([^\\n]+)"),
	THRESHOLD				("Threshold — ([^\\n]+)"),
	WILL_OF_THE_COUNCIL		("Will of the council — ([^\\n]+)"),
	
	
	;
	
	public final Pattern definition;
	
	private AbilityWordDef(String regex){
		this.definition = Pattern.compile(regex);
	}
}
