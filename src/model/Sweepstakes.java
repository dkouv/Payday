package model;

public class Sweepstakes extends Position<Integer>{
	
	/**
	 * <b>constructor</b>:Constructs a new Sweepstake position on board
	 * <b>postcondition</b>:Sweepstake on board
	 * 
	 * @param x
	 * @param y
	 * @param day
	 * @param id
	 */
	public Sweepstakes(String icon) {
		super(icon);
	}
	
	/**
	 * <b>Transformer(mutative) </b>:The money that the player wins 
	 * <b>postcondition</b>: return a number of money 
	 *  
	 * @return int 
	 */	
	public void performAction(Player p) {
		System.out.println("MPRIZOOLEESS");
		// na pernei ena pexti kai na ton bazei na ksanariksei to zari
		//na epistrefei 1000 X (arithmos zariou)
		int poso =  p.RollDice() * 1000;
		p.addMoney(poso);
		System.out.println("o paiktis kerdise to poso twn" + poso + "eurw ...KaloFagota trele mou!");
 
	}

}
