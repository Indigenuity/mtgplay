package mtg.parsing;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.catalog.AbilityWord;
import model.catalog.KeywordAbility;
import mtg.catalog.CatalogMaster;
import mtg.definitions.AbilityWordDef;
import mtg.definitions.KeywordAbilityDef;

public class AbilityParser {
	
	private static final Pattern TRIGGER = Pattern.compile("^(Whenever|When|At)([^,]+),");
	
	private static final Pattern TRIGGER_CONDITION = Pattern.compile("\\bif([^,]+),");
	
	private static final Pattern EFFECT = Pattern.compile("^([^\\.]+)\\.");
	private static final Pattern UNLESS_CONDITION = Pattern.compile("unless(.+)");
	private static final Pattern OPTIONAL_EFFECT = Pattern.compile(".+may.+");
	
	private static final Pattern SENTENCE = Pattern.compile("^([^\\.]+).");
	
	private static final Pattern DEPENDENT_EFFECT = Pattern.compile("^If([^,]+)(?=does|do)does|do,");
	
	
	private static final Pattern ACTIVATED_ABILITY = Pattern.compile("([^:]+):(.+)");
	
	
	
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
			System.out.println("Dealing with sentence : " + sentence);
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
