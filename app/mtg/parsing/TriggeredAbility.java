package mtg.parsing;



public class TriggeredAbility extends Ability {
	
	private String rawText;

	private String trigger;					//Whenever X attacks | When X enters the battlefield | At the beginning of your upkeep

	
	private String condition;				//[trigger], if you have 40 or more life
	
	private String effect;					//[trigger], [condition], you win the game
	private String unless;					//[trigger], [effect] unless an opponent pays 2
	private Boolean optional;				//[trigger], you may pay 2
	private String additionalText;			//[trigger], [effect].  You may choose new targets for that spell.

	private String dependentClauseActor;	//[trigger],[effect]. If [actor] do|does, [dependentEffect]
	
	private String dependentEffect;			//[trigger],[effect]. If you do, draw a card.
	private String dependentUnless;			//[trigger],[effect]. [dependentEffect] unless that player pays 2 life.
	private Boolean dependentOptional;		//[trigger],[effect]. If you do, you may draw up to X cards.
	private String dependentAdditionalText;	//[trigger],[effect]. [dependentEffect]. If a creature dealt damage this way would die this turn, exile it instead.
	
	
	public String getTrigger() {
		return trigger;
	}
	public void setTrigger(String trigger) {
		this.trigger = trigger;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
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
	public String getRawText() {
		return rawText;
	}
	public void setRawText(String rawText) {
		this.rawText = rawText;
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

