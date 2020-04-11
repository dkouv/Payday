package model;

import controller.Controller;

public class FamilyCasinoNight extends Position<Integer> {

	/**
	 * <b>constructor</b>:Buyer a new RadioContest position on board
	 * <b>postcondition</b>:Buyer on board
	 * 
	 * @param x
	 * @param y
	 * @param day
	 * @param id
	 */
	public FamilyCasinoNight(String icon) {
		super(icon);
	}

	
	/**
	 * <b>Transformer(mutative) </b>:The players wins or lose money
	 * and that depends on his roll die
	 * <b>postcondition</b>: return a number of money 
	 *  
	 * @return int 
	 */
	public void performAction(Controller c) {
		
		System.out.println("mera oikogeniakou kazinou <3");
		int i = c.getTrexonZaria();
		
		if(i%2 == 0) {
			c.getP().addMoney(500);
		}
		else if(i%2 !=0 && c.getP().getCurrentMoney() < 500) { //TODO swsta to danio
			c.getP().setLoan(1000);
			c.getP().addMoney(1000);
			c.getP().giveMoney(500);
			c.JackPot(500);
		} else {
			System.out.println("i%2 = " + i%2 + " o paixtis " + c.getP().getName() + " eftase me tin parapanw zaria!");
			System.out.println("ta lefta tou " + c.getP().getName() + " einai " + c.getP().getCurrentMoney() );
			c.getP().giveMoney(500);
			c.JackPot(500);
		}
			
		
		
	}
}
