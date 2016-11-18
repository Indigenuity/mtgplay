package experiment;

import java.util.List;

import model.Card;
import play.db.jpa.JPA;

public class Experiment {

	public static void runExperiment(){
		System.out.println("Running experiment");
		List<Card> cards = JPA.em().createQuery("from Card c", Card.class).getResultList();
		System.out.println("cards : " + cards.size());
	}
}
