package mtg.parsing;

import java.util.List;

import mtg.definitions.CostFlag;

public class ActivatedAbility extends Ability{

	private String cost;
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
