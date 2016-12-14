package mtg.parsing;

import java.util.ArrayList;
import java.util.List;

import model.Card;
import model.catalog.AbilityWord;
import model.catalog.KeywordAbility;
import model.warehouse.WCard;
import mtg.definitions.CostFlag;
import mtg.definitions.EffectFlag;
import reports.Report;
import reports.ReportFactory;
import reports.ReportRow;

public class CardParser {

	public static WCard parseCard(Card card) {
//		System.out.println("Parsing card : " + card.getCardName());
		WCard wCard = new WCard(card);
		
		if(card.getText() == null) {
			return wCard;
		}
		String[] paragraphs = card.getText().split("\\n");
//		System.out.println("# paragraphs : " + paragraphs.length);
		
		for(String paragraph : paragraphs) {
			parseParagraph(wCard, paragraph);
		}
		
		wCard.setManaCost(AbilityParser.getManaCost(card.getManaCost()));
		return wCard;
	}
	
	public static Report reportCardAbilities(WCard wCard){
		Report report = new Report();
		int count = 0;
		for(Ability ability : wCard.getTriggeredAbilities()){
			ReportRow reportRow = reportAbility(ability, wCard);
			String abilityKey = wCard.getCard().getCardName() + ++count;
			reportRow.putCell("abilityKey", abilityKey);
			report.addReportRow(abilityKey, reportRow);
		}
		for(Ability ability : wCard.getActivatedAbilities()){
			ReportRow reportRow = reportAbility(ability, wCard);
			String abilityKey = wCard.getCard().getCardName() + ++count;
			reportRow.putCell("abilityKey", abilityKey);
			report.addReportRow(abilityKey, reportRow);
		}
		for(Ability ability : wCard.getAbilities()){
			ReportRow reportRow = reportAbility(ability, wCard);
			String abilityKey = wCard.getCard().getCardName() + ++count;
			reportRow.putCell("abilityKey", abilityKey);
			report.addReportRow(abilityKey, reportRow);
		}
		for(KeywordAbilityInstance ability : wCard.getKeywordAbilities()){
			ReportRow reportRow = reportKeywordAbility(ability);
			String abilityKey = wCard.getCard().getCardName() + ++count;
			reportRow.putCell("abilityKey", abilityKey);
			report.addReportRow(abilityKey, reportRow);
		}
		return report;
	}
	
	public static ReportRow reportKeywordAbility(KeywordAbilityInstance ability){
		return ReportFactory.prependColumns(ReportFactory.fromObject(ability), "keyword_");
	}
	
	public static ReportRow reportAbilityWord(AbilityWord ability){
		ReportRow reportRow = new ReportRow();
		reportRow.putCell("abilityword_", ability.getAbilityDef() + "");
		return reportRow;
	}
	
	public static ReportRow reportAbility(Ability ability, WCard wCard){
		ReportRow reportRow = new ReportRow();
		int numCosts = 0;
		for(CostFlag costFlag : ability.getCostFlags()){
			reportRow.putCell(costFlag.toString(), "true");
			numCosts++;
		}
		int numEffects = 0; 
		for(EffectFlag effectFlag : ability.getEffectFlags()){
			reportRow.putCell(effectFlag.toString(), "true");
			numEffects++;
		}
		reportRow.putCell("numCosts", numCosts + "");
		reportRow.putCell("numEffects", numEffects + "");
		ReportRow manaReportRow = ReportFactory.fromObject(ability.getManaCost());
		reportRow = ReportFactory.combine(reportRow, manaReportRow);
		ManaCost combinedCost = ManaCost.combine(wCard.getManaCost(), ability.getManaCost());
		ReportRow combinedManaRow = ReportFactory.prependColumns(ReportFactory.fromObject(combinedCost), "singleuse_");
		reportRow = ReportFactory.combine(reportRow, combinedManaRow);
		ManaCost doubleUse = ManaCost.combine(combinedCost, ability.getManaCost());
		ManaCost tripleUse = ManaCost.combine(doubleUse, ability.getManaCost());
		reportRow.putCell("tripleuse_cmc", tripleUse.getCmc() + "");
		reportRow.putCell("tripleuse_typed", tripleUse.getTyped() + "");
		reportRow.putCell("tripleuse_typedRatio", tripleUse.getTypedRatio() + "");
		
		if(wCard.getAdditionalCost() != null){
			for(CostFlag costFlag : wCard.getAdditionalCost().getCostFlags()){
				reportRow.putCell("card_additional" + costFlag.toString(), "true");
			}
		}
		return reportRow;
	}
	
