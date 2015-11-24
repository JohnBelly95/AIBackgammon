import java.util.ArrayList;
import java.util.ArrayList;

public class MinimaxTree {
	private Board move;
	private State root;
	private ArrayList<Board> children;
	
	public MinimaxTree(State r){
		root = r;
		
	}
	public MinimaxTree(){
		
	}
	public void put(ArrayList<State> children){
		
	}
	
	
	
	
	
}



public Board expectiMinimax(Board board,int d1,int d2){
	children = new ArrayList<Board>();
	Board Max;
	while(true){
		if(getNextMove == null){// H MEXRI NA TELEIWSEI H NEXTMOVE
			break;
		}

		Board child = new Board(board.getNextMove(d1,d2));
		children.add(child);
		
	}
	
}
