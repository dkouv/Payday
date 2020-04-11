package controller;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;

import model.*;
import view.GraphicUI;
import view.RadioUI;


	/**
	 * Controller is the master of the game and controls all 
	 * of the operations executed
	 * @version 1.0
	 * @author csd3319
	 */
public class Controller {

	private boolean GameStarted;
	private ArrayList<DealCards> DealCards = new ArrayList<>();
	private ArrayList<MailCards> MailCards = new ArrayList<>();
	private ArrayList<MailCards> PlayedMailCards = new ArrayList<>();
	private ArrayList<DealCards> PlayedDealCards = new ArrayList<>();
	private int JackPot = 0;
	private int trexonZaria = 0;
	GraphicUI f;
	RadioUI r;


	public ClassLoader cldr;
	int mailCardCount = 0, dealCardCount = 0;
	String[][] mailCards = new String[48][6]; //!!!!!!!!!!!!???????????????
	String[][] dealCards = new String[20][8];
	private Player p1,p2, p;
	private int CurrentMonths=0,months,loan; // 1-3
	private ArrayList<Position> Tablo = new ArrayList<>();
	private boolean winner=false;
	public MailCards kartaMail;
	public DealCards kartaDeal;
	

	/**
	 * <b>constructor</b>:Constructs a new controller
	 * <b>postcondition</b>:make a controller class
	 * 
	 * @param gameStarted
	 * @param first
	 * @param ArrayList<Cards> dealCards
	 * @param ArrayList<Cards> mailCards
	 * @param Player p1
	 * @param Player p2
	 * @param int months
	 */
	public Controller(String name1, String name2, String pioni1, String pioni2, int months) {
		
		
		cldr = this.getClass().getClassLoader();
		GameStarted = true;
		this.months = months;
	//	p1 = new Player("Player 2", Player.color.YELLOW);
	//	p2 = new Player("Player 1", Player.color.BLUE);
		
		if (pioni1.equals("BLUE")) {
			p1 = new Player(name1, Player.color.BLUE);
			p2 = new Player(name2, Player.color.YELLOW);

		}else if(pioni1.equals("YELLOW")) {
			p1 = new Player(name1, Player.color.YELLOW);
			p2 = new Player(name2, Player.color.BLUE);

//		}else if(pioni1.equals("YELLOW")) {
//			p2 = new Player(name1, Player.color.YELLOW);
//		}else if(pioni2.equals("BLUE")) {
//			p2 = new Player(name1, Player.color.BLUE);
		}else {
			System.out.println("xalia mabra");
		}
		
		// dhmioyrgia deck MailCards
		// dhmioyrgia deck DealCards
		// Dhmourgia tablo
		
		
		Position pos;
		
   			first(); // poios tha paiksei prwtos
			System.out.println("o paixtis "+ p.getName() + " paizei prwtos! ");
			
		readFile("resources/mailCards.csv", "Mail");
  		readFile("resources/dealCards.csv", "Deal");
		
  		//initiallize the mailCards arrayList.
		for (int j = 0; j<48; j++){
		//	int cost, String type, String message, String icon, String command
			MailCards m = new MailCards(Integer.parseInt(mailCards[j][4]), mailCards[j][1], mailCards[j][2], mailCards[j][5], mailCards[j][3]);
			MailCards.add(m);
		}
		
  		//initiallize the dealCards arrayList.
		for (int i = 0; i<20; i++){
		//	String icon, String message, int buyValue, int sellValue, String type, String choice1, String choice2
			DealCards d = new DealCards(dealCards[i][5], dealCards[i][2], Integer.parseInt(dealCards[i][3]), Integer.parseInt(dealCards[i][4]), dealCards[i][1], dealCards[i][6], dealCards[i][7]);
			DealCards.add(d);
			}
		
		shuffleAll();
		
		//ftiaxnw ta instances ton kartwn tou tablo		
		
		int i=0;
		for (i=0; i<4; i++)
			Tablo.add(new Mail1("mc1.png"));
		for (i=0; i<4; i++)
			Tablo.add(new Mail2("mc2.png"));
		for (i=0; i<5; i++)
			Tablo.add(new Deal("deal.png"));
		for (i=0; i<2; i++)
			Tablo.add(new Sweepstakes("sweep.png"));
		for (i=0; i<3; i++)
			Tablo.add(new Lottery("lottery.png"));
		for (i=0; i<2; i++)
			Tablo.add(new RadioContest("radio.png"));
		for (i=0; i<6; i++)
			Tablo.add(new Buyer("buyer.png"));
			
		for (i=0; i<2; i++)
			Tablo.add(new FamilyCasinoNight("casino.png"));
		for (i=0; i<2; i++)
			Tablo.add(new YardSale("yard.png"));
		Collections.shuffle(Tablo);
		Tablo.add(new PayDay("pay.png"));
		Tablo.add(new Start("start.png"));
		
		//while(not winner..)
		
		
		 f = new GraphicUI(this.Tablo, this);

		
		
//		System.out.println("---> " + Tablo.get(0).getClass().getSimpleName());
		
		
	}

	
	public boolean isWinner() {
		return this.winner;
	}
	
