import java.io.*;
import java.util.*;

public class Main {
	private static Dice d6a,d6b;
	private static Board b;
	private static int a;
	private static Scanner read = new Scanner(System.in);
	
	public static void main(String[] args){
		d6a = new Dice();
		d6b = new Dice();
		b = new Board();
		/*double j=0;
		for(int i=0;i<1000;i++){
			j+=d6a.roll() + d6b.roll();
		}
		System.out.println(j/1000);
		*/
	}
	
	
	
	public State expectiMiniMax(int d1,int d2,boolean color){
		for(int i=23; i>=0; i--){
			if(b.board[i].look() != null && b.board[i].look().color == color){
				int p = b.board[i].look().pos;
			}
		}
	}
}
