package mtg.parsing;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import mtg.definitions.CostFlag;

@Entity
public class ActivatedAbility extends Ability{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int activatedAbilityId;
	
	@Column(nullable = true, columnDefinition="varchar(1000)")
	private String cost;
	@Column(nullable = true, columnDefinition="varchar(1000)")
	private String effect;
	
	
	public String getCost() {
	
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getEffect() {
		return effect;
	}
	public void setEffect(String effect) {
		this.effect = effect;
	}
	public List<CostFlag> getCostFlags() {
		return costFlags;
	}
	public void setCostFlags(List<CostFlag> costFlags) {
		this.costFlags = costFlags;
	}
	
}
