package mtg.parsing;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class TriggeredAbility extends Ability {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int triggeredAbilityId;
	
	private String triggerText;					//Whenever X attacks | When X enters the battlefield | At the beginning of your upkeep

	
	private String conditionText;				//[trigger], if you have 40 or more life
	
	@Column(nullable = true, columnDefinition="varchar(1000)")
	private String effect;					//[trigger], [condition], you win the game
	private String unless;					//[trigger], [effect] unless an opponent pays 2
	private Boolean optional;				//[trigger], you may pay 2
	@Column(nullable = true, columnDefinition="varchar(1000)")
	private String additionalText;			//[trigger], [effect].  You may choose new targets for that spell.

	private String dependentClauseActor;	//[trigger],[effect]. If [actor] do|does, [dependentEffect]
	
	@Column(nullable = true, columnDefinition="varchar(1000)")
	private String dependentEffect;			//[trigger],[effect]. If you do, draw a card.
	private String dependentUnless;			//[trigger],[effect]. [dependentEffect] unless that player pays 2 life.
	private Boolean dependentOptional;		//[trigger],[effect]. If you do, you may draw up to X cards.
	@Column(nullable = true, columnDefinition="varchar(1000)")
	private String dependentAdditionalText;	//[trigger],[effect]. [dependentEffect]. If a creature dealt damage this way would die this turn, exile it instead.
	
	
	public String getTrigger() {
		return triggerText;
	}
	public void setTrigger(String trigger) {
		this.triggerText = trigger;
	}
	public String getCondition() {
		return conditionText;
	}
	public void setCondition(String condition) {
		this.conditionText = condition;
	}
	public String getEffect() {
		return effect;
	}
	public void setEffect(String effect) {
		this.effect = effect;
	}
	public String getUnless() {
		return unless;
	}
	public void setUnless(String unless) {
		this.unless = unless;
	}
	public Boolean getOptional() {
		return optional;
	}
	public void setOptional(Boolean optional) {
		this.optional = optional;
	}
	public String getDependentEffect() {
		return dependentEffect;
	}
	public void setDependentEffect(String dependentEffect) {
		this.dependentEffect = dependentEffect;
	}
	public String getDependentUnless() {
		return dependentUnless;
	}
	public void setDependentUnless(String dependentUnless) {
		this.dependentUnless = dependentUnless;
	}
	public String getDependentClauseActor() {
		return dependentClauseActor;
	}
	public void setDependentClauseActor(String dependentClauseActor) {
		this.dependentClauseActor = dependentClauseActor;
	}
	public String getAdditionalText() {
		return additionalText;
	}
	public void setAdditionalText(String additionalText) {
		this.additionalText = additionalText;
	}
	public String getDependentAdditionalText() {
		return dependentAdditionalText;
	}
	public void setDependentAdditionalText(String dependentAdditionalText) {
		this.dependentAdditionalText = dependentAdditionalText;
	}
	public Boolean getDependentOptional() {
		return dependentOptional;
	}
	public void setDependentOptional(Boolean dependentOptional) {
		this.dependentOptional = dependentOptional;
	}
	//These aren't truly optional.  The effect happens, these just specify part of the effect.
//	private Boolean partialOptional;			//[trigger], copy that spell.  You may choose new targets for that spell.
//	private Boolean dependentPartialOptional;	//[trigger],[effect]. [dependentEffect
	
	
	
}

