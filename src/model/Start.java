package model;

import model.Card;

public class Start extends Position<Card>{

	/**
	 * <b>constructor</b>:Constructs a new Mail1 position on board
	 * <b>postcondition</b>:Mail1 on board
	 * 
	 * @param x
	 * @param y
	 * @param day
	 * @param id
	 */
	public Start(String icon) {
		super(icon);
		
	}
	
	/**
	 * <b>transformer(mutative) </b>:perform an action for the player 
	 * <b>postcondition</b>: return a Card
	 *  
	 * @return Card (type:MailCard)
	 */
	public Card performAction() {
		System.out.println("OLA TWRA ARXIZOUN xDDDD xddxxdxdxd");

		return null;
	}
}
