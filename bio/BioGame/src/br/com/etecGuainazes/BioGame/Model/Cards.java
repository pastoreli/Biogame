package br.com.etecGuainazes.BioGame.Model;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class Cards {

	static private CardLayout cl;
	
	static private JPanel cards = new JPanel();

	public static CardLayout getCl() {
		
		return cl;
	
	}

	public static void setCl(CardLayout cl) {
	
		Cards.cl = cl;
	
	}

	public static JPanel getCards() {
	
		return cards;
	
	}

	public static void setCards(JPanel cards) {
	
		Cards.cards = cards;
	
	}
	
	
	
}
