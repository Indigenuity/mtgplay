package mtg.parsing;

import java.util.List;

import model.Card;
import model.catalog.AbilityWord;
import model.catalog.KeywordAbility;
import model.warehouse.WCard;

public class CardParser {

	public static WCard parseCard(Card card) {
		System.out.println("Parsing card : " + card.getCardName());
		WCard wCard = new WCard();
		
		String[] paragraphs = card.getText().split("\\n");
		System.out.println("# paragraphs : " + paragraphs.length);
		
		for(String paragraph : paragraphs) {
			parseParagraph(wCard, paragraph);
		}
		
		return wCard;
	}
	
	public static void parseParagraph(WCard wCard, String paragraph){
		System.out.println("Parsing Paragraph : " + paragraph);
		paragraph = removeReminderText(paragraph);
		
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
		
		throw new IllegalStateException("Couldn't find rules to parse paragraph");
	}
	
	public static String removeReminderText(String text) {
		if(text == null){
			return null;
		}
		return text.replaceAll("\\([^\\(\\)]+\\)", "").trim();
	}
}
