package model;

import controller.Controller;

public class MailCards implements Card {
	private int cost;
	private String type;
	private String message;
	private String icon;
	private String command;
	
	/**Constructor.
     * 
     * <b>Postcondition</b>Creates a new  MailCard with 'cost' cost, 'type' type, 'message' message, 'icon' icon and 'command' command.
     *@param cost
     * @param type
     * @param message
     * @param icon
     * @param command
     */
	

	public MailCards(int cost, String type, String message, String icon, String command) {
		this.cost = cost;
		this.type = type;
		this.message = message;
		this.icon = icon;
		this.command = command;
	}

	
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
	}
	
	/**
     * <b>Accessor:</b> returns the card's cost
     * <b>Postcondition:</b> card's cost has been returned
     * @return int cost
     */
	public int getCost() {
		return cost;
	}
	
	/**
     * <b>Transformer:</b> sets the card's cost
     * <b>Postcondition:</b> card's cost has been set
     * @param int cost
     */
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	@Override
	public String toString() {
		return "MailCards [cost=" + cost + ", type=" + type + ", message=" + message + ", icon=" + icon + ", command="
				+ command + "]";
	}

	/**
     * <b>Accessor:</b> returns the card's command
     * <b>Postcondition:</b> card's command has been returned
     * @return String command
     */
	public String getCommand() {
		return this.command;
	}
	
	/**
     * <b>Transformer:</b> sets the card's command
     * <b>Postcondition:</b> card's command has been set
     * @param String command
     */
	public void setCommand(String command) {
		this.command = command;
	}
	
	public void performAction(Controller c) {
		
		if(getType().equals("Advertisement") ) {
			c.addPlayedMailCards(this);
			
		}else if (getType().equals("Bill")) {
			c.getP().addBill(this.cost);
			c.getP().addBillCards(this);
		
		}else if(getType().equals("Charity")) {
			//elegxos gia na aprei daneio

			if(c.getP().getCurrentMoney() < this.cost) {
				System.out.println("o paixtis "+ c.getP().getName() + "pire daneio gia na plirwsei thn filantrwpia :) ");
				c.getP().addMoney(c.getP().getCurrentMoney()+1000); //thelei diorthwma prepei na pernei lefta pollaplasia tou 1000
			}else {
				c.getP().giveMoney(this.cost);
			 }
			
		c.JackPot(this.cost);
		c.addPlayedMailCards(this);

		
		}
		else if(getType().equals("PayTheNeighbot")) {
			//elegxos gia daneio
			if(c.getP().getCurrentMoney() < this.cost) {
				System.out.println("o paixtis "+ c.getP().getName() + "pire daneio gia na plirwsei thn filantrwpia :) ");
				c.getP().addMoney(c.getP().getCurrentMoney()+1000); //thelei diorthwma prepei na pernei lefta pollaplasia tou 1000
			}else {
				c.getP().giveMoney(this.cost);
			}	
			c.Allos().addMoney(this.cost);
			c.addPlayedMailCards(this);
			
		}else if (getType().equals("MadMoney")) {
			//TODO elegxos gia ton an exei na plirwsei ton geitwna
			c.Allos().giveMoney(this.cost);
			c.getP().addMoney(this.cost);
			c.addPlayedMailCards(this);
		}
		else if (getType().equals("MoveToDealBuyer")){
			int i = c.findNextDealBuyPosition();
			c.getP().setThesis(i);
			c.addPlayedMailCards(this);

		}
		
	}
	

}
