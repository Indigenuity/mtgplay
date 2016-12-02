package mtg.definitions;

import java.util.regex.Pattern;

public enum KeywordAbilityDef {
	
	//**** Order Matters *********//
	NONBASIC_LANDWALK	("Nonbasic landwalk"),
	SNOW_PLAINSWALK		("Snow plainswalk"),
	SNOW_ISLANDWALK		("Snow islandwalk"),
	SNOW_SWAMPWALK		("Snow swampwalk"),
	SNOW_MOUNTAINWALK	("Snow mountainwalk"),
	SNOW_FORESTWALK		("Snow forestwalk"),
	SNOW_COVERED_PLAINSWALK	("Snow-covered plainswalk"),
	SNOW_LANDWALK		("Snow landwalk"),
	MODULAR_SUNBURST	("Modular—Sunburst"),
	PROTECTION			("Protection from ([^\\n,;]+)", false, true),
	SPLICE				("Splice onto Arcane[— ]([^\\n,;]+)", false, true),
	
	
	//**** Evergreen ********//
	DEATHTOUCH			("Deathtouch"),
	DEFENDER			("Defender"),
	DOUBLE_STRIKE		("Double Strike"),
	ENCHANT				("Enchant ([^\\n,;]+)", false, true), 
	EQUIP				("Equip[— ]([^\\n,;]+)", true), 
	FIRST_STRIKE		("First Strike"),
	FLASH				("Flash"), 
	FLYING				("Flying"),
	HASTE				("Haste"),
	HEXPROOF			("Hexproof"),
	INDESTRUCTIBLE		("Indestructible"),
	LIFELINK			("Lifelink"),
	MENACE				("Menace"),
	PROWESS				("Prowess"),
	REACH				("Reach"),
	TRAMPLE				("Trample"),
	VIGILANCE			("Vigilance"),
	
	//****** Other *********//
	ABSORB				("Absorb ([0-9]+)", true),
	AFFINITY			("Affinity for ([^\\n,;]+)", false, true),
	AMPLIFY				("Amplify ([0-9]+)", true),
	ANNIHILATOR			("Annihilator ([0-9]+)", true),
	ART_RAMPAGE			("Rampage ([0-9]+)", true),
	AURA_SWAP			("Aura swap ([^\\n,;]+)", false, true),
	AWAKEN				("Awaken ([0-9]+)—([^\\n,;]+)", true, true),
	BANDING				("Banding"),
	BANDS_WITH_OTHER	("Bands with other ([^\\n,;]+)", false, true),
	BATTLE_CRY			("Battle Cry"),
	BESTOW				("Bestow ([^\\n,;]+)", false, true),
	BLOODTHIRST			("Bloodthirst ([0-9]+)", true),
	BUSHIDO				("Bushido ([0-9]+)", true),
	BUYBACK				("Buyback[— ]([^\\n,;]+)", false, true),
	CASCADE				("Cascade"),
	CHAMPION			("Champion ([^\\n,;]+)", false, true),
	CHANGELING			("Changeling"),
	CIPHER				("Cipher"),
	CONSPIRE			("Conspire"),
	CONVOKE				("Convoke"),
	CREW				("Crew ([0-9]+)", true),
	CUMULATIVE_UPKEEP	("Cumulative Upkeep[— ]([^\\n,;]+)", false, true),
	
		PLAINS_CYCLING		("Plainscycling[— ]([^\\n,;]+)", false, true),
		ISLAND_CYCLING		("Islandcycling[— ]([^\\n,;]+)", false, true),
		SWAMP_CYCLING		("Swampcycling[— ]([^\\n,;]+)", false, true),
		MOUNTAIN_CYCLING	("Mountaincycling[— ]([^\\n,;]+)", false, true),
		FOREST_CYCLING		("Forestcycling[— ]([^\\n,;]+)", false, true),
		BASIC_LAND_CYCLING	("Basic landcycling[— ]([^\\n,;]+)", false, true),
		WIZARD_CYCLING		("Wizardcycling[— ]([^\\n,;]+)", false, true),
		SLIVER_CYCLING		("Slivercycling[— ]([^\\n,;]+)", false, true),
	CYCLING				("Cycling[— ]([^\\n,;]+)", false, true),
	
