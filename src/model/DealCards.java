package model;
public class DealCards implements Card {
   private String icon;
   private String message;
   private int BuyValue;
   private int SellValue;
   private String type;
   private String choice1,choice2; //its a standard message initialized from .csv file
   
   /**Constructor.
    * 
    * <b>Postcondition</b>Creates a new  MailCard with 'cost' cost, 'type' type, 'message' message, 'icon' icon and 'command' command.
    *@param icon
    * @param message
    * @param buyValue
    * @param sellValue
    * @param type
    * @param choice1
    * @param  choice2
    * 
    */
	 public DealCards(String icon, String message, int buyValue, int sellValue, String type, String choice1, String choice2) {
		super();
		this.icon = icon;
		this.message = message;
		this.BuyValue = buyValue;
		this.SellValue = sellValue;
		this.type = type;
		this.choice1 = choice1;
		this.choice2 = choice2;
	 }
	 
	 /**
	  * <b>Accessor:</b> returns the card's BuyValue
	  * <b>Postcondition:</b> card's BuyValue has been returned
	  * @return int BuyValue
	  */
	 public int getBuyValue(){
		return this.BuyValue;
	};
	 

	/**
	  * <b>Transformer:</b> sets the card's BuyValue
	  * <b>Postcondition:</b> card's BuyValue has been set
	  * @param int BuyValue
	  */
	 public void setBuyValue(int value){
		 this.BuyValue = value;
	 };
	
	 /**
	  * <b>Accessor:</b> returns the card's SellValue
	  * <b>Postcondition:</b> card's SellValue has been returned
	  * @return int SellValue
	  */
	 public int getSellValue(){
		return this.SellValue;
	};
	 
	 /**
	  * <b>Transformer:</b> sets the card's SellValue
	  * <b>Postcondition:</b> card's SellValue has been set
	  * @param int value
	  */
	 public void setSellValue(int value){
		 this.SellValue = value;
	 };
	   
	 /**
	  * <b>Accessor:</b> sets the card's choice1
	  * <b>Postcondition:</b> card's choice1 has been set
	  * @return String choice1
	  */
	 public String getChoice1() {
		return choice1;
	}
	 
	 /**
	  * <b>Transformer:</b> sets the card's choice1
	  * <b>Postcondition:</b> card's choice1 has been set
	  * @param String choice1
	  */
	public void setChoice1(String choice1) {
		this.choice1 = choice1;
	}
	
	 /**
	  * <b>Accessor:</b> sets the card's choice2
	  * <b>Postcondition:</b> card's choice2 has been set
	  * @return String choice2
	  */
	public String getChoice2() {
		return choice2;
	}
	
	 /**
	  * <b>Transformer:</b> sets the card's choice2
	  * <b>Postcondition:</b> card's choice2 has been set
	  * @param String choice2
	  */
	public void setChoice2(String choice2) {
		this.choice2 = choice2;
	}

	/**
	  * Returns the string representation of a card
	  * <p><b>Postcondition:</b> The string representation of a card is returned</p>
	  * @return The string representation of a card 
	  */
	 @Override
	 public String toString(){
		return null;}
	
	@Override
	public String getType() {
		return this.type;
	}
	
	@Override
	public void setType(String t) {
		this.type = t;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
	
	@Override
	public void setMessage(String m) {
		this.message = m;
	}
	
	@Override
	public String getIcon() {
		return this.icon;
	}
	
	@Override
	public void setIcon(String image) {
		this.icon = image;
	};
	 	
			
}