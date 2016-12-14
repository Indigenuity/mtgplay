package mtg.parsing;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import model.catalog.KeywordAbility;

@Entity
public class KeywordAbilityInstance extends Ability {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int keywordAbilityInstanceId;
	
	@ManyToOne
	protected KeywordAbility ability;
	
	protected String amountString;
	protected Float amount;
	protected String subject;
	
	
	
	public KeywordAbilityInstance(KeywordAbility ability) {
		super();
		this.ability = ability;
	}
	
	private KeywordAbilityInstance() {
		super();
	}
	
	public KeywordAbility getAbility() {
		return ability;
	}
	public void setAbility(KeywordAbility ability) {
		this.ability = ability;
	}
	public String getAmountString() {
		return amountString;
	}
	public void setAmountString(String amountString) {
		this.amountString = amountString;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
	
}