	DASH				("Dash[— ]([^\\n,;]+)", false, true),
	DELVE				("Delve"),
	DEHTRONE			("Dethrone"),
	DEVOID				("Devoid"),
	DEVOUR				("Devour ([0-9]+)", true),
	DREDGE				("Dredge ([0-9]+)", true),
	ECHO				("Echo[— ]*([^\\n,;]*)", false, true),
	EMERGE				("Emerge[— ]([^\\n,;]+)", false, true),
	ENTWINE				("Entwine[— ]([^\\n,;]+)", false, true),
	EPIC				("Epic"),
	ESCALATE			("Escalate[— ]([^\\n,;]+)", false, true),
	EVOKE				("Evoke[— ]([^\\n,;]+)", false, true),
	EVOLVE				("Evolve"),
	EXALTED				("Exalted"),
	EXPLOIT				("Exploit"),
	EXTORT				("Extort"),
	FABRICATE			("Fabricate ([0-9]+)", true),
	FADING				("Fading ([0-9]+)", true),
	FEAR				("Fear"),
	FLANKING			("Flanking"),
	FLASHBACK			("Flashback[— ]([^\\n,;]+)", false, true),
	FORECAST			("Forecast[— ]([^\\n,;]+)", false, true),
	FORTIFY				("Fortify[— ]([^\\n,;]+)", false, true),
	FRENZY				("Frenzy ([0-9]+)", true),
	FUSE				("Fuse"),
	GRAFT				("Graft ([0-9]+)", true),
	GRAVESTORM			("Gravestorm"),
	HAUNT				("Haunt"),
	HIDDEN_AGENDA		("Hidden Agenda"),
	DOUBLE_AGENDA		("Double Agenda"),
	HIDEAWAY			("Hideaway ([0-9]+)", true),
	HORSEMANSHIP		("Horsemanship"),
	INFECT				("Infect"),
	INGEST				("Ingest"),
	INTIMIDATE			("Intimidate"),
	KICKER				("Kicker[— ]([^\\n,;]+)", false, true),
	LEVEL_UP			("Level up[— ]([^\\n,;]+)", false, true),
	LIVING_WEAPON		("Living Weapon"),
	MADNESS				("Madness[— ]([^\\n,;]+)", false, true),
	MEGAMORPH			("Megamorph[— ]([^\\n,;]+)", false, true),
	MELEE				("Melee"),
	MIRACLE				("Miracle[— ]([^\\n,;]+)", false, true),
	MODULAR				("Modular ([0-9]+)", true),
	MORPH				("Morph[— ]([^\\n,;]+)", false, true),
	MULTIKICKER			("Multikicker[— ]([^\\n,;]+)", false, true),
	MYRIAD				("Myriad"),
	NINJUTSU			("Ninjutsu[— ]([^\\n,;]+)", false, true),
	OFFERING			("([^\\n,;]+) offering", false, true),
	OUTLAST				("Outlast[— ]([^\\n,;]+)", false, true),
	OVERLOAD			("Overload[— ]([^\\n,;]+)", false, true),
	PARTNER				("Partner"),
	PERSIST				("Persist"),
	PHASING				("Phasing"),
	POISONOUS			("Poisonous ([0-9]+)", true),
	PROVOKE				("Provoke"),
	PROWL				("Prowl[— ]([^\\n,;]+)", false, true),
	RAMPAGE				("Rampage ([0-9]+)", true),
	REBOUND				("Rebound"),
	RECOVER				("Recover[— ]([^\\n,;]+)", false, true),
	REINFORCE			("Reinforce ([0-9]+)—([^\\n,;]+)", true, true),
	RENOWN				("Renown ([0-9]+)", true),
	REPLICATE			("Replicate[— ]([^\\n,;]+)", false, true),
	RETRACE				("Retrace"),
	RIPPLE				("Ripple ([0-9]+)", true),
	SCAVENGE			("Scavenge[— ]([^\\n,;]+)", false, true),
	SHADOW				("Shadow"),
	SHROUD				("Shroud"),
	SKULK				("Skulk"),
	SOULBOND			("Soulbond"),
	SOULSHIFT			("Soulbond ([0-9]+)", true),
	SPLIT_SECOND		("Split Second"),
	STORM				("Storm"),
	SUNBURST			("Sunburst"),
	SURGE				("Surge[— ]([^\\n,;]+)", false, true),
	SUSPEND				("Suspend ([0-9]+)—([^\\n,;]+)", true, true),
	TOTEM_ARMOR			("Totem Armor"),
	TRANSFIGURE			("Transfigure[— ]([^\\n,;]+)", false, true),
	TRANSMUTE			("Transmute[— ]([^\\n,;]+)", false, true),
	TRIBUTE				("Tribute ([0-9]+)", true),
	UNDAUNTED			("Undaunted"),
	UNDYING				("Undying"),
	UNEARTH				("Unearth[— ]([^\\n,;]+)", false, true),
	UNLEASH				("Unleash"),
	VANISHING			("Vanishing ([0-9]+)", true),
	WITHER				("Wither"),
	
	//****** Landwalk Abilities *******//
	LEGENDARY_LANDWALK	("Legendary Landwalk"),
	PLAINSWALK			("Plainswalk"),
	ISLANDWALK			("Islandwalk"),
	SWAMPWALK			("Swampwalk"),
	MOUNTAINWALK		("Mountainwalk"),
	FORESTWALK			("Forestwalk"),
	
	;
	
	
	public final boolean hasAmount;
	public final boolean hasSubject;
	public final Pattern definition;
	
	private KeywordAbilityDef(String regex){
		this.definition = compilePattern(regex);
		this.hasAmount = false;
		this.hasSubject = false;
	}
	
	private KeywordAbilityDef(String regex, boolean hasAmount){
		this.definition = compilePattern(regex);
		this.hasAmount = hasAmount;
		this.hasSubject = false;
	}
	
	private KeywordAbilityDef(String regex, boolean hasAmount, boolean hasSubject){
		this.definition = compilePattern(regex);
		this.hasAmount = hasAmount;
		this.hasSubject = hasSubject;
	}
	
	private Pattern compilePattern(String regex){
		return Pattern.compile(regex + "[,;]*", Pattern.CASE_INSENSITIVE);
	}

}
