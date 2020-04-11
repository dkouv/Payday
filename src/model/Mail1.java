package model;

import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import controller.Controller;
import model.Card;
import view.GraphicUI;

public class Mail1 extends Position<Card>{



	
	/**
	 * <b>constructor</b>:Constructs a new Mail1 position on board
	 * <b>postcondition</b>:Mail1 on board
	 * 
	 * @param x
	 * @param y
	 * @param day
	 * @param id
	 */
	public Mail1(String icon) {
		super(icon);
		
	}
	
	
	/**
	 * <b>transformer(mutative) </b>:perform an action for the player 
	 * <b>postcondition</b>: return a Card
	 *  
	 * @return Card (type:MailCard)
	 */
	public void performAction(Controller c) {
		System.out.println("GET A MAILCARD MOTHERFUCKAA");
		MailCards a = c.getMailCards().remove(0);
		//emfanisi kartas
		GraphicUI g = new GraphicUI(c);
		g.setVisible(true);
		System.out.println(a.getIcon());
		c.mailFunc(a);
		a.performAction(c);
		c.addPlayedMailCards(a);
		
		
	
		
	} 
 
}
