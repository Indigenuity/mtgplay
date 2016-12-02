package model.catalog;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.envers.Audited;

import mtg.definitions.ActionSpeed;
import mtg.definitions.KeywordAbilityDef;

@Entity
@Audited(withModifiedFlag=true)
public class KeywordAbility {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long keywordAbilityId;
	
	@Enumerated(EnumType.STRING)
	private KeywordAbilityDef abilityDef;
	
	private Boolean functionsInGraveyard;
	private Boolean functionsInHand;
	private Boolean functionsInBattlefield;
	private Boolean modifiedResolution;
	
	private Boolean isAdditionalCost;
	private Boolean isAlternateCost;
	
	private Boolean hasCost;
	
	private Boolean reducesCost;
	private Boolean easesCosts;
	
	private Boolean isTriggered;
	private Boolean isActivated;
	private Boolean isContinuous;
	private Boolean hasTargets;
	
	private ActionSpeed actionSpeed;
	
	private Boolean isEvasion;

	public long getKeywordAbilityId() {
		return keywordAbilityId;
	}

	public void setKeywordAbilityId(long keywordAbilityId) {
		this.keywordAbilityId = keywordAbilityId;
	}

	public KeywordAbilityDef getAbilityDef() {
		return abilityDef;
	}

	public void setAbilityDef(KeywordAbilityDef abilityDef) {
		this.abilityDef = abilityDef;
	}

	public Boolean getFunctionsInGraveyard() {
		return functionsInGraveyard;
	}

	public void setFunctionsInGraveyard(Boolean functionsInGraveyard) {
		this.functionsInGraveyard = functionsInGraveyard;
	}

	public Boolean getFunctionsInHand() {
		return functionsInHand;
	}

	public void setFunctionsInHand(Boolean functionsInHand) {
		this.functionsInHand = functionsInHand;
	}

	public Boolean getFunctionsInBattlefield() {
		return functionsInBattlefield;
	}

	public void setFunctionsInBattlefield(Boolean functionsInBattlefield) {
		this.functionsInBattlefield = functionsInBattlefield;
	}

	public Boolean getIsAdditionalCost() {
		return isAdditionalCost;
	}

	public void setIsAdditionalCost(Boolean isAdditionalCost) {
		this.isAdditionalCost = isAdditionalCost;
	}

	public Boolean getIsAlternateCost() {
		return isAlternateCost;
	}

	public void setIsAlternateCost(Boolean isAlternateCost) {
		this.isAlternateCost = isAlternateCost;
	}

	public Boolean getHasCost() {
		return hasCost;
	}

	public void setHasCost(Boolean hasCost) {
		this.hasCost = hasCost;
	}

	public Boolean getReducesCost() {
		return reducesCost;
	}

	public void setReducesCost(Boolean reducesCost) {
		this.reducesCost = reducesCost;
	}

	public Boolean getEasesCosts() {
		return easesCosts;
	}

	public void setEasesCosts(Boolean easesCosts) {
		this.easesCosts = easesCosts;
	}

	public Boolean getIsTriggered() {
		return isTriggered;
	}

	public void setIsTriggered(Boolean isTriggered) {
		this.isTriggered = isTriggered;
	}

	public Boolean getIsActivated() {
		return isActivated;
	}

	public void setIsActivated(Boolean isActivated) {
		this.isActivated = isActivated;
	}

	public Boolean getIsContinuous() {
		return isContinuous;
	}

	public void setIsContinuous(Boolean isContinuous) {
		this.isContinuous = isContinuous;
	}

	public Boolean getHasTargets() {
		return hasTargets;
	}

	public void setHasTargets(Boolean hasTargets) {
		this.hasTargets = hasTargets;
	}

	public ActionSpeed getActionSpeed() {
		return actionSpeed;
	}

	public void setActionSpeed(ActionSpeed actionSpeed) {
		this.actionSpeed = actionSpeed;
	}

	public Boolean getIsEvasion() {
		return isEvasion;
	}

	public void setIsEvasion(Boolean isEvasion) {
		this.isEvasion = isEvasion;
	}

	public Boolean getModifiedResolution() {
		return modifiedResolution;
	}

	public void setModifiedResolution(Boolean modifiedResolution) {
		this.modifiedResolution = modifiedResolution;
	}

	public String toString() {
		return abilityDef.toString();
	}
	
	
}
