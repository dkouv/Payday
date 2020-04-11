package view;

import model.*;
import controller.Controller;
import model.*;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GraphicUI extends JFrame implements ActionListener {

	
	JLabel zari2 = new JLabel();

	JLabel zari1 = new JLabel();

	JLabel pawn1;
	JLabel pawn2;
	
	ClassLoader cldr = this.getClass().getClassLoader();

	JLabel zari = new JLabel();
	NumberFormat nums = NumberFormat.getNumberInstance();
	JFormattedTextField text1field = new JFormattedTextField(nums);
	JFormattedTextField text2field = new JFormattedTextField(nums);

	int i,j;
	
	Controller ctr = null;
	
	JLabel Player1 = new JLabel("Player 1: ");
	JLabel Player2 = new JLabel("Player 2: ");

	JTextField money2 = new JTextField("Money", 8);
	JTextField laon2 = new JTextField("Loan", 8);
	JTextField bills2 = new JTextField("Bills", 8);
	
	JTextField money = new JTextField("Money", 8);
	JTextField laon= new JTextField("Loan", 8);
	JTextField bills = new JTextField("Bills", 8);
	JButton[] butt = new JButton[31];
	JButton start = new JButton("START");
	

	public GraphicUI(ArrayList<Position> T, Controller c) {
		repaint();
		ctr = c;
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();

		JMenuItem item;

		JFrame f = new JFrame("My First GUI Program");

		// f.setSize(900,700);
		// Image bg = new
		// ImageIcon("src/view/images/bg_green.png").getImage().getScaledInstance(500,
		// 500, java.awt.Image.SCALE_SMOOTH); //dineis to path kai sou
		// epistrefei to image
		// f.add(new JLabel( new ImageIcon(bg)));

		JPanel panel = new JPanel();
		// panel.setBackground();

		f.setResizable(true);

		panel.setLayout(new BorderLayout(100, 100));

		/*******************************************
		 * MENU BAR
		 ******************************************************/

		JMenuBar mBar = new JMenuBar();

		JMenu fMenu = new JMenu("File");
		mBar.add(fMenu);

		JMenuItem n = new JMenuItem("New");
		fMenu.add(n);

		f.setJMenuBar(mBar);
		f.setVisible(true);

		item = new JMenuItem("Open..."); // Open...
		item.addActionListener(this);
		fMenu.add(item);

		item = new JMenuItem("Save"); // Save
		item.addActionListener(this);
		fMenu.add(item);

		item = new JMenuItem("Save As..."); // Save As...
		item.addActionListener(this);
		fMenu.add(item);

		fMenu.addSeparator(); // add a horizontal separator line

		item = new JMenuItem("Quit"); // Quit
		item.addActionListener(this);
		fMenu.add(item);

		/********************************************
		 * MAIN BOARD
		 ******************************************************/

		p2.setLayout(new GridLayout(5, 7, 0, 0)); // the panel with the
													// buttons/cards

		Image butts = new ImageIcon("src/view/start.png").getImage().getScaledInstance(100, 100,
				java.awt.Image.SCALE_SMOOTH); // dineis to path kai sou
												// epistrefei to image
		ImageIcon ena = new ImageIcon(butts);

		
		start.setHorizontalTextPosition(JButton.CENTER);
		start.setVerticalTextPosition(JButton.TOP);
		start.setIcon(ena);
		start.addActionListener(this);

		p2.add(start);
		

		Image im, im2;
		ImageIcon imi, imi2;

		//pawns 
		pawn1 =new JLabel();
		pawn2 =new JLabel();
		im = new ImageIcon("src/view/images/pawn_blue.png").getImage().getScaledInstance(50, 50,
				java.awt.Image.SCALE_SMOOTH);
		imi = new ImageIcon(im);
		im2 = new ImageIcon("src/view/images/pawn_yellow.png").getImage().getScaledInstance(50, 50,
				java.awt.Image.SCALE_SMOOTH);
		imi2 = new ImageIcon(im2);
	
			if(ctr.getP1().getC() == Player.color.BLUE) {
				pawn1.setIcon(imi);
				pawn2.setIcon(imi2);
			} else {
				pawn2.setIcon(imi);
				pawn1.setIcon(imi2);
				
			}
//				start.add(pawn1);		
		for (int i = 0; i < 31; i++) {

			if (i == 0 || i == 7 || i == 14 || i == 21 || i == 28) {
				butt[i] = new JButton("Monday " + (i + 1));
				butt[i].setHorizontalTextPosition(JButton.CENTER);
				butt[i].setVerticalTextPosition(JButton.TOP);
				butt[i].addActionListener(this);

				im = new ImageIcon("src/view/table/" + T.get(i).getIcon()).getImage().getScaledInstance(100, 100,
						java.awt.Image.SCALE_SMOOTH);
				imi = new ImageIcon(im);
				butt[i].setIcon(imi);

				p2.add(butt[i]);
			} else if (i == 1 || i == 8 || i == 15 || i == 22 || i == 29) {
				butt[i] = new JButton("Tuesday " + (i + 1));
				butt[i].setHorizontalTextPosition(JButton.CENTER);
				butt[i].setVerticalTextPosition(JButton.TOP);
				butt[i].addActionListener(this);

				im = new ImageIcon("src/view/table/" + T.get(i).getIcon()).getImage().getScaledInstance(100, 100,
						java.awt.Image.SCALE_SMOOTH);
				imi = new ImageIcon(im);
				butt[i].setIcon(imi);

				p2.add(butt[i]);

			} else if (i == 2 || i == 9 || i == 16 || i == 23 || i == 30) {
				butt[i] = new JButton("Wednes " + (i + 1));
				butt[i].setHorizontalTextPosition(JButton.CENTER);
				butt[i].setVerticalTextPosition(JButton.TOP);
				butt[i].addActionListener(this);

				im = new ImageIcon("src/view/table/" + T.get(i).getIcon()).getImage().getScaledInstance(100, 100,
						java.awt.Image.SCALE_SMOOTH);
				imi = new ImageIcon(im);
				butt[i].setIcon(imi);

				p2.add(butt[i]);

			} else if (i == 3 || i == 10 || i == 17 || i == 24 || i == 31) {
				butt[i] = new JButton("Thursday " + (i + 1));
				butt[i].setHorizontalTextPosition(JButton.CENTER);
				butt[i].setVerticalTextPosition(JButton.TOP);
				butt[i].addActionListener(this);

				im = new ImageIcon("src/view/table/" + T.get(i).getIcon()).getImage().getScaledInstance(100, 100,
						java.awt.Image.SCALE_SMOOTH);
				imi = new ImageIcon(im);
				butt[i].setIcon(imi);

				p2.add(butt[i]);

			} else if (i == 4 || i == 11 || i == 18 || i == 25) {
				butt[i] = new JButton("Friday " + (i + 1));
				butt[i].setHorizontalTextPosition(JButton.CENTER);
				butt[i].setVerticalTextPosition(JButton.TOP);
				butt[i].addActionListener(this);

				im = new ImageIcon("src/view/table/" + T.get(i).getIcon()).getImage().getScaledInstance(100, 100,
						java.awt.Image.SCALE_SMOOTH);
				imi = new ImageIcon(im);
				butt[i].setIcon(imi);

				p2.add(butt[i]);

			} else if (i == 5 || i == 12 || i == 19 || i == 26) {
				butt[i] = new JButton("Saturday " + (i + 1));
				butt[i].setHorizontalTextPosition(JButton.CENTER);
				butt[i].setVerticalTextPosition(JButton.TOP);
				butt[i].addActionListener(this);

				im = new ImageIcon("src/view/table/" + T.get(i).getIcon()).getImage().getScaledInstance(100, 100,
						java.awt.Image.SCALE_SMOOTH);
				imi = new ImageIcon(im);
				butt[i].setIcon(imi);

				p2.add(butt[i]);
			} else {
				butt[i] = new JButton("Sunday " + (i + 1));
				butt[i].setHorizontalTextPosition(JButton.CENTER);
				butt[i].setVerticalTextPosition(JButton.TOP);
				butt[i].addActionListener(this);

				im = new ImageIcon("src/view/table/" + T.get(i).getIcon()).getImage().getScaledInstance(100, 100,
						java.awt.Image.SCALE_SMOOTH);
				imi = new ImageIcon(im);
				butt[i].setIcon(imi);

				p2.add(butt[i]);
			}
			
			
		}
		
		

		/***********************
		 * PLAYER 1 INFO BOX
		 *******************************************/
	//	JLabel Player2 = new JLabel("Player 2: ");
		//
		// Image d1 = new
		// ImageIcon("src/view/images/dice-1.jpg").getImage().getScaledInstance(50,
		// 50, java.awt.Image.SCALE_SMOOTH); //dineis to path kai sou epistrefei
		// to image
		// ImageIcon dena = new ImageIcon(d1);
		// JLabel zari1 = new JLabel();

		JLabel Money = new JLabel("Money: ", JLabel.LEFT);
		JLabel Loan = new JLabel("Loan: ", JLabel.LEFT);
		JLabel Bills = new JLabel("Bills: ", JLabel.LEFT);
		p1.setLayout(new GridLayout(0, 1));
		
		JButton mdc = new JButton("My Deal Cards");
		mdc.addActionListener(this);
		JButton rd = new JButton("Roll Dice2");
		rd.addActionListener(this);
		JButton gl = new JButton("Get Loan2");
		gl.addActionListener(this);
		JButton et = new JButton("End Turn2");
		et.addActionListener(this);

		p1.add(Player1); //p2->p1
		p1.add(Money);
		p1.add(money);
		p1.add(Loan);
		p1.add(laon);
		p1.add(Bills);
		p1.add(bills);
		p1.add(rd);
		p1.add(mdc);
		p1.add(gl);
		p1.add(et);
		p1.add(zari2);

		/***********************
		 * PLAYER 2 INFO BOX
		 *******************************************/

		JButton mdc2 = new JButton("My Deal Cards");
		mdc2.addActionListener(this);
		JButton rd2 = new JButton("Roll Dice1");
		rd2.addActionListener(this);
		JButton gl2 = new JButton("Get Loan");
		gl2.addActionListener(this);
		JButton et2 = new JButton("End Turn");
		et2.addActionListener(this);

//		JLabel Player1 = new JLabel("Player 1: ");
		// Image d2 = new
		// ImageIcon("src/view/images/dice-2.jpg").getImage().getScaledInstance(50,
		// 50, java.awt.Image.SCALE_SMOOTH); //dineis to path kai sou epistrefei
		// to image
		// ImageIcon ddyo = new ImageIcon(d2);
		// JLabel zari2 = new JLabel();
		// zari2.setIcon(ddyo);

		JLabel Money2 = new JLabel("Money: ", JLabel.LEFT);
		JLabel Loan2 = new JLabel("Loan: ", JLabel.LEFT);
		JLabel Bills2 = new JLabel("Bills: ", JLabel.LEFT);
		p3.setLayout(new GridLayout(0, 1));
		

		p3.add(Player2); // p1 -> p2
		p3.add(Money2);
		p3.add(money2);
		p3.add(Loan2);
		p3.add(laon2);
		p3.add(Bills2);
		p3.add(bills2);
		p3.add(rd2);
		p3.add(mdc2);
		p3.add(gl2);
		p3.add(et2);
		p3.add(zari1);

		panel.add(p3, BorderLayout.LINE_START); // sto kentro kai sta deksia
		panel.add(p1, BorderLayout.LINE_END); // sto kentro kai sta deksia
		panel.add(getJlabel(), BorderLayout.NORTH); // PAGE_START);// to logo
													// sto panw meros
		panel.add(p2, BorderLayout.CENTER); // bazei ta koumpia sto kentro

		// p1.setBackground(Color.DARK_GRAY);
		// p2.setBackground(Color.DARK_GRAY);

		p1.setVisible(true);
		p2.setVisible(true);
		p3.setVisible(true);
		//
		f.add(panel);
		f.pack(); // or this
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}// end of constructor GUI

	// ***********************************************************************************
	// POP-UP WINDOW FOR MAIL AND DEAL
	// CARDS******************************************************************************************
	public GraphicUI(Controller c) {
		ctr = c;

		javax.swing.UIManager.put("OptionPane.messageFont", new Font(Font.SANS_SERIF, Font.PLAIN, 20));
		javax.swing.UIManager.put("OptionPane.buttonFont", new Font(Font.SANS_SERIF, Font.PLAIN, 20));
		cldr = this.getClass().getClassLoader();
		this.setResizable(false);
		this.setTitle("Cards");
		this.setPreferredSize(new Dimension(405, 200));
		// set Mail Button

		Image butts = new ImageIcon("src/view/images/mailCard.png").getImage().getScaledInstance(160, 160,
				java.awt.Image.SCALE_SMOOTH); // dineis to path kai sou
												// epistrefei to image
		ImageIcon ena = new ImageIcon(butts);
		JButton mailButton = new JButton("Get Mail Card");
		mailButton.setHorizontalTextPosition(JButton.CENTER);
		mailButton.setVerticalTextPosition(JButton.TOP);

		mailButton.setIcon(ena);
		mailButton.setName("Mail");
		mailButton.setSize(170, 170);
		JLayeredPane basic_panel = new JLayeredPane();
		basic_panel.setSize(405, 200);
		this.add(basic_panel);
		basic_panel.add(mailButton);
		mailButton.addActionListener(new CardListener());

		// set Deal Button
		butts = new ImageIcon("src/view/images/dealCard.png").getImage().getScaledInstance(170, 170,
				java.awt.Image.SCALE_SMOOTH); // dineis to path kai sou
												// epistrefei to image
		ena = new ImageIcon(butts);
		JButton dealButton = new JButton("Get Deal Card");
		dealButton.setHorizontalTextPosition(JButton.CENTER);
		dealButton.setVerticalTextPosition(JButton.TOP);

		dealButton.setIcon(ena);
		dealButton.setName("Deal");
		dealButton.setSize(170, 170);
		dealButton.setBounds(200, 0, 200, 200);
		dealButton.addActionListener(new CardListener());
		basic_panel.add(dealButton);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(basic_panel,
				GroupLayout.PREFERRED_SIZE, 910, GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(basic_panel,
				GroupLayout.PREFERRED_SIZE, 685, GroupLayout.PREFERRED_SIZE));
		pack();
		basic_panel.repaint();
		// setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	// ************************************************************************************************************************************************************************************************************

	private class CardListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			if (button.getName().equals("Mail")) {

				// int x=new Random().nextInt(48);// for Random
				showMailCard(ctr.kartaMail);
			} else if (button.getName().equals("Deal")) {

				// int x=new Random().nextInt(20); //for Random
				System.out.println(button.getName());
				showDealCard(ctr.kartaDeal);

			}
		}
	}

	public void showMailCard(MailCards m) {
		Object[] options = { m.getCommand() };

		ClassLoader cldr;
		cldr = this.getClass().getClassLoader();
		URL imageURL = cldr.getResource("resources/images/" + m.getIcon()); // image
		Image image = new ImageIcon(imageURL).getImage();
		image = image.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
		JOptionPane p = new JOptionPane();
		int n = p.showOptionDialog(this, // THELEI ALAGMA THELEI FTIAKSIMO
				m.getMessage(), m.getType(), JOptionPane.OK_OPTION, 0, new ImageIcon(image), options, options[0]);
	}

	public void showDealCard(DealCards d) {
		Object[] options = { d.getChoice1(), d.getChoice2() };
		URL imageURL = cldr.getResource("resources/images/" + d.getIcon()); // image
		Image image = new ImageIcon(imageURL).getImage();
		image = image.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
		JOptionPane p = new JOptionPane();
		int n = p
				.showOptionDialog(this,
						d.getMessage() + "\nΤιμή Αγοράς: " + d.getBuyValue() + " Ευρώ \nΤιμή Πώλησης: "
								+ d.getSellValue() + " Ευρώ \n",
						d.getType(), JOptionPane.OK_OPTION, 0, new ImageIcon(image), options, options[0]);
		System.out.println("result = " + n); // 0 agorase, 1 agnoise
		if (n == 0) {
			System.out.println("o paixtis agorase tin karta simfwnias");
			ctr.getP().giveMoney(d.getBuyValue());
			ctr.getP().addDealCard(d);

		} else {
			System.out.println("den dextike to deal");
			ctr.addPlayedDealCards(d);
		}

	}

	// *****************************************************************************
	// actionPerformed **********************************************
	@Override
	public void actionPerformed(ActionEvent e) {

		// System.out.println((e.getActionCommand()));
		// System.out.println(((JComponent) e.getSource()).getName());
		Object src = e.getActionCommand();
		
		

		if (src.equals("Roll Dice1") || src.equals("Roll Dice2")) {
			int i = -1;
			if(ctr.getP().isPlayed()) return;
			
			Position pos;
			i = ctr.getP().RollDice();
			ctr.setTrexonZaria(i);
			ctr.getP().MovePlayer(i);
			System.out.println("o paixtis " + ctr.getP().getName() + " erikse zari ");

			pos = ctr.Move(ctr.getP().getThesis()); // pare tin thesi pou
													// edeikse to zari tou
													// paixti pou epakse
			System.out.println("o paixtis " + ctr.getP().getName() + " metakinithike stin " + ctr.getP().getThesis());
			
			updateInfo();
			pos.performAction(ctr);
			//updateInfo();
			
			ctr.getP().setPlayed(true);
			Image zaria = new ImageIcon("src/view/images/dice-" + i + ".jpg").getImage().getScaledInstance(50, 50,
					java.awt.Image.SCALE_SMOOTH);
			ImageIcon ena = new ImageIcon(zaria);
			zari1.setIcon(ena);
			zaria = new ImageIcon("src/view/images/dice-" + i + ".jpg").getImage().getScaledInstance(50, 50,
					java.awt.Image.SCALE_SMOOTH);
			ena = new ImageIcon(zaria);
			zari2.setIcon(ena);

			// TODO update

		} else if (src.equals("Get Loan") || src.equals("Get Loan2")) {
			int i = 0;
			i = ctr.getLoan();

		} else if (src.equals("End Turn") || src.equals("End Turn2")) {
			if (ctr.isWinner() != true && ctr.getMonths() != ctr.getCurrentMonths())
				ctr.nextPlayer();

		} else if (src.equals("My Deal Cards")) {
			ArrayList<DealCards> a = new ArrayList<>();
			a = ctr.getDealCards();
		}
		else if (src.equals("Start Lottery")) {
			System.out.println("naiii");

			i = Integer.parseInt(text1field.getText());
			j = Integer.parseInt(text2field.getText());
			Die d = new Die();
			while (i != d.getZaria() && j != d.getZaria()) {
				d.roll();
				System.out.println("----->" + d.getZaria());
				Image zaria = new ImageIcon("src/view/images/dice-" + d.getZaria() + ".jpg").getImage()
						.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
				ImageIcon ena = new ImageIcon(zaria);
				zari.setIcon(ena);
				
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}

			}
			if(i == d.getZaria()) {
				// TODO na balw ta lefta ston p1
				System.out.println("Player 1 won 1000 euro!");
			}	
			else {
				// TODO na balw ta lefta sto p2
				System.out.println("Player 2 won 1000 euro!");
			}
		} else {
			System.out.println("tipota");
			
		}
		updateInfo();

	}

	// **********************************************************************************************************************************
	public GraphicUI(int i) {
		JFrame mainFrame;
		int val = 0,val2 = 0;

		mainFrame = new JFrame("Lottery");
		mainFrame.setSize(300, 300);
		mainFrame.setLayout(new GridLayout(3, 3));

		
		
		JButton s = new JButton("Start Lottery");
		s.addActionListener(this);
		
		JLabel p1 = new JLabel("Player 1 Bet A Number: ");
		
		text1field.setValue(new Double(val));
		text1field.setColumns(3);
		text1field.addActionListener(this);

		JLabel p2 = new JLabel("Player 2 Bet A Number: ");
		
		text2field.setValue(new Double(val2));
		text2field.setColumns(3);
		text2field.addActionListener(this);

		text2field.setColumns(3);
		text2field.addActionListener(this);
		mainFrame.add(p1);
		mainFrame.add(text1field);
		mainFrame.add(p2);
		mainFrame.add(text2field);
		mainFrame.add(s);
		mainFrame.add(zari);
		mainFrame.setVisible(true);


	}
	
	
	
	// **********************************************************************************************************************************
	/**
	 * rescales image
	 *
	 * @param image
	 *            image location
	 * @return
	 */
	static ImageIcon getImageScaled(String image) {
		Image newimg = new ImageIcon(image).getImage().getScaledInstance(1000, 253, java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(newimg);
	}

	static JLabel getJlabel() {
		JLabel labelimg = new JLabel();
		labelimg.setIcon(getImage("src/view/logo.png"));
		labelimg.setSize(1000, 100);
		return labelimg;
	}

	static ImageIcon getImage(String imgs) {
		ImageIcon img = getImageScaled(imgs);
		return img;
	}

	/** Returns an ImageIcon, or null if the path was invalid. */
	protected ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	public ArrayList<ImageIcon> getTableImages() {
		ArrayList<ImageIcon> table = new ArrayList<>();

		Image butts = new ImageIcon("src/view/table/buyer.png").getImage().getScaledInstance(100, 100,
				java.awt.Image.SCALE_SMOOTH); // dineis to path kai sou
												// epistrefei to image
		ImageIcon ena = new ImageIcon(butts);

		table.add(ena);
		butts = new ImageIcon("src/view/table/casino.png").getImage().getScaledInstance(100, 100,
				java.awt.Image.SCALE_SMOOTH);
		ena = new ImageIcon(butts);
		table.add(ena);
		butts = new ImageIcon("src/view/table/deal.png").getImage().getScaledInstance(100, 100,
				java.awt.Image.SCALE_SMOOTH);
		ena = new ImageIcon(butts);
		table.add(ena);
		butts = new ImageIcon("src/view/table/jackpot.png").getImage().getScaledInstance(100, 100,
				java.awt.Image.SCALE_SMOOTH);
		ena = new ImageIcon(butts);
		table.add(ena);
		butts = new ImageIcon("src/view/table/lottery.png").getImage().getScaledInstance(100, 100,
				java.awt.Image.SCALE_SMOOTH);
		ena = new ImageIcon(butts);
		table.add(ena);
		butts = new ImageIcon("src/view/table/mc1.png").getImage().getScaledInstance(100, 100,
				java.awt.Image.SCALE_SMOOTH);
		ena = new ImageIcon(butts);
		table.add(ena);
		butts = new ImageIcon("src/view/table/mc2.png").getImage().getScaledInstance(100, 100,
				java.awt.Image.SCALE_SMOOTH);
		ena = new ImageIcon(butts);
		table.add(ena);
		butts = new ImageIcon("src/view/table/pay.png").getImage().getScaledInstance(100, 100,
				java.awt.Image.SCALE_SMOOTH);
		ena = new ImageIcon(butts);
		table.add(ena);
		butts = new ImageIcon("src/view/table/radio.png").getImage().getScaledInstance(100, 100,
				java.awt.Image.SCALE_SMOOTH);
		ena = new ImageIcon(butts);
		table.add(ena);
		butts = new ImageIcon("src/view/table/sweep.png").getImage().getScaledInstance(100, 100,
				java.awt.Image.SCALE_SMOOTH);
		ena = new ImageIcon(butts);
		table.add(ena);
		butts = new ImageIcon("src/view/table/yard.png").getImage().getScaledInstance(100, 100,
				java.awt.Image.SCALE_SMOOTH);
		ena = new ImageIcon(butts);
		table.add(ena);

		return table;

	}

	public void updateInfo() {
		Player1.setText(ctr.getP1().getName());
		money.setText(Integer.toString(ctr.getP1().getCurrentMoney()));
		bills.setText(Integer.toString(ctr.getP1().getBill()));
		laon.setText(Integer.toString(ctr.getP1().getLoan()));
	
		Player2.setText(ctr.getP2().getName());
		money2.setText(Integer.toString(ctr.getP2().getCurrentMoney()));
		bills2.setText(Integer.toString(ctr.getP2().getBill()));
		laon2.setText(Integer.toString(ctr.getP2().getLoan()));

		start.remove(pawn1);
		start.remove(pawn2);
		for(int i =0; i<31; i++) {
			butt[i].remove(pawn1);
			butt[i].remove(pawn2);

		}
		if(ctr.getP1().getThesis() == 0){
			start.add(pawn1);
		}else
		butt[ctr.getP1().getThesis()-1].add(pawn1);
	
		if(ctr.getP2().getThesis() == 0){
			start.add(pawn2);
		}else
		butt[ctr.getP2().getThesis()-1].add(pawn2);
		}
}