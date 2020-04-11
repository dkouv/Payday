package model;

public class YardSale extends Position<Integer> {

	/**
	 * <b>constructor</b>Constructs a new YardSale position on board
	 * <b>postcondition</b>:YardSale on board
	 * 
	 * @param x
	 * @param y
	 * @param day
	 * @param id
	 */
	public YardSale(String icon) {
		super(icon);
	}
	
	/**
	 * <b>Transformer(mutative) </b>:The players rolls the die and then pay the bank
	 * then take a DealCard without to pay anything else
	 * <b>postcondition</b>: return a number of money 
	 *  
	 * @return int 
	 */
	public Integer performAction(){
		System.out.println("YARD SALEEE");

		return -1;
	}
}
