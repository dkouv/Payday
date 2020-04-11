package model;

import controller.Controller;
import view.RadioUI;

public class RadioContest extends Position<Integer> {
	
	/**
	 * <b>constructor</b>:Constructs a new RadioContest position on board
	 * <b>postcondition</b>:RadioContest on board
	 * 
	 * @param x
	 * @param y
	 * @param day
	 * @param id
	 */
	public RadioContest(String icon) {
		super(icon);
	}

	
	/**
	 * <b>Transformer(mutative) </b>:The players with the bigger number on a roll die
	 * wins the money
	 * <b>postcondition</b>: return a number of money 
	 *  
	 * @return int 
	 */
	public void performAction(Controller c) {
		System.out.println("DROMOS FM 16.3");
		
	//	RadioUI r = new RadioUI(c);

	}
}
