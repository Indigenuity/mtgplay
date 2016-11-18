package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mtgiocardnormalized database table.
 * 
 */
@Entity
@Table(name="mtgiocardnormalized")
@NamedQuery(name="Card.findAll", query="SELECT c FROM Card c")
public class Card implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cardId;

	private String cardName;

	private Float cmc;

	@Column(name="colors___")
	private String colors;

	@Lob
	@Column(name="legalities___")
	private String legalities;

	private String manaCost;

	private String power;

	@Column(name="printings___")
	private String printings;

	private String reserved;

	@Lob
	@Column(name="rulings___")
	private String rulings;

	@Column(name="subtypes___")
	private String subtypes;

	@Column(name="supertypes___")
	private String supertypes;

	private String text;

	private String toughness;

	private String type;

	@Column(name="types___")
	private String types;

	public Card() {
	}

	public int getCardId() {
		return this.cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public String getCardName() {
		return this.cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public float getCmc() {
		return this.cmc;
	}

	public void setCmc(float cmc) {
		this.cmc = cmc;
	}

	public String getColors() {
		return this.colors;
	}

	public void setColors(String colors) {
		this.colors = colors;
	}

	public String getLegalities() {
		return this.legalities;
	}

	public void setLegalities(String legalities) {
		this.legalities = legalities;
	}

	public String getManaCost() {
		return this.manaCost;
	}

	public void setManaCost(String manaCost) {
		this.manaCost = manaCost;
	}

	public String getPower() {
		return this.power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public String getPrintings() {
		return this.printings;
	}

	public void setPrintings(String printings) {
		this.printings = printings;
	}

	public String getReserved() {
		return this.reserved;
	}

	public void setReserved(String reserved) {
		this.reserved = reserved;
	}

	public String getRulings() {
		return this.rulings;
	}

	public void setRulings(String rulings) {
		this.rulings = rulings;
	}

	public String getSubtypes() {
		return this.subtypes;
	}

	public void setSubtypes(String subtypes) {
		this.subtypes = subtypes;
	}

	public String getSupertypes() {
		return this.supertypes;
	}

	public void setSupertypes(String supertypes) {
		this.supertypes = supertypes;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getToughness() {
		return this.toughness;
	}

	public void setToughness(String toughness) {
		this.toughness = toughness;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypes() {
		return this.types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

}