package mtg.parsing;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class GenericAbility extends Ability {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int genericAbilityId;

}
