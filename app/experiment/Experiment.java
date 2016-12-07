package experiment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Card;
import model.catalog.KeywordAbility;
import model.warehouse.WCard;
import mtg.catalog.CatalogMaster;
import mtg.parsing.AbilityParser;
import mtg.parsing.CardParser;
import play.db.jpa.JPA;
import reports.CSVGenerator;
import reports.Report;
import reports.ReportFactory;

public class Experiment {

	public static void runExperiment() throws IOException{
		System.out.println("Running experiment");
//		CatalogMaster.buildCatalogs();
		List<Card> cards = JPA.em().createQuery("from Card c where printings___ not like '%Un-Sets%'", Card.class)
//				.setMaxResults(10)
//				.setFirstResult(1)
				.getResultList();
		System.out.println("cards : " + cards.size());
		
		List<WCard> wCards = new ArrayList<WCard>();
		for(Card card : cards) {
			wCards.add(CardParser.parseCard(card));
		}
		
		Report totalReport = new Report();
		for(WCard wCard : wCards) {
			Report report = CardParser.reportCardAbilities(wCard);
			totalReport = ReportFactory.combine(totalReport, report);
		}
		
		CSVGenerator.printReport(totalReport);
		
		
		
		//Old Fogey 18740
//		Card card = JPA.em().find(Card.class, 13192);
//		CardParser.parseCard(card);
//		
//		String abilityText = card.getText();
//		System.out.println("abilityText : " + abilityText);
//		
//		String[] paragraphs = abilityText.split("\\n");
//		System.out.println("paragraphs : " + paragraphs.length);
//		for(String paragraph : paragraphs) {
//			System.out.println("paragraph : " + paragraph);
////			System.out.println("replaced : " + AbilityParser.removeReminderText(paragraph));
//			List<KeywordAbility> keywordAbilities = AbilityParser.getKeywordAbilities(paragraph);
//			System.out.println("keywordAbilities : " + keywordAbilities);
//		}
		
		
	}
}
