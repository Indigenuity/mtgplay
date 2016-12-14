package model.catalog;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.envers.Audited;

import mtg.definitions.AbilityWordDef;

@Entity
@Audited(withModifiedFlag=true)
public class AbilityWord {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long abilityWordId; 

	@Enumerated(EnumType.STRING)
	private AbilityWordDef abilityDef;
	
	
	@Column(nullable = true, columnDefinition="varchar(1000)")
	private String abilityText;
	
	
	public AbilityWordDef getAbilityDef() {
		return abilityDef;
	}
	public void setAbilityDef(AbilityWordDef abilityDef) {
		this.abilityDef = abilityDef;
	}
	public String getAbilityText() {
		return abilityText;
	}
	public void setAbilityText(String abilityText) {
		this.abilityText = abilityText;
	}
	
	
}
