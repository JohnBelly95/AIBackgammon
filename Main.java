import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.imageio.*;

public class Main {
	private static Dice d6a,d6b;
	private static Board gb;
	private static int a,b,moves;
	private static Scanner read = new Scanner(System.in);
	public static JFrame mFrame = new JFrame("Backgammon");
	public static JLayeredPane gBoard = new JLayeredPane();
	private static final String tut = ("Backgammon is one of the oldest board games known.<br>This implementation comes from a Greek variation called \"Πλακωτό\"<br>");
	public static GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	private static int height = gd.getDisplayMode().getHeight();
	private static int width = gd.getDisplayMode().getWidth();
	private static int x = 3*(height/5)-62;
	static JMenuBar menuBar;
	static JMenu mainMenu;
	static JCheckBoxMenuItem debugMode;
	static BufferedImage img = null;
	static BufferedImage wCh = null;
	static BufferedImage bCh = null;
	public static String playerIn;
	public static JButton roll;
	public static JTextField tf;
	
	public static void main(String[] args){
		
		d6a = new Dice();
		d6b = new Dice();
		gb = new Board();
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
				//TODO Add action on press.
				switch(e.getActionCommand()){
					case "New Game": {
							try {
								//HERE GOES THE GAME CODE. DEAL WITH IT.
								createBoard();
								drawBoard(gb);
								while(!gb.isTerminal()){
									//TODO Add code.
									PlayerMove();
									AIMove();
								}
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							break;
						}
					case "Tutorial":{
							drawTutorial();
							break;
						}
					case "Credits":{
							//TODO Add credits.
							break;
						}
					case "Return":{
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
	
	public static void PlayerMove(){
		roll.setEnabled(true);
		try {
			//System.
		} catch(InterruptedException e) {
		}
		if(a==b) moves = 4;
		else moves =2;
	}
	
	public static void AIMove(){
		
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
	
	public static void createBoard() throws IOException{
		
		gBoard.setSize(1024,648);
		
		menuBar = new JMenuBar();
		
		mainMenu = new JMenu("Settings");
		mainMenu.setMnemonic(KeyEvent.VK_ESCAPE);
		
		debugMode = new JCheckBoxMenuItem("Debug Mode");
		mainMenu.add(debugMode);
		
		img = ImageIO.read(new File("resources/board.jpg"));
		BufferedImage resizedImg = resizeImage(img,img.getType());
		JLabel boardPic = new JLabel(new ImageIcon(resizedImg));
		boardPic.setBounds(((3*(width/5))-((x*145)/100)-15), 0,(x*145)/100, 3*(height/5));
		
		JPanel DiceArea = new JPanel(new GridLayout(2,1));
		JLabel result = new JLabel("Results of die rolls will show here.");
		roll = new JButton("Roll Dice");
		roll.setEnabled(false);
		roll.setBounds(0, 0, 100, 20);
		DiceArea.add(roll);
		DiceArea.add(result);
		roll.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//TODO Add action on press.
				a = d6a.roll();
				b = d6b.roll();
				result.setText("You rolled: " + a +" and " + b);
				DiceArea.repaint();
				roll.setEnabled(false);
			}
		});
		DiceArea.setBounds(10,50,270,60);
		
		JPanel text = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.HORIZONTAL;
		tf = new JTextField(20);
		JTextArea textArea = new JTextArea(5,20);
		JScrollPane scrollPane = new JScrollPane(textArea);
		textArea.setEditable(false);
		//tf.setBounds(10,300,270,270);
		tf.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String input = tf.getText();
				textArea.append(input+"\n");
				tf.selectAll();
				textArea.setCaretPosition(textArea.getDocument().getLength());
			}
		});
        text.add(tf, c);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        text.add(scrollPane, c);
        text.setBounds(10, 300, 270, 270);
		
