package experiment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import final4135.Parser;
import model.Card;
import model.catalog.KeywordAbility;
import model.warehouse.WCard;
import mtg.catalog.CatalogMaster;
import mtg.parsing.Ability;
import mtg.parsing.AbilityParser;
import mtg.parsing.ActivatedAbility;
import mtg.parsing.CardParser;
import mtg.parsing.GenericAbility;
import mtg.parsing.TriggeredAbility;
import play.db.jpa.JPA;
import reports.CSVGenerator;
import reports.Report;
import reports.ReportFactory;

public class Experiment {

	public static void runExperiment() throws Exception{
		System.out.println("Running experiment");
		
		
//		Ability ability;
//		ability = new GenericAbility();
//		JPA.em().persist(ability);
//		
//		ability = new ActivatedAbility();
//		JPA.em().persist(ability);
		
//		ability = new TriggeredAbility();
//		JPA.em().persist(ability);
//		
//		ability = new GenericAbility();
//		JPA.em().persist(ability);
		
//		Parser.readAccess();
//		Parser.removeQueries();
		
//		CatalogMaster.buildCatalogs(); 
		List<Card> cards = JPA.em().createQuery("from Card c where legalities___ not like '%Un-Sets%' and not exists (select 'found' from WCard wc where wc.card = c) ", Card.class)
//				.setMaxResults(10)
//				.setFirstResult(1000)
				.getResultList();
		System.out.println("cards : " + cards.size());
		
		List<WCard> wCards = new ArrayList<WCard>();
		int count = 0;
		for(Card card : cards) {
			WCard wCard;
			if((wCard = CatalogMaster.getWCard(card)) == null){
				wCard = CardParser.parseCard(card);
				JPA.em().persist(wCard);
			}
			wCards.add(wCard);
			if(count++ %100 == 0){
				System.out.println("count : " + count);
				JPA.em().getTransaction().commit();
				JPA.em().getTransaction().begin();
			}
		}
		
//		for(WCard wCard : wCards) {
//			JPA.em().persist(wCard);
//		}
//		
//		Report totalReport = new Report();
//		for(WCard wCard : wCards) {
//			Report report = CardParser.reportCardAbilities(wCard);
//			totalReport = ReportFactory.combine(totalReport, report);
//		}
//		
//		CSVGenerator.printReport(totalReport);
		
		
		
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
