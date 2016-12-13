package mtg.parsing;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import model.catalog.AbilityWord;
import model.catalog.KeywordAbility;
import mtg.catalog.CatalogMaster;
import mtg.definitions.AbilityWordDef;
import mtg.definitions.CostFlag;
import mtg.definitions.EffectFlag;
import mtg.definitions.KeywordAbilityDef;
import mtg.definitions.ManaCostType;

public class AbilityParser {
	
	private static final Pattern TRIGGER = Pattern.compile("^(Whenever|When|At)([^,]+),");
	
	private static final Pattern TRIGGER_CONDITION = Pattern.compile("\\bif([^,]+),");
	
	private static final Pattern EFFECT = Pattern.compile("^([^\\.]+)\\.");
	private static final Pattern UNLESS_CONDITION = Pattern.compile("unless(.+)");
	private static final Pattern OPTIONAL_EFFECT = Pattern.compile(".+may.+");
	
	private static final Pattern SENTENCE = Pattern.compile("^([^\\.]+).");
	
	private static final Pattern DEPENDENT_EFFECT = Pattern.compile("^If([^,]+)(?=does|do)does|do,");
	
	
	private static final Pattern ACTIVATED_ABILITY = Pattern.compile("([^:]+):(.+)");
	
	private static final Pattern MANA_COST_UNIT = Pattern.compile("\\{([^\\}TEQ]+)\\}");
	
	private static final Pattern ADDITIONAL_COST = Pattern.compile("as an additional cost to cast[^,]+,(.+)");
	
	public static ManaCost getManaCost(String text) {
//		System.out.println("parsing mana cost : " + text);
		ManaCost cost = new ManaCost();
		if(StringUtils.isEmpty(text)){
			return cost;
		}
		List<String> manaUnits = new ArrayList<String>();
		Matcher manaMatcher = MANA_COST_UNIT.matcher(text);
		while(manaMatcher.find()){
			manaUnits.add(manaMatcher.group(1));
		}
		
		float cmc = 0;
		float typed = 0;
		for(String manaUnit : manaUnits) {
			ManaCostType found = null;
			float amount = 1;
			for(ManaCostType type : ManaCostType.values()){
				Matcher matcher = type.definition.matcher(manaUnit);
				if(matcher.find()){
					found = type;
					if(matcher.groupCount() > 0){
						amount =  Float.parseFloat(matcher.group(1));
					}
					break;
				}
			}
			if(found == null){
				throw new IllegalStateException("Found unparsed mana unit");
			}
			if(found == ManaCostType.X){
				cost.setHasX(true);
				amount = 0;
			}
			cost.setWhite(found.isWhite);
			cost.setBlue(found.isBlue);
			cost.setBlack(found.isBlack);
			cost.setRed(found.isRed);
			cost.setGreen(found.isGreen);
			cost.setColorless(found.isColorless);
			
			if(found.isTyped) {
				typed++;
			}
			cmc += amount;
			
		}
		cost.setCmc(cmc);
		cost.setTyped(typed);
		return cost;
	}
	
	public static List<EffectFlag> getEffectFlags(String text) {
		Objects.requireNonNull(text);
		List<EffectFlag> effectFlags = new ArrayList<EffectFlag>();
		for(EffectFlag flag : EffectFlag.values()){
			Matcher matcher = flag.definition.matcher(text);
			if(matcher.find()){
				effectFlags.add(flag);
			}
		}
		return effectFlags;
	}

	public static List<CostFlag> getCostFlags(String text) {
		Objects.requireNonNull(text);
		String[] costs = text.split(",");
		List<CostFlag> costFlags = new ArrayList<CostFlag>();
		for(String cost : costs) {
			CostFlag found = null;
			for(CostFlag flag : CostFlag.values()){
				if(flag.definition == null){
					continue;
				}
				Matcher matcher = flag.definition.matcher(cost);
				if(matcher.find()){
					found = flag;
					break;
				}
			}	
			if(found == null){
				Matcher matcher = MANA_COST_UNIT.matcher(cost);	
				if(!matcher.find()){								//Don't add an unknown cost if it's a mana cost
					costFlags.add(CostFlag.OTHER_COST);
				}
			}else{
				costFlags.add(found);	
			}
		}
		return costFlags;
	}
	
	public static Ability getGenericAbility(String text) {
		Ability ability = new Ability();
		ability.setEffectFlags(getEffectFlags(text));
		return ability;
	}
	
	public static Ability getAdditionalCost(String text){
		Ability ability = new Ability();
		Matcher matcher = ADDITIONAL_COST.matcher(text);
		if(matcher.find()){
			ability.setCostFlags(getCostFlags(matcher.group(1)));
			ability.setManaCost(getManaCost(matcher.group(1)));
			return ability;
		}
		return null;
	}
	
	public static ActivatedAbility getActivatedAbility(String text){
//		System.out.println("Parsing activated ability : " + text);
		ActivatedAbility ability = new ActivatedAbility();
		Matcher matcher = ACTIVATED_ABILITY.matcher(text);
		if(matcher.find()){
			String cost = matcher.group(1);
			String effect = matcher.group(2);
			
			if(cost.contains("may") || cost.contains("has")){
				System.out.println("Activated Ability has may or has");
				return null;
			}
			ability.setCost(cost);
			ability.setEffect(effect);
			ability.setCostFlags(getCostFlags(cost));
			ability.setEffectFlags(getEffectFlags(effect));
			ability.setManaCost(getManaCost(cost));
			return ability;
		}
		return null;
	}
	