		menuBar.add(mainMenu);
		gBoard.add(boardPic);
		gBoard.setLayer(boardPic,0);
		gBoard.add(text);
		gBoard.add(DiceArea);
		mFrame.setJMenuBar(menuBar);
		mFrame.setContentPane(gBoard);
		mFrame.setBounds(width/5,height/5,3*(width/5),3*(height/5));
		mFrame.setVisible(true);
	}
	
	public static void drawBoard(Board board) throws IOException{
		Checker token = null;
		for(int i=0;i<24;i++){
			int j =0;
			token = board.board[i].lastNode;
			
			JLabel ch = new JLabel();
			if(board.board[i].size()<4){
				while(token != null){
					if(token.color){
						ch = blackCh();
						if(i<6){
							ch.setBounds(310 + i*63, 505 -j*62, 60, 60);
						}else if(5<i&&i<12){
							ch.setBounds(620 + (i%6)*63, 505 -j*62, 60, 60);
						}else if(11<i&&i<18){
							ch.setBounds(1100 - (i%6)*63,15 + j*62,60,60);
						}else if(17<i&&i<24){
							ch.setBounds(630-(i%6)*63, 20+ j*62, 60, 60);
						}
					}else{
						ch = whiteCh();
						if(i<6){
							ch.setBounds(310 + i*63, 505 -j*62, 60, 60);
						}else if(5<i&&i<12){
							ch.setBounds(620 + (i%6)*63, 505 -j*62, 60, 60);
						}else if(11<i&&i<18){
							ch.setBounds(1100 - (i%6)*63,15 + j*62,60,60);
						}else if(17<i&&i<24){
							ch.setBounds(630-(i%6)*63, 20+ j*62, 60, 60);
						}
					}
					gBoard.add(ch);
					gBoard.setLayer(ch, 1);
					j++;
					token = token.nextCh;
				}
			}else{
				if(board.board[i].firstNode.color==board.board[i].lastNode.color){
					for(int k=0;k<4;k++){
						if(token.color){
							ch = blackCh();
							if(i<6){
								ch.setBounds(310 + i*63, 505 -j*62, 60, 60);
							}else if(5<i&&i<12){
								ch.setBounds(620 + (i%6)*63, 505 -j*62, 60, 60);
							}else if(11<i&&i<18){
								ch.setBounds(1100 - (i%6)*63,15 + j*62,60,60);
							}else if(17<i&&i<24){
								ch.setBounds(630-(i%6)*63, 20+ j*62, 60, 60);
							}
						}else{
							ch = whiteCh();
							if(i<6){
								ch.setBounds(310 + i*63, 505 -j*62, 60, 60);
							}else if(5<i&&i<12){
								ch.setBounds(620 + (i%6)*63, 505 -j*62, 60, 60);
							}else if(11<i&&i<18){
								ch.setBounds(1100 - (i%6)*63,15 + j*62,60,60);
							}else if(17<i&&i<24){
								ch.setBounds(630-(i%6)*63, 20+ j*62, 60, 60);
							}
						}
						gBoard.add(ch);
						gBoard.setLayer(ch, 1);
						j++;
					}
				}else{
					for(int k=0;k<4;k++){
						if(token.color){
							ch = blackCh();
							if(i<6){
								ch.setBounds(310 + i*63, 505 -j*62, 60, 60);
							}else if(5<i&&i<12){
								ch.setBounds(620 + (i%6)*63, 505 -j*62, 60, 60);
							}else if(11<i&&i<18){
								ch.setBounds(1100 - (i%6)*63,15 + j*62,60,60);
							}else if(17<i&&i<24){
								ch.setBounds(630-(i%6)*63, 20+ j*62, 60, 60);
							}
						}else{
							ch = whiteCh();
							if(i<6){
								ch.setBounds(310 + i*63, 505 -j*62, 60, 60);
							}else if(5<i&&i<12){
								ch.setBounds(620 + (i%6)*63, 505 -j*62, 60, 60);
							}else if(11<i&&i<18){
								ch.setBounds(1100 - (i%6)*63,15 + j*62,60,60);
							}else if(17<i&&i<24){
								ch.setBounds(630-(i%6)*63, 20+ j*62, 60, 60);
							}
						}
						gBoard.add(ch);
						gBoard.setLayer(ch, 1);
						j++;
					}
				}
				//break;
			}
		}
		gBoard.repaint();
	}
	
	private static BufferedImage resizeImage(BufferedImage originalImage, int type){
		BufferedImage resizedImage = new BufferedImage((x*145)/100, 3*(height/5), type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, (x*145)/100, x, null);
		g.dispose();
		return resizedImage;
	}
	
	public static JLabel blackCh() throws IOException{
		bCh = ImageIO.read(new File("resources/blackCh.png"));
		BufferedImage btoken = new BufferedImage(60,60,bCh.getType());
		Graphics2D g1 = btoken.createGraphics();
		g1.drawImage(bCh,0,0,60,60,null);
		g1.dispose();
		bCh = btoken;
		JLabel blackCh = new JLabel(new ImageIcon(bCh));
		blackCh.setBounds(0,0,60,60);
		return blackCh;
	}
	
	public static JLabel whiteCh() throws IOException{
		wCh = ImageIO.read(new File("resources/whiteCh.png"));
		BufferedImage wtoken = new BufferedImage(60,60,wCh.getType());
		Graphics2D g = wtoken.createGraphics();
		g.drawImage(wCh,0,0,60,60,null);
		g.dispose();
		wCh = wtoken;
		JLabel whiteCh = new JLabel(new ImageIcon(wCh));
		whiteCh.setBounds(0,0,65,65);
		return whiteCh;
	}
	
	/*public State expectiMiniMax(int d1,int d2,boolean color){
		for(int i=23; i>=0; i--){
			if(b.board[i].look() != null && b.board[i].look().color == color){
				int p = b.board[i].look().pos;
			}
		}
	}*/
}
