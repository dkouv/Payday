package model;

import controller.Controller;
import view.GraphicUI;

public class Deal extends Position<Boolean> {
	
	/**
	 * <b>constructor</b>:Constructs a new Deal position on board
	 * <b>postcondition</b>:Deal on board
	 * 
	 * @param x
	 * @param y
	 * @param day
	 * @param id
	 */
	public Deal(String icon) {
		super(icon);
	}

	/**
	 * <b>transformer(mutative) </b>:The choice of a player 
	 * <b>postcondition</b>: return true if the player want to buye the card 
	 * otherwise false
	 *  
	 * @return trueORfalse
	 */	
	
	
	
	/**
	 * <b>Observer</b>:Has access to DealCards of a player 
	 * <b>postcondition</b>: return the DealCards of a player
	 *  
	 * @return (String) All the DealCards of one player
	 */
	public String myDealCards() {
		//returns all the deal cards of a player
		return null;
	}

	
	public void performAction(Controller c) {
		System.out.println("eimai deal");
		DealCards a = c.getDealCards().remove(0);
		GraphicUI g = new GraphicUI(c);
		g.setVisible(true);
		System.out.println(a.getIcon());
		c.dealFunc(a);

	}
	
	
}
