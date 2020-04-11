package model;
import java.awt.Image;
import java.util.*;

import javax.swing.ImageIcon;
	
	/**
	 * This enum contains the colors of the Dice
	 * @version 1.0
	 * @author csd3319
	 */
	


   /**
	* Player class describes the characteristics of a player
	* and provides modification methods. 
	* @version 1.0
	* @author csd3319
	*/
	public class Player {
		public enum color {BLUE, YELLOW}
		private String name;
		private int currentMoney;
		private int bill = 0;
		private int loan = 0;
		private ArrayList<DealCards> DealCards = new ArrayList<>();
		private ArrayList<MailCards> BillCards = new ArrayList<>();
		private boolean played = false;
		private color c;
		private int thesis = 0;
		private Die zari = new Die();
		private Position p;
		
		
		public void addDealCard(DealCards d) {
			DealCards.add(d);
		}
		
		public ArrayList<MailCards> getBillCards() {
			return BillCards;
		}
		public void addBillCards(MailCards c) {
			BillCards.add(c);
		}
		
		public void giveMoney(int i) {
			currentMoney -= i;
		}
		public int getThesis() {
			return thesis;
		}
		public void setThesis(int thesis) {
			this.thesis = thesis;
		}
		public Position getPos() {
			return p;
		}


		public void setPos(Position p) {
			this.p = p;
		}


		public int RollDice() {
			this.zari.roll();
			return this.zari.getZaria();
		}
		
		
		public void MovePlayer(int i) {
			 this.thesis +=i;
		}

		
		
		
    public int getCurrentMoney() {
			return currentMoney;
		}




		public void setCurrentMoney(int currentMoney) {
			this.currentMoney = currentMoney;
		}


		public void addMoney(int i) {
			this.currentMoney += i;
		}


		public int getBill() {
			return bill;
		}




		public void setBill(int bill) {
			this.bill = bill;
		}


		public void addBill(int bill) {
			this.bill += bill;
		}

		public int getLoan() {
			return loan;
		}




		public void setLoan(int loan) {
			this.loan = loan;
		}




		public boolean isPlayed() {
			return played;
		}




		public void setPlayed(boolean played) {
			this.played = played;
		}




		public void setMovePlayer(int t) {
			thesis = t;
		}




	/**
	 * <b>constructor</b>: Constructs a new Player with the given
	 * parameter name and color.<br />
	 * <b>postcondition</b>: Creates and initializes a player with the given
	 * name and color.Also initializes some variables (for example initialize variables 
	 * with the current money on initial state)
	 * @param name is the name of the player.
	 * @param color is the color of the players dice
	 */
	 public Player(String name, color c) { 
		 this.currentMoney = 2500;
	     this.name = name;
	     this.c = c;
	     this.played = false;
	 }
		  
   /**
	* <b>accessor(selector)</b>:Returns the color that represent the player <br />
	* 
	* <p><b>Postcondition:</b> returns the color that represent the player </p>
	*
	* @return(color c) color that represent the player
	*/
	public color getC() {
		return c;
	}

	/**
	 * <b>transformer(mutative)</b>: sets the color that represent the player color c <br />
	 * <p><b>Postcondition:</b> the color that represent the player color c</p>
	 *
	 * @param (color c) the color that represent the player
	 * 
	 */ 
	public void setC(color c) {
		this.c = c;
	}

    
	/**
	* <b>accessor(selector)</b>:Returns the name of the player <br />
	* 
	* <p><b>Postcondition:</b> returns the name of the player </p>
	*
	* @return the name of the player
	*/
    
    public String getName() {
        return name;
   }

   
   /**
    * <b>transformer(mutative)</b>: sets the name of the player to (String)name <br />
    * <p><b>Postcondition:</b> the name of this player is changed to (String)name</p>
    *
    * @param (String)name the new name of the player
    * 
    */ 
    public void setName(String name) {
        this.name = name;
    }
   
	    
	 /**
	  * <b>transformer(mutative)</b>: sets the ArrayList of the DealCards with the give ArrayList <br />
	  * <p><b>Postcondition:</b>  initialize the ArrayList with the given one </p>
	  *
	  * @param a ArrayList wich contains the DealCards of the player
	  * 
	  */ 
	 
	 /**
	  * <b>Accessor:</b> returns all the DealCards
	  * <b>Postcondition:</b> all the DealCards has been returned
	  * @return (ArrayList) all the DealCards
	  */
	 public ArrayList<DealCards> getDealCards() {
	      return this.DealCards;
	 }
	
	  /**
	   * <b>transformer(mutative)</b>: sets the variable hasplayed to true
	   * <p><b>Postcondition:</b>  sets the variable hasplayed to true</p>
	   */ 
	    
      public void Played() {
    	  this.played = true;
      }
	     
	 
	/**
	 * <b>Observer</b>:Returns the name of player and color dice
	 * <p><b>Postcondition:</b> A string with name and color dice
	 * 
	 *  @return (String) A string with name and color dice
	 */
	 public String toString() {
		 return "Name: "+ getName() + "Dice color: " + getC() + "\n";
		 
	 }
	    
}
