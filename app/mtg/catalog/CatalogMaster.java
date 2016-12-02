package mtg.catalog;

import java.util.List;

import model.catalog.AbilityWord;
import model.catalog.KeywordAbility;
import mtg.definitions.AbilityWordDef;
import mtg.definitions.KeywordAbilityDef;
import play.db.jpa.JPA;

public class CatalogMaster {
	
	public static void buildCatalogs() {
		System.out.println("Building catalogs");
		buildKeywordAbilityCatalog();
		buildAbilityWordCatalog();
	}

	public static void buildKeywordAbilityCatalog(){
		System.out.println("Building Keyword Ability catalog");
		for(KeywordAbilityDef abilityDef : KeywordAbilityDef.values()){
			KeywordAbility ability = getKeywordAbility(abilityDef);
			if(ability == null){
				ability = new KeywordAbility();
				ability.setAbilityDef(abilityDef);
				JPA.em().persist(ability);
			}
		}
	}
	
	public static void buildAbilityWordCatalog() {
		System.out.println("Building Ability Word catalog");
		for(AbilityWordDef abilityDef : AbilityWordDef.values()){
			AbilityWord ability = getAbilityWord(abilityDef);
			if(ability == null) {
				ability = new AbilityWord();
				ability.setAbilityDef(abilityDef);
				JPA.em().persist(ability);
			}
		}
	}
	
	
	
	
	
	public static KeywordAbility getKeywordAbility(KeywordAbilityDef abilityDef){
		String queryString = "from KeywordAbility ka where ka.abilityDef = :abilityDef";
		List<KeywordAbility> results = JPA.em().createQuery(queryString, KeywordAbility.class)
				.setParameter("abilityDef", abilityDef)
				.getResultList();
		if(results.size()> 1){
			throw new IllegalStateException("Catalog is corrupted.  Two definitions found for keyword ability : " + abilityDef);
		} else if(results.size() == 1){
			return results.get(0);
		}
		return null;
	}
	
	public static AbilityWord getAbilityWord(AbilityWordDef abilityDef){
		String queryString = "from AbilityWord aw where aw.abilityDef = :abilityDef";
		List<AbilityWord> results = JPA.em().createQuery(queryString, AbilityWord.class)
				.setParameter("abilityDef", abilityDef)
				.getResultList();
		if(results.size()> 1){
			throw new IllegalStateException("Catalog is corrupted.  Two definitions found for ability word : " + abilityDef);
		} else if(results.size() == 1){
			return results.get(0);
		}
		return null;
	}
}