	public static TriggeredAbility getTriggeredAbility(String text) {
//		System.out.println("Parsing triggered ability : " + text);
		TriggeredAbility ability = new TriggeredAbility();
		String trigger = extractMatch(TRIGGER, text);
		if(trigger == null){
			return null;
		}
		ability.setTrigger(trigger);
		text = text.replaceAll(TRIGGER.pattern(), "");
//		System.out.println("text after trigger : " + text);
		
		String condition = extractMatch(TRIGGER_CONDITION, text);
		if(condition != null) {
			ability.setCondition(condition);
			text = text.replaceAll(TRIGGER_CONDITION.pattern(), "");
//			System.out.println("text after condition : " + text);
		}
		
		String effect = extractMatch(EFFECT, text);
		if(effect == null){
			return null;
		}
		text = text.replaceAll(EFFECT.pattern(), "");
		String unlessCondition = extractMatch(UNLESS_CONDITION, effect);
		if(unlessCondition != null){
			ability.setUnless(unlessCondition);
			effect = effect.replaceAll(UNLESS_CONDITION.pattern(), "").replaceAll("unless", "").trim();
		}
		ability.setEffect(effect);
		ability.setOptional(OPTIONAL_EFFECT.matcher(effect).matches());
		
		String sentence;
		String dependentEffect = null;
		String additionalText = "";
		String dependentAdditionalText = "";
//		System.out.println("text before dealing with sentences : " + text);
		while((sentence = extractMatch(SENTENCE, text)) != null){
			if(dependentEffect != null) {
				dependentAdditionalText += sentence;
			} else {
				dependentEffect = extractMatch(DEPENDENT_EFFECT, text);
				if(dependentEffect != null){
					dependentEffect = sentence;	// The "if you do" clause isn't the full effect.
					String dependentUnlessCondition = extractMatch(UNLESS_CONDITION, dependentEffect);
					if(unlessCondition != null){
						ability.setDependentUnless(dependentUnlessCondition);
						dependentEffect = dependentEffect.replaceAll(UNLESS_CONDITION.pattern(), "").replaceAll("unless", "").trim();
					}
					ability.setDependentEffect(dependentEffect);
				} else {
					additionalText += sentence;
				}
			}
			text = text.replaceAll(SENTENCE.pattern(), "");
		}
		ability.setAdditionalText(additionalText);
		ability.setDependentAdditionalText(dependentAdditionalText);
		
		List<CostFlag> costFlags = getCostFlags(trigger);
		List<EffectFlag> effectFlags = new ArrayList<EffectFlag>();
		if(ability.getOptional() && ability.getDependentEffect() != null){
			costFlags.addAll(getCostFlags(effect));		//Add optional costs like "you may pay {2}"
			ability.setManaCost(getManaCost(effect));
		} else{
			effectFlags.addAll(getEffectFlags(effect));
		}
		
		if(dependentEffect != null){
			effectFlags.addAll(getEffectFlags(dependentEffect));
		}
		ability.setCostFlags(costFlags);
		ability.setEffectFlags(effectFlags);
		
		return ability;
	}
	
	public static String extractMatch(Pattern pattern, String text){
		Matcher matcher = pattern.matcher(text);
		if(matcher.find()){
			return matcher.group(0);
		}
		return null;
	}
	
	public static List<AbilityWord> getAbilityWords(String text) {
		Objects.requireNonNull(text);
		
		List<AbilityWord> abilities = new ArrayList<AbilityWord>();
		
		String remaining = text;
		AbilityWord ability;
		int count = 0;
		while((ability = getNextAbilityWord(remaining)) != null){
			remaining = ability.getAbilityDef().definition.matcher(remaining).replaceAll("").trim();
			abilities.add(ability);
			
			if(count++ > 100){	//Avoid infinite loops while testing
				break;
			}
		}
		if(remaining.isEmpty()){
			return abilities;	
		}
		return null;
	}
	
	public static AbilityWord getNextAbilityWord(String text) {
		if(text == null || text.isEmpty()){
			return null;
		}
		for(AbilityWordDef abilityDef : AbilityWordDef.values()){
//			System.out.println("Checking " + abilityDef + " on remaining text : " + text);
			Matcher matcher = abilityDef.definition.matcher(text);
			if(matcher.find()){
//				System.out.println("Found match : " + abilityDef);
				AbilityWord ability = CatalogMaster.getAbilityWord(abilityDef);
				return ability;
			}
		}
		return null;
	}
	
	//Only returns a list if the entire text can be consumed by keyword ability regexes.  Otherwise returns null.
	public static List<KeywordAbility> getKeywordAbilities(String text){
		Objects.requireNonNull(text);
		
		List<KeywordAbility> abilities = new ArrayList<KeywordAbility>();
		
		String remaining = text;
		KeywordAbility ability;
		int count = 0;
		while((ability = getNextKeywordAbility(remaining)) != null){
			remaining = ability.getAbilityDef().definition.matcher(remaining).replaceAll("").trim();
			abilities.add(ability);
			
			if(count++ > 100){ //Avoid infinite loops while testing
				break;
			}
		}
		if(remaining.isEmpty()){
			return abilities;	
		}
		return null;
	}
	
	public static KeywordAbility getNextKeywordAbility(String text) {
		if(text == null || text.isEmpty()){
			return null;
		}
		for(KeywordAbilityDef abilityDef : KeywordAbilityDef.values()){
//			System.out.println("Checking " + abilityDef + " on remaining text : " + text);
			Matcher matcher = abilityDef.definition.matcher(text);
			if(matcher.find()){
//				System.out.println("Found match : " + abilityDef);
				KeywordAbility ability = CatalogMaster.getKeywordAbility(abilityDef);
				return ability;
			}
		}
		return null;
	}
	
	
}
