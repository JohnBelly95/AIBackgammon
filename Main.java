import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;

public class Main {
	private static Dice d6a,d6b;
	private static Board b;
	private static int a;
	private static Scanner read = new Scanner(System.in);
	
	public static void main(String[] args){

		d6a = new Dice();
		d6b = new Dice();
		b = new Board();
		drawMenu();
		/*double j=0;
		for(int i=0;i<1000;i++){
			j+=d6a.roll() + d6b.roll();
		}
		System.out.println(j/1000);
		*/
	}
	
	public static void drawMenu(){
		JPanel topPanel = new JPanel(new BorderLayout());
		//topPanel.setSize(100,200);
		topPanel.setBorder(new EmptyBorder(2,2,2,2));
		
		JPanel bottomPanel = new JPanel(new GridLayout(3,1));
		bottomPanel.setBorder(new EmptyBorder(2,2,2,2));
		
		JLabel l1 = new JLabel("<html><div style=\"text-align: center;\">"+"Welcome"+"<br>"+"This is our Backgammon simulator"+"<br>"+"Please click a button from bellow to continue."+"</htmal>");
		l1.setBorder(new EmptyBorder(3,9,3,3));
		topPanel.add(l1);
		
		JButton b1 = createButton("New Game", KeyEvent.VK_N);
		b1.setToolTipText("This will start a new game.");
		
		JButton b2 = createButton("Tutorial", KeyEvent.VK_T);
		b2.setToolTipText("Read the tutorial for help");
		
		JButton b3 = createButton("Credits", KeyEvent.VK_C);
		b3.setToolTipText("Thank you for playing. This is who we are.");
		
		bottomPanel.add(b1);
		bottomPanel.add(b2);
		bottomPanel.add(b3);
		/*
		b1.setMnemonic(KeyEvent.VK_N);
		b1.setToolTipText("This will take you to a new game of Backgammon.");
		b1.setMargin(new Insets(8, 8, 8, 8));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				//Execute when button is pressed
				//TODO Get fucked.
				System.out.println("You clicked the button");
			}
		});      
		bottomPanel.add(b1,BorderLayout.PAGE_START);
		
		JButton b2 = new JButton("Tutorial");
		b2.setVerticalTextPosition(AbstractButton.CENTER);
		b2.setMnemonic(KeyEvent.VK_T);
		b2.setToolTipText("View the tutorial for this game.");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				//Execute when button is pressed
				//TODO Add Tutorial.
				System.out.println("You clicked the button");
			}
		});   
		bottomPanel.add(b2,BorderLayout.CENTER);
		
		JButton b3 = new JButton("Credits");
		b3.setVerticalTextPosition(AbstractButton.BOTTOM);
		b3.setMnemonic(KeyEvent.VK_C);
		b3.setToolTipText("This is who we (The creators) are. Thank you for playing.");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				//Execute when button is pressed
				//TODO Add Credits Window
				System.out.println("You clicked the Credits button");
			}
		});   
		bottomPanel.add(b3,BorderLayout.PAGE_END);*/
		
		JFrame frame = new JFrame("Game");
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(810, 440, 300, 200);
	    frame.add(topPanel, BorderLayout.NORTH);
	    frame.add(bottomPanel ,BorderLayout.SOUTH);
	    frame.setVisible(true);
	}
	
	protected static JButton createButton(String name, int Key){
		JButton b = new JButton(name);
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println(e.getActionCommand() + " was clicked");
				//TODO Add action on press.
				switch(e.getActionCommand()){
					case "New Game": {
							System.out.println("This is something");
							break;
						}
					case "Tutorial":{
							System.out.println("Time to print a tutorial.");
							break;
						}
					case "Credits":{
							System.out.println("will code for coffee.");
							break;
						}
					default: System.out.println("This works. I think.");
							break;
				}
			}
		});
		b.setMargin(new Insets(6,6,6,6));
		b.setMnemonic(Key);
		InputMap im = b.getInputMap(b.WHEN_IN_FOCUSED_WINDOW);
		ActionMap am = b.getActionMap();
		im.put(KeyStroke.getKeyStroke(Key, 0), "onClick");
		am.put("onClick", new AbstractAction(){
			public void actionPerformed(ActionEvent e){
				JButton jb = (JButton) e.getSource();
				jb.doClick();
			}
		});
		return b;
	}
	
	/*public State expectiMiniMax(int d1,int d2,boolean color){
		for(int i=23; i>=0; i--){
			if(b.board[i].look() != null && b.board[i].look().color == color){
				int p = b.board[i].look().pos;
			}
		}
	}*/
}
