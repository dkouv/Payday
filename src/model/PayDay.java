package model;

import controller.Controller;
import model.Card;

public class PayDay extends Position<Void> {
	
	/**
	 * <b>constructor</b>:Constructs a new PayDay position on board
	 * <b>postcondition</b>:PayDay on board
	 * 
	 * @param x
	 * @param y
	 * @param day
	 * @param id
	 */
	public PayDay(String icon) {
		super(icon);
	}
	
	/**
	 * <b>transformer</b>:Pay the player 
	 * <b>postcondition</b>: return 2500 to the player
	 * 
	 * @return int 
	 */
	public int Pay() {
		return 2500;
	}
	
	/**
	 * <b>transformer</b>:The player must pay his bill's
	 * <b>postcondition</b>: return the money that must pay
	 * 
	 * @return int 
	 */
	public int Bills() {
		return -1;
	}
	
	/**
	 * <b>transformer</b>:The player must pay his taxes's
	 * <b>postcondition</b>: return the money that must pay
	 * 
	 * @return int 
	 */
	public int Taxes() {
		return -1;
	}
	
	/**
	 * <b>transformer</b>:The player must pay his loan
	 * <b>postcondition</b>: return the money that must pay
	 * 
	 * @return int 
	 */
	public int Loan() {
		return -1;
	}
	
	/**
	 * <b>transformer</b>:The player must return on the declineStack all of his DealCards 
	 * <b>postcondition</b>: return the Cards
	 * 
	 * @return cards (type:DealCards) 
	 */
	public Card returnCards(){
		return null;
	}
	
	/**
	 * <b>transformer</b>:The dice must go to start position
	 * <b>postcondition</b>: dice goes to start
	 * 
	 * @return (position)
	 */
	public void dice() {
		
	}

	@Override
	public void performAction(Controller c) {
		// TODO 2) 5) 6)
		System.out.println("mera PLIRWMIIIISSS :))))) XDDD");
		c.getP().addMoney(2500);
		int i = c.getP().getLoan();
		int taxes = (10*i)/100;
		
		if(c.getP().getCurrentMoney() < taxes ) {
			c.getP().setLoan(taxes*10);
			c.getP().addMoney(taxes*10);
			c.getP().giveMoney(taxes);

		}else {
			c.getP().giveMoney(taxes);
			//TODO na mporei na plirwsei kai meros tou daneiou kai to poso pou tha plirwsei prepei na einai pollaplasio tou 1000
		}
		

	}
}
