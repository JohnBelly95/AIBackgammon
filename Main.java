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
	public static JFrame mFrame = new JFrame("Backgammon");
	public static JLayeredPane gBoard = new JLayeredPane();
	private static final String tut = ("Backgammon is one of the oldest board games known.<br>This implementation comes from a Greek variation called \"Πλακωτό\"<br>");
	public static GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	static JMenuBar menuBar;
	static JMenu mainMenu;
	static JCheckBoxMenuItem debugMode;
	
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
							createBoard();
							break;
						}
					case "Tutorial":{
							System.out.println("Time to print a tutorial.");
							drawTutorial();
							break;
						}
					case "Credits":{
							System.out.println("will code for coffee.");
							break;
						}
					case "Return":{
							System.out.println("BACK I SAY!");
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
	
	public static void drawTutorial(){
		JFrame frame = new JFrame("Tutorial");
		
		JPanel p = new JPanel(new BorderLayout());
		
		JLabel lb = new JLabel("<html><div style=\"text-align: center;\">"+tut+"</html>");
		lb.setBorder(new EmptyBorder(10,10,10,10));
		p.add(lb);
		
		JButton c = createButton("Return",KeyEvent.VK_ESCAPE);
		c.setToolTipText("Return to previous screen");
		c.setSize(10,50);
		c.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}
		});
		p.add(c,BorderLayout.PAGE_END);
		
		frame.add(p);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(710, 440, 500, 200);
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame.setVisible(true);
	}
	
	public static void createBoard(){
		gBoard.setSize(1024,720);
		
		menuBar = new JMenuBar();
		
		mainMenu = new JMenu("Settings");
		mainMenu.setMnemonic(KeyEvent.VK_ESCAPE);
		
		debugMode = new JCheckBoxMenuItem("Debug Mode");
		mainMenu.add(debugMode);

		menuBar.add(mainMenu);
		mFrame.setJMenuBar(menuBar);
		mFrame.setContentPane(gBoard);
		mFrame.setBounds(gd.getDisplayMode().getWidth()/7,gd.getDisplayMode().getHeight()/5,5*(gd.getDisplayMode().getWidth()/7),3*(gd.getDisplayMode().getHeight()/5));
		mFrame.setVisible(true);
	}
	/*public State expectiMiniMax(int d1,int d2,boolean color){
		for(int i=23; i>=0; i--){
			if(b.board[i].look() != null && b.board[i].look().color == color){
				int p = b.board[i].look().pos;
			}
		}
	}*/
}
