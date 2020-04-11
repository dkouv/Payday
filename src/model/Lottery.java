package model;

import controller.Controller;
import view.GraphicUI;

public class Lottery extends Position<Integer> {
	
	/**
	 * <b>constructor</b>:Constructs a new Lottery position on board
	 * <b>postcondition</b>:Lottery on board
	 * 
	 * @param x
	 * @param y
	 * @param day
	 * @param id
	 */
	public Lottery(String icon) {
		super(icon);
	}
	
	/**
	 * <b>Transformer(mutative) </b>:The players bet a number
	 * and the winner takes the money
	 * <b>postcondition</b>: return a number of money 
	 *  
	 * @return int 
	 */
	public void performAction(Controller c) {
		System.out.println("LOTTARIAAAA");

		
		GraphicUI g = new GraphicUI(1);
		
		
	}
}
