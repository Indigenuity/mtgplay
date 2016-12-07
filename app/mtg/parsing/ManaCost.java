package mtg.parsing;

import java.util.HashMap;
import java.util.Map;

import mtg.definitions.ManaCostType;

public class ManaCost {

	private Map<ManaCostType, Integer> costMap = new HashMap<ManaCostType, Integer>();
	
	private boolean hasX = false;
	private boolean isWhite = false;
	private boolean isBlue = false;
	private boolean isBlack = false;
	private boolean isRed = false;
	private boolean isGreen = false;
	private boolean isColorless = false;
	
	private float cmc;
	private float typed ;
	private float typedRatio;
	
	//Called whenever cmc or typed is set
	public void setTypedRatio(){
		if(cmc != 0){
			typedRatio = typed/cmc;
		}else {
			typedRatio = 0;
		}
	}
	
	public static ManaCost combine(ManaCost first, ManaCost second) {
		ManaCost newCost = new ManaCost();
		newCost.setWhite(first.isWhite() || second.isWhite());
		newCost.setBlue(first.isBlue() || second.isBlue());
		newCost.setBlack(first.isBlack() || second.isBlack());
		newCost.setRed(first.isRed() || second.isRed());
		newCost.setGreen(first.isGreen() || second.isGreen());
		newCost.setColorless(first.isColorless() || second.isColorless());
		newCost.setCmc(first.getCmc() + second.getCmc());
		newCost.setTyped(first.getTyped() + second.getTyped());
		newCost.getCostMap().putAll(first.getCostMap());
		newCost.getCostMap().putAll(second.getCostMap());
		return newCost;
	}

	public Map<ManaCostType, Integer> getCostMap() {
		return costMap;
	}
	public void setCostMap(Map<ManaCostType, Integer> costMap) {
		this.costMap = costMap;
	}
	public boolean isHasX() {
		return hasX;
	}
	public void setHasX(boolean hasX) {
		this.hasX = hasX;
	}
	public boolean isWhite() {
		return isWhite;
	}
	
	public void setWhite(boolean isWhite) {
		this.isWhite = isWhite;
	}
	public boolean isBlue() {
		return isBlue;
	}
	public void setBlue(boolean isBlue) {
		this.isBlue = isBlue;
	}
	public boolean isRed() {
		return isRed;
	}
	public void setRed(boolean isRed) {
		this.isRed = isRed;
	}
	public boolean isGreen() {
		return isGreen;
	}
	public void setGreen(boolean isGreen) {
		this.isGreen = isGreen;
	}
	public boolean isColorless() {
		return isColorless;
	}
	public void setColorless(boolean isColorless) {
		this.isColorless = isColorless;
	}
	public boolean isBlack() {
		return isBlack;
	}
	public void setBlack(boolean isBlack) {
		this.isBlack = isBlack;
	}

	public float getCmc() {
		return cmc;
	}

	public void setCmc(float cmc) {
		this.cmc = cmc;
		setTypedRatio();
	}

	public float getTyped() {
		return typed;
	}

	public void setTyped(float typed) {
		this.typed = typed;
		setTypedRatio();
	}

	public float getTypedRatio() {
		return typedRatio;
	}

	public void setTypedRatio(float typedRatio) {
		this.typedRatio = typedRatio;
	}

	
	
	//******* for BeanUtils..... blah
	public boolean isIsWhite(){
		return isWhite;
	}
	public boolean isIsBlue() {
		return isBlue;
	}
	public boolean isIsRed() {
		return isRed;
	}
	public boolean isIsGreen() {
		return isGreen;
	}
	public boolean isIsColorless() {
		return isColorless;
	}
	public boolean isIsBlack() {
		return isBlack;
	}
	
	
	
}