	/**
	 * <b>Transformer</b> :  Sets the "trexonZaria" variable as the parameter of the func.
	 * <b>postcondition</b> : (int) a number.
	 * 
	 */
	public void setTrexonZaria(int i) {
		trexonZaria = i;
	}
	
	/**
	 * <b>Observer</b> :  Get the value od the dice on the current round.
	 * <b>postcondition</b> : (int) a number between 1-6.
	 * 
	 */
	public int getTrexonZaria() {
		return this.trexonZaria;
	}
	public void JackPot(int i) {
		this.JackPot += i;
	}
	
	public int takeJackPot() {
		return this.JackPot;
	}
	public void mailFunc(MailCards m) {
		this.kartaMail = m;
	}

	public void dealFunc(DealCards d) {
		this.kartaDeal = d;
	}

	public void readFile(String path, String type) {
		BufferedReader br = null;
		String sCurrentLine;
		try {
			String fullPath = cldr.getResource(path).getPath();
			br = new BufferedReader(new FileReader(fullPath));
		} catch (FileNotFoundException ex) {
			Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
		}
		int count = 0;
		int splitCount = 0;
		HashMap<Integer, String> domainsMap = new HashMap<>();
		try {
			br.readLine();
			while ((sCurrentLine = br.readLine()) != null) {
				if (type.equals("Mail")) {
					mailCards[count++] = sCurrentLine.split(",");
				} else {
					dealCards[count++] = sCurrentLine.split(",");
				}
			}
			br.close();
		} catch (IOException ex) {
			Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	
	/**
	 * <b>precondition</b>: None
	 * <b>postcondition</b> initialize the board with the cards
	 */
	public void initializeBoard() {
		
	}
	
	/**
	 * <b>precondition</b>: None
	 * <b>postcondition</b>: shuffle the cards on the arraylist
	 */
	public void shuffleAll() {
			Collections.shuffle(this.DealCards);
			Collections.shuffle(this.MailCards);
	}
	
	public void shuffleD() {
		Collections.shuffle(this.DealCards);
	}
	
	public void shuffleM() {
		Collections.shuffle(this.MailCards);
	}
	
	
	/**
	 * <b>Observer</b> : sets the variable first on true.
	 * @return true or false
	 */
	public void first() {
		Random r = new Random();
		int Result = r.nextInt(2) +1;
		
		if(Result == 1)
			this.p=p1;
		else
			this.p=p2;
		
	}
	
	/**
	 * <b>Accessor</b> :  Find the next "DealBuyer" position on board.
	 * <b>postcondition</b> : (int) specific position on board.
	 */
	public int findNextDealBuyPosition() {
		int thesi = getP().getThesis();
		
		int i=0;
		for( i = thesi; i<31; i++) {
			if(Tablo.get(i) instanceof Deal || Tablo.get(i) instanceof Buyer)
				break;
			
		}
		if (i == 31 ) return 0;
		else return i+1;
	}
	
	/**
	 * <b>Accessor</b> :  Sets the "played" variable->true and sets the
	 * the next player as current player.
	 * <b>postcondition</b> : return a player.
	 * 
	 */
	public Player Allos() {
		if (this.p == p1) 
			return  p2;
		else
			return p1;
		
		
	}
	
	/**
	 * <b>Accessor</b> :  Sets the player that plays next.
	 * <b>postcondition</b> : return a player.
	 * 
	 */
	public void nextPlayer() {
		if (this.p == p1) {
			p.setPlayed(false);
			this.p = p2;
		}	
		else{
			p.setPlayed(false);
			this.p = p1;
		}
		
		f.updateInfo();
	}
	/**
	 * <b>Accessor</b> : sets the variable GameStarted on true.
	 * 
	 */
	public void setGameStarted(boolean a) {
		this.GameStarted = a;
	}
	public boolean getGameStarted() {
		return this.GameStarted;
	}
	
	/**
	 * <b>Accessor</b> : sets how many months the game will be played
	 * 
	 */
	public int setMonths(int i) {
		return this.months = i;
	}
	
	public int getMonths() {
		return this.months;
	}
	
	/**
	 * <b>Accessor</b> : sets the variable winnner on true.
	 * 
	 */
	public void Winner(){
		this.winner = true;
	}
	

	/**
	 * <b>precondition</b> : gets the loan and add it on the players account.
	 * <b>postcondition</b> : return a number that represents the loan.
	 * 
	 */
	public int getLoan() {
		return this.loan;
	}
	


	public ArrayList<MailCards> getMailCards() {
		
		return this.MailCards;
	}
	
	public ArrayList<DealCards> getDealCards() {
		
		return this.DealCards;
	}
	

	public void addPlayedMailCards(MailCards c) {
		this.PlayedMailCards.add(c);
	}
	 
	public void addPlayedDealCards(DealCards d) {
		this.PlayedDealCards.add(d);
	}
	
	
	/**
	 * <b>precondition</b> : Accessor, None.
	 * <b>postcondition</b> : (int) position on board.
	 * 
	 */
	 public  Position Move(int i) {
		 if(i == -1)
			 return Tablo.get(32);
		 else if(i == 0)
			 return Tablo.get(0);
		 else
			 return Tablo.get(i-1);
		
	}
	 
	 
		public void performAction(String s) {
			
			
			
		}
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
			
		//   ArrayList<Image> lol = getTableImages();
	
	   	/*	Controller c = new Controller(3);
	   		int i=0;
			Position pos;
			
	   		c.first(); // poios tha paiksei prwtos
   			System.out.println("o paixtis "+ c.getP().getName() + " paizei prwtos! ");
		   	*/
		
		//   Controller c = new Controller("dimitris", "kostas", "BLUE", "YELLOW", 3);

		   
	   }//main	
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	/**
	 * <b>precondition</b> : Observer  gets the current number of months. 
	 * <b>postcondition</b> : (int) number.
	 * 
	 */
	public int getCurrentMonths() {
		return CurrentMonths;
	}

	/**
	 * <b>precondition</b> : Transformer sets the CurrentMonths variable with a specific value.
	 * <b>postcondition</b> : None.
	 * 
	 */
	public void setCurrentMonths(int currentMonths) {
		CurrentMonths = currentMonths;
	}

	/**
	 * <b>precondition</b> : Observer gets the player that plays at this moment.
	 * The variable played=false.
	 * <b>postcondition</b> : return a player.
	 * 
	 */
	public Player getP() {
		return p;
	}

	/**
	 * <b>precondition</b> : Observer gets the first player who plays (player1).
	 * <b>postcondition</b> : return a player1.
	 * 
	 */
	public Player getP1() {
		return p1;
	}
	
	/**
	 * <b>precondition</b> : Observer gets the second player who plays (player2).
	 * <b>postcondition</b> : return player2 .
	 * 
	 */
	public Player getP2() {
		return p2;
	}

	/**
	 * <b>precondition</b> : Transformer sets the current player with the player that takes
	 * as a parameter
	 * <b>postcondition</b> : nothing
	 * 
	 */
	public void setP(Player p) {
		this.p = p;
	}

}
