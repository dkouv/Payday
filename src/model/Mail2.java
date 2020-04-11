package model;

import controller.Controller;
import model.Card;
import view.GraphicUI;

public class Mail2 extends Position<Card>{
	
	/**
	 * <b>constructor</b>:Constructs a new Mail2 position on board
	 * <b>postcondition</b>:Mail2 on board
	 * 
	 * @param x
	 * @param y
	 * @param day
	 * @param id
	 */
	public Mail2(String icon) {
		super(icon);
	}
	
	/**
	 * <b>transformer(mutative) </b>:perform an action for the player 
	 * <b>postcondition</b>: return 2 Cards
	 *  
	 * @return 2 Cards (type:MailCard)
	 */
	public void performAction(Controller c) {
		System.out.println("GET 2 MAILCARDS");
		MailCards a = c.getMailCards().remove(0);
		
		System.out.println(a.getIcon());
		c.mailFunc(a);
		a.performAction(c);
		
		MailCards b = c.getMailCards().remove(0);
		
		
		System.out.println(b.getIcon());
		c.mailFunc(b);
		b.performAction(c);
		repaint();
		GraphicUI g = new GraphicUI(c);
		g.setVisible(true);
		
	}
}
 