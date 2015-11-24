import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

import javax.swing.*;

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
		topPanel.setSize(100,200);
		
		JPanel bottomPanel = new JPanel(new BorderLayout());
		//bottomPanel.setSize(1280,600);
		
		JLabel l1 = new JLabel("Welcome.");
		l1.setHorizontalTextPosition(JLabel.CENTER);
		l1.setVerticalTextPosition(JLabel.CENTER);
		topPanel.add(l1, BorderLayout.NORTH);
		
		JLabel l2 = new JLabel("This is a Backgammon simulator.");
		l2.setHorizontalTextPosition(JLabel.CENTER);
		topPanel.add(l2, BorderLayout.CENTER);
		
		JLabel l3 = new JLabel("Please click a button from bellow to continue.");
		l3.setHorizontalTextPosition(JLabel.CENTER);
		topPanel.add(l3, BorderLayout.SOUTH);
		
		JButton b1 = new JButton("New Game");
		b1.setVerticalTextPosition(AbstractButton.TOP);
		b1.setMnemonic(KeyEvent.VK_D);
		b1.setToolTipText("This will take you to a new game of Backgammon.");
		bottomPanel.add(b1,BorderLayout.PAGE_START);
		
		JButton b2 = new JButton("Tutorial");
		b2.setVerticalTextPosition(AbstractButton.CENTER);
		b2.setMnemonic(KeyEvent.VK_M);
		b2.setToolTipText("View the tutorial for this game.");
		bottomPanel.add(b2,BorderLayout.CENTER);
		
		JButton b3 = new JButton("Credits");
		b3.setVerticalTextPosition(AbstractButton.BOTTOM);
		b3.setMnemonic(KeyEvent.VK_E);
		b3.setToolTipText("This is who we (The creators) are. Thank you for playing.");
		bottomPanel.add(b3,BorderLayout.PAGE_END);
		
		JFrame frame = new JFrame("Game");
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(810, 440, 300, 200);
	    frame.add(topPanel, BorderLayout.NORTH);
	    frame.add(bottomPanel ,BorderLayout.SOUTH);
	    frame.setVisible(true);
	}
	
	/*public State expectiMiniMax(int d1,int d2,boolean color){
		for(int i=23; i>=0; i--){
			if(b.board[i].look() != null && b.board[i].look().color == color){
				int p = b.board[i].look().pos;
			}
		}
	}*/
}