	public static void parseParagraph(WCard wCard, String paragraph){
//		System.out.println("Parsing Paragraph : " + paragraph);
		paragraph = removeReminderText(paragraph);
		paragraph = replaceReferences(wCard, paragraph);
		
		List<KeywordAbilityInstance> keywordAbilities = parseKeywordAbilities(paragraph);
		if(!keywordAbilities.isEmpty()){
			wCard.getKeywordAbilities().addAll(keywordAbilities);
			return;
		}
		
		
		AbilityWord abilityWord = null;
		String abilityText = paragraph;
		if((abilityWord = AbilityParser.getNextAbilityWord(paragraph)) != null){
			abilityText = abilityWord.getAbilityText();
		}
		
		TriggeredAbility triggeredAbility;
		ActivatedAbility activatedAbility;
		GenericAbility additionalCost;
		
		if((triggeredAbility = AbilityParser.getTriggeredAbility(abilityText)) != null){
			triggeredAbility.setAbilityWord(abilityWord);
			wCard.getTriggeredAbilities().add(triggeredAbility);
		} else if((activatedAbility = AbilityParser.getActivatedAbility(abilityText)) != null){
			activatedAbility.setAbilityWord(abilityWord);
			wCard.getActivatedAbilities().add(activatedAbility);
		} else if((additionalCost = AbilityParser.getAdditionalCost(abilityText)) != null){
			additionalCost.setAbilityWord(abilityWord);
			wCard.setAdditionalCost(additionalCost);
		} else {
			GenericAbility continuousEffect = AbilityParser.getGenericAbility(abilityText);
			continuousEffect.setAbilityWord(abilityWord);
			wCard.getAbilities().add(continuousEffect);
		}
		
//		throw new IllegalStateException("Couldn't find rules to parse paragraph");
	}
	
	public static List<KeywordAbilityInstance> parseKeywordAbilities(String paragraph){
		List<KeywordAbility> keywordAbilities = AbilityParser.getKeywordAbilities(paragraph);
		List<KeywordAbilityInstance> instances = new ArrayList<KeywordAbilityInstance>();
		if(keywordAbilities == null){
			return instances;
		}
		for(KeywordAbility keywordAbility: keywordAbilities){
			KeywordAbilityInstance instance = new KeywordAbilityInstance(keywordAbility);
			instances.add(instance);
		}
		return instances;
	}
	
	public static boolean parseActivatedAbility(WCard wCard, String paragraph) {
		ActivatedAbility activatedAbility = AbilityParser.getActivatedAbility(paragraph);
		if(activatedAbility != null){
//			System.out.println("activatedAbility : " + activatedAbility);
//			System.out.println("cost : " + activatedAbility.getCost());
//			System.out.println("effect: " + activatedAbility.getEffect());
			wCard.getActivatedAbilities().add(activatedAbility);
			return true;
		}
		return false;
	}
	
	public static boolean parseTriggeredAbility(WCard wCard, String paragraph) {
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
			wCard.getTriggeredAbilities().add(triggeredAbility);
			return true;
		}
		return false;
	}
	
	public static boolean parseAdditionalCost(WCard wCard, String paragraph){
		GenericAbility additionalCost = AbilityParser.getAdditionalCost(paragraph);
		if(additionalCost != null){
			wCard.setAdditionalCost(additionalCost);
//			System.out.println("additionalCost : " + additionalCost);
			return true;
		}
		return false;
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
