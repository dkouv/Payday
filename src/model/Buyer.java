package model;



public class Buyer extends Position<Integer> {
	
	/**
	 * <b>constructor</b>:Buyer a new Buyer position on board
	 * <b>postcondition</b>:Buyer on board
	 * 
	 * @param x
	 * @param y
	 * @param day
	 * @param id
	 */
	public Buyer(String icon) {
		super(icon);
	}
	
	/**
	 * <b>Transformer(mutative) </b>:The players shell a DealCard
	 * and add the money on his wallet
	 * <b>postcondition</b>: return a number of money 
	 *  
	 * @return int 
	 */
	public Integer performAction() {
		System.out.println("eimai agorastis");

		return -1;
	}
}
