package model.warehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Card;
import model.catalog.AbilityWord;
import model.catalog.KeywordAbility;

public class WCard {
	
	private Card card;

	private Map<String, String> stringValues = new HashMap<String, String>();
	private Map<String, Boolean> booleanValues = new HashMap<String, Boolean>();
	private Map<String, Float> floatValues = new HashMap<String, Float>();
	private Map<String, Integer> intValues = new HashMap<String, Integer>();
	
	private List<KeywordAbility> keywordAbilities = new ArrayList<KeywordAbility>();
	private List<AbilityWord> abilityWords = new ArrayList<AbilityWord>();
	
	public WCard(){};
	public WCard(Card card) {
		this.card = card;
	}
	public Map<String, String> getStringValues() {
		return stringValues;
	}
	public void setStringValues(Map<String, String> stringValues) {
		this.stringValues = stringValues;
	}
	public Map<String, Boolean> getBooleanValues() {
		return booleanValues;
	}
	public void setBooleanValues(Map<String, Boolean> booleanValues) {
		this.booleanValues = booleanValues;
	}
	public Map<String, Float> getFloatValues() {
		return floatValues;
	}
	public void setFloatValues(Map<String, Float> floatValues) {
		this.floatValues = floatValues;
	}
	public Map<String, Integer> getIntValues() {
		return intValues;
	}
	public void setIntValues(Map<String, Integer> intValues) {
		this.intValues = intValues;
	}
	public List<KeywordAbility> getKeywordAbilities() {
		return keywordAbilities;
	}
	public void setKeywordAbilities(List<KeywordAbility> keywordAbilities) {
		this.keywordAbilities = keywordAbilities;
	}
	public List<AbilityWord> getAbilityWords() {
		return abilityWords;
	}
	public void setAbilityWords(List<AbilityWord> abilityWords) {
		this.abilityWords = abilityWords;
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	
	
	
	
}
