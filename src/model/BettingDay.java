package model;



public class BettingDay extends Position<Boolean> {
	
	/**
	 * <b>constructor</b>:Constructs a new BettingDay position on board
	 * <b>postcondition</b>:BettingDay on board
	 * 
	 * @param x
	 * @param y
	 * @param day
	 * @param id
	 */
	public BettingDay(String icon) {
		super(icon);
	}

	/**
	 * <b>Attributes</b> of BettingDay class
	 */
	boolean win,lose,tie;

	
	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}

	public boolean isLose() {
		return lose;
	}

	public void setLose(boolean lose) {
		this.lose = lose;
	}

	public boolean isTie() {
		return tie;
	}

	public void setTie(boolean tie) {
		this.tie = tie;
	}

	
	
	/**
	 * <b>precondition</b>: If the player is on a position on board and the day is sunday
	 * performAction() and bet some money.
	 * <b>postcondition</b>: (Boolean) true if he win or false otherwise.
 	 */
//	public Boolean performAction() {
//		// TODO Auto-generated method stub
//		System.out.println("mera stoiximatos");
//		return null;
//	}
}
