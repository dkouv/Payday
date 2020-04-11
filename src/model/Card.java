package model;
	
	/**
	 * Contains the methods signatures needed for 
	 * creating a PAYDAY simple or special card
	 * @version 1.0
	 * @author csd3319
	 */
	public abstract interface Card {
	        
       
    /**
     * <b>Accessor:</b> returns the card's Type
     * <b>Postcondition:</b> card's Type has been returned
     * @return String Type
     */
    public String getType();
    
    /**
     * <b>Transformer:</b> sets the card's Type
     * <b>Postcondition:</b> card's Type has been set
     * @param String t
     */
    public void setType(String t);

    /**
     * <b>Accessor:</b> returns the card's Message
     * <b>Postcondition:</b> card's Message has been returned
     * @return String Message
     */
    public String getMessage();
    
    /**
     * <b>Transformer:</b> sets the card's Message
     * <b>Postcondition:</b> card's Message has been set
     * @param String m
     */
    public void setMessage(String m);
        
    /**
     * <b>Accessor:</b>
     * <p><b>Postcondition:</b> The ImageIcon representation of a card is returned</p>
     * @return String ImageIcon  
     */
    
    public String getIcon();
    
    /**
     * <b>Transformer:</b> sets the card's ImageIcon(the path with  the .jpg)
     * <b>Postcondition:</b> card's ImageIcon has been set
     * @param String image
     */
    public void setIcon(String image);
        
    /**
     * Returns the string representation of a card
     * <p><b>Postcondition:</b> The string representation of a card is returned</p>
     * @return The string representation of a card 
     */
    @Override
    public String toString();
    	
		
	}