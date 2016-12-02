package mtg.parsing;

import java.util.List;

import model.Card;
import model.catalog.AbilityWord;
import model.catalog.KeywordAbility;
import model.warehouse.WCard;

public class CardParser {

	public static WCard parseCard(Card card) {
		System.out.println("Parsing card : " + card.getCardName());
		WCard wCard = new WCard(card);
		
		if(card.getText() == null) {
			return wCard;
		}
		String[] paragraphs = card.getText().split("\\n");
//		System.out.println("# paragraphs : " + paragraphs.length);
		
		for(String paragraph : paragraphs) {
			parseParagraph(wCard, paragraph);
		}
		
		return wCard;
	}
	
	public static void parseParagraph(WCard wCard, String paragraph){
		System.out.println("Parsing Paragraph : " + paragraph);
		paragraph = removeReminderText(paragraph);
		paragraph = replaceReferences(wCard, paragraph);
		
		List<KeywordAbility> keywordAbilities = AbilityParser.getKeywordAbilities(paragraph);
		if(keywordAbilities != null){
			wCard.setKeywordAbilities(keywordAbilities);
			return;
		}
		
		List<AbilityWord> abilityWords = AbilityParser.getAbilityWords(paragraph);
		if(abilityWords != null){
			wCard.setAbilityWords(abilityWords);
			return;
		}
		
		TriggeredAbility triggeredAbility = AbilityParser.getTriggeredAbility(paragraph);
		
		if(triggeredAbility != null){
//			System.out.println("TriggeredAbility : " + triggeredAbility);
//			System.out.println("Trigger : " + triggeredAbility.getTrigger());
//			System.out.println("condition: " + triggeredAbility.getCondition());
//			System.out.println("effect: " + triggeredAbility.getEffect());
//			System.out.println("unless: " + triggeredAbility.getUnless());
//			System.out.println("additional text: " + triggeredAbility.getAdditionalText());
//			System.out.println("dependenteffect: " + triggeredAbility.getDependentEffect());
//			System.out.println("dependentunless: " + triggeredAbility.getDependentUnless());
//			System.out.println("dependentoptinoal: " + triggeredAbility.getDependentOptional());
//			System.out.println("dependentadditionaltext: " + triggeredAbility.getDependentAdditionalText());
			return;
		}
		
		ActivatedAbility activatedAbility = AbilityParser.getActivatedAbility(paragraph);
		if(activatedAbility != null){
//			System.out.println("activatedAbility : " + activatedAbility);
//			System.out.println("cost : " + activatedAbility.getCost());
//			System.out.println("effect: " + activatedAbility.getEffect());
			return;
		}
		
		System.out.println("************* Continuous Effect");
		return;
		
		
//		throw new IllegalStateException("Couldn't find rules to parse paragraph");
	}
	
	public static String replaceReferences(WCard wCard, String text) {
		String cardName = wCard.getCard().getCardName();
		text = text.replaceAll(cardName, "cardself");
		return text;
	}
	
	public static String removeReminderText(String text) {
		if(text == null){
			return null;
		}
		return text.replaceAll("\\([^\\(\\)]+\\)", "").trim();
	}
}
