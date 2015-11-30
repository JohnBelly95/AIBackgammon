import java.util.ArrayList;

public class MinimaxTree {
	public static final int MAXDEPTH = 2;
	int[][] luck = filluck();
	public  ArrayList<Board> children;

	
	public Board expectiMinimax(Board parent,int d1,int d2,int depth,int alpha , int beta,boolean clr){
		
		if(clr){
			return Max(parent,d1,d2,depth,alpha,beta);
		}else{
			return Min(parent,d1,d2,depth,alpha,beta);
		}
	}
	
	
	public Board Max(Board parent,int d1,int d2,int depth,int alpha, int beta){
		
		if(parent.isTerminal() || depth == MAXDEPTH){
			// telikh kinhsh epistrefw 
		}
		
		Board maxMove = new Board(Integer.MIN_VALUE);
		children = new ArrayList<Board>(parent.getChildren(d1,d2));
		for(Board child : children){
			Board maxChild =new Board(child);
			for(int i=0; i<21; i++){
				Board minChild = new Board(Min(maxChild,luck[i][1],luck[i][2],depth + 1, alpha, beta));
				if(minChild.getValue() > maxMove.getValue() ){  // TRUE EINAI TO MAVRO
					maxMove.setBoard(minChild.getBoard());
					maxMove.setValue(minChild.getValue());
				}
				if(minChild.getValue() >= beta) return maxMove;
				if(minChild.getValue() > alpha) alpha = minChild.getValue();
			}
		}	 
	
			
			
			
			
		
		return maxMove;
		
	}
	
	public Board Min(Board parent,int d1,int d2,int depth,int alpha, int beta){
		
		if(parent.isTerminal() || depth == MAXDEPTH){
			// telikh kinhsh epistrefw 
		}
		
		Board minMove = new Board(Integer.MAX_VALUE);
		children = new ArrayList<Board>(parent.getChildren(d1,d2));
		for(Board child : children){
			Board minChild =new Board(child);
			for(int i=0; i<21; i++){
				Board maxChild = new Board(Max(minChild,luck[i][1],luck[i][2],depth + 1, alpha, beta));
				if(maxChild.getValue() > minMove.getValue() ){
					minMove.setBoard(maxChild.getBoard());
					minMove.setValue(maxChild.getValue());
				}
				if(maxChild.getValue() <= alpha) return minMove;
				if(maxChild.getValue() < beta) beta = minChild.getValue();
			}
		}
			
		
		return minMove;
		
	}
	
	
	
	
	
	
	
	private int[][] filluck(){         // GEMIZW THN TYXH
		int[][] l = new int[21][2];
		for(int i=0 ; i<21; i++){
			if(i<6){
				l[i][0] = 1;
			}
			else if(i<11){
				l[i][0] = 2;
			}else if(i<15){
				l[i][0] = 3;
			}else if(i<18){
				l[i][0] = 4;
			}else if(i<20){
				l[i][0] = 5;
			}else {
				l[i][0] = 6;
			}
		}
		int k = 0;
		int j = 0;
		for(int i=0 ; i<21; i++){
			k++;
			l[i][1] = k;
			if(k == 6){
				j++;
				k = j;
			}
		}
		return l;
	}
}




		
						
					
