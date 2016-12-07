package mtg.parsing;

import java.util.ArrayList;
import java.util.List;

import mtg.definitions.EffectFlag;
import mtg.definitions.CostFlag;

public class Ability {

	protected List<EffectFlag> effectFlags = new ArrayList<EffectFlag>();
	protected List<CostFlag> costFlags = new ArrayList<CostFlag>();
	private ManaCost manaCost = new ManaCost();
	
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
	
	
}
