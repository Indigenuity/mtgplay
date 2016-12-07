package model.warehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Card;
import model.catalog.AbilityWord;
import model.catalog.KeywordAbility;
import mtg.parsing.Ability;
import mtg.parsing.ActivatedAbility;
import mtg.parsing.ManaCost;
import mtg.parsing.TriggeredAbility;

public class WCard {
	
	private Card card;

	private Map<String, String> stringValues = new HashMap<String, String>();
	private Map<String, Boolean> booleanValues = new HashMap<String, Boolean>();
	private Map<String, Float> floatValues = new HashMap<String, Float>();
	private Map<String, Integer> intValues = new HashMap<String, Integer>();
	
	private List<KeywordAbility> keywordAbilities = new ArrayList<KeywordAbility>();
	private List<AbilityWord> abilityWords = new ArrayList<AbilityWord>();
	private List<TriggeredAbility> triggeredAbilities = new ArrayList<TriggeredAbility>();
	private List<ActivatedAbility> activatedAbilities = new ArrayList<ActivatedAbility>();
	private List<Ability> abilities = new ArrayList<Ability>();
	
	private ManaCost manaCost;
	private Ability additionalCost;
	
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
	public List<TriggeredAbility> getTriggeredAbilities() {
		return triggeredAbilities;
	}
	public void setTriggeredAbilities(List<TriggeredAbility> triggeredAbilities) {
		this.triggeredAbilities = triggeredAbilities;
	}
	public List<ActivatedAbility> getActivatedAbilities() {
		return activatedAbilities;
	}
	public void setActivatedAbilities(List<ActivatedAbility> activatedAbilities) {
		this.activatedAbilities = activatedAbilities;
	}
	public List<Ability> getAbilities() {
		return abilities;
	}
	public void setAbilities(List<Ability> abilities) {
		this.abilities = abilities;
	}
	public Ability getAdditionalCost() {
		return additionalCost;
	}
	public void setAdditionalCost(Ability additionalCost) {
		this.additionalCost = additionalCost;
	}
	public ManaCost getManaCost() {
		return manaCost;
	}
	public void setManaCost(ManaCost manaCost) {
		this.manaCost = manaCost;
	}
	
	
	
	
}
