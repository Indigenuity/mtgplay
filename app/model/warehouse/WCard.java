package model.warehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import model.Card;
import model.catalog.AbilityWord;
import model.catalog.KeywordAbility;
import mtg.parsing.Ability;
import mtg.parsing.ActivatedAbility;
import mtg.parsing.GenericAbility;
import mtg.parsing.KeywordAbilityInstance;
import mtg.parsing.ManaCost;
import mtg.parsing.TriggeredAbility;

@Entity
public class WCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long wCardId;
	
	@OneToOne
	private Card card;

	@Transient
	private Map<String, String> stringValues = new HashMap<String, String>();
	@Transient
	private Map<String, Boolean> booleanValues = new HashMap<String, Boolean>();
	@Transient
	private Map<String, Float> floatValues = new HashMap<String, Float>();
	@Transient
	private Map<String, Integer> intValues = new HashMap<String, Integer>();
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval= true)
	private List<KeywordAbilityInstance> keywordAbilities = new ArrayList<KeywordAbilityInstance>();
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval= true)
	private List<TriggeredAbility> triggeredAbilities = new ArrayList<TriggeredAbility>();
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval= true)
	private List<ActivatedAbility> activatedAbilities = new ArrayList<ActivatedAbility>();
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval= true)
	private List<GenericAbility> abilities = new ArrayList<GenericAbility>();
	
	@OneToOne(cascade=CascadeType.ALL, orphanRemoval= true)
	private ManaCost manaCost = new ManaCost();
	@OneToOne(cascade=CascadeType.ALL, orphanRemoval= true)
	private GenericAbility additionalCost;
	
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
	public List<KeywordAbilityInstance> getKeywordAbilities() {
		return keywordAbilities;
	}
	public void setKeywordAbilities(List<KeywordAbilityInstance> keywordAbilities) {
		this.keywordAbilities = keywordAbilities;
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
	public List<GenericAbility> getAbilities() {
		return abilities;
	}
	public void setAbilities(List<GenericAbility> abilities) {
		this.abilities = abilities;
	}
	public GenericAbility getAdditionalCost() {
		return additionalCost;
	}
	public void setAdditionalCost(GenericAbility additionalCost) {
		this.additionalCost = additionalCost;
	}
	public ManaCost getManaCost() {
		return manaCost;
	}
	public void setManaCost(ManaCost manaCost) {
		this.manaCost = manaCost;
	}
	
	
	
	
}
