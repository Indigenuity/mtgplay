package mtg;

import java.util.regex.Pattern;

public enum KeywordAbility {
	
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
	CYCLING				("Cycling[— ]([^\\n,;]+)", false, true),
	DASH				("Dash[— ]([^\\n,;]+)", false, true),
	DELVE				("Delve"),
	DEHTRONE			("Dethrone"),
	DEVOID				("Devoid"),
	DEVOUR				("Devour ([0-9]+)", true),
	DREDGE				("Dredge ([0-9]+)", true),
	ECHO				("Echo[— ]([^\\n,;]+)", false, true),
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
	PROTECTION			("Protection from ([^\\n,;]+)", false, true),
	PROVOKE				("Provoke"),
	PROWL				("Prowl[— ]([^\\n,;]+)", false, true),
	RAMPAGE				("Rampage ([0-9]+)", true),
	REBOUND				("Rebound"),
	RECOVER				("Recover[— ]([^\\n,;]+)", false, true),
	REINFORCE			("Reinforce ([0-9]+)—([^\\n,;]+)", true, true),
	RENOWN
	REPLICATE
	RETRACE
	RIPPLE
	SCAVENGE
	SHADOW
	SHROUD
	SKULK
	SOULBOND
	SOULSHIFT
	SPLICE
	SPLIT_SECOND
	STORM
	SUNBURST
	SURGE
	SUSPEND
	TOTEM_ARMOR
	TRANSFIGURE
	TRANSMUTE
	TRIBUTE
	UNDAUNTED
	UNDYING
	UNEARTH
	UNLEASH
	VANISHING
	WITHER
	
	LEGENDARY_LANDWALK
	PLAINSWALK
	ISLANDWALK
	SWAMPWALK
	MOUNTAINWALK
	FORESTWALK
	NONBASIC_LANDWALK
	SNOW_PLAINSWALK
	SNOW_ISLANDWALK
	SNOW_SWAMPWALK
	SNOW_MOUNTAINWALK
	SNOW_FORESTWALK
	SNOW_COVERED_PLAINSWALK
	SNOW_LANDWALK
	;
	
	
	public final boolean hasAmount;
	public final boolean hasSubject;
	public final Pattern definition;
	
	private KeywordAbility(String regex){
		this.definition = Pattern.compile(regex);
		this.hasAmount = false;
		this.hasSubject = false;
	}
	
	private KeywordAbility(String regex, boolean hasAmount){
		this.definition = Pattern.compile(regex);
		this.hasAmount = hasAmount;
		this.hasSubject = false;
	}
	
	private KeywordAbility(String regex, boolean hasAmount, boolean hasSubject){
		this.definition = Pattern.compile(regex);
		this.hasAmount = hasAmount;
		this.hasSubject = hasSubject;
	}

}
