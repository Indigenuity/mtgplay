package mtg.parsing;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import model.catalog.AbilityWord;
import mtg.definitions.EffectFlag;
import mtg.definitions.CostFlag;

@MappedSuperclass
//@Entity
public class Ability {
	
	@Enumerated(EnumType.STRING)
	@ElementCollection(fetch=FetchType.LAZY)
	protected List<EffectFlag> effectFlags = new ArrayList<EffectFlag>();
	
	@Enumerated(EnumType.STRING)
	@ElementCollection(fetch=FetchType.LAZY)
	protected List<CostFlag> costFlags = new ArrayList<CostFlag>();

	@OneToOne(cascade=CascadeType.ALL, orphanRemoval= true)
	protected ManaCost manaCost = new ManaCost();
	
	@Column(nullable = true, columnDefinition="varchar(1000)")
	protected String rawText;
	
	@ManyToOne
	protected AbilityWord abilityWord;
	
	public List<EffectFlag> getEffectFlags() {
		return effectFlags;
	}
	public void setEffectFlags(List<EffectFlag> effectFlags) {
		this.effectFlags = effectFlags;
	}
	public List<CostFlag> getCostFlags() {
		return costFlags;
	}
	public void setCostFlags(List<CostFlag> costFlags) {
		this.costFlags = costFlags;
	}
	public ManaCost getManaCost() {
		return manaCost;
	}
	public void setManaCost(ManaCost manaCost) {
		this.manaCost = manaCost;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("\n\tCostFlags: ");
		String delimiter = "";
		for(CostFlag costFlag : costFlags){
			sb.append(delimiter);
			sb.append(costFlag);
			delimiter = ", ";
		}
		sb.append("\n\tEffectFlags: ");
		delimiter = "";
		for(EffectFlag effectFlag : effectFlags){
			sb.append(delimiter);
			sb.append(effectFlag);
			delimiter = ", ";
		}
		if(manaCost != null){
			sb.append("\n\tCMC : ");
			sb.append(manaCost.getCmc());
		}
		return sb.toString();
	}
	public String getRawText() {
		return rawText;
	}
	public void setRawText(String rawText) {
		this.rawText = rawText;
	}
	public AbilityWord getAbilityWord() {
		return abilityWord;
	}
	public void setAbilityWord(AbilityWord abilityWord) {
		this.abilityWord = abilityWord;
	}
	
	
}
