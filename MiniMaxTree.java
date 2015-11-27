import java.util.ArrayList;

public class MinimaxTree {
	private Board move;
	private State root;
	private ArrayList<Board> children;
	private int[][] luck;
	public static final int MAXDEPTH = 2;
	
	public MinimaxTree(State r){
		root = r;
		
	}
	public MinimaxTree(){
		
	}
	public void put(ArrayList<State> children){
		
	}
	
	
	
	
	
}




public Board expectiMinimax(Board board,int d1,int d2){
	luck = filluck();
	
	return Max(board ,d1 ,d2 ,0 ,Integer.MIN_VALUE ,Integer.MAX_VALUE);
}


public Board Max(Board board,int d1,int d2,int depth,int alpha, int beta){
	
	if(board.isTerminal() || depth == MAXDEPTH){
		// telikh kinhsh epistrefw 
	}
	
	Board maxMove = new Board(Integer.MIN_VALUE);
		
			Board maxChild =new Board(getNextMove(board,d1,d2));
			if(maxChild == null) break;
			for(int i=0; i<21; i++){
	
				Board minChild = new Board(Min(maxChild,luck[i][1],luck[i][2],depth + 1, alpha, beta));
				if(minChild.getValue() > maxMove.getValue() ){  // TRUE EINAI TO MAVRO
					maxMove.setBoard(minChild.getBoard());
					maxMove.setValue(minChild.getValue());
				}
				if(minChild.getValue() >= beta) return maxMove;
				if(minChild.getValue() > alpha) alpha = minChild.getValue();
			}

		
		
		
		
	
	return maxMove;
	
}

public Board Min(Board board,int d1,int d2,int depth,int alpha, int beta){
	
	if(board.isTerminal() || depth == MAXDEPTH){
		// telikh kinhsh epistrefw 
	}
	
	Board minMove = new Board(Integer.MAX_VALUE);
	while(true){
		
		Board minChild =new Board(board);
		
		if(minChild == null) break;
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




if(d1 == d2){//DIPLES
	for(int move1=0; move1<24; move1++){
		Board maxChild =new Board(board);//to maxChild ginetai to tamplo 
		maxChild.setValue(maxChild.evaluate(true));
		
		if(maxChild.noMoreMoves(d1)){
			
			//MAX 
			for(int i=0; i<21; i++){
				
				Board minChild = new Board(Min(maxChild,luck[i][1],luck[i][2],depth + 1, alpha, beta));
				if(minChild.getValue() > maxMove.getValue() ){  // TRUE EINAI TO MAVRO
					maxMove.setBoard(minChild.getBoard());
					maxMove.setValue(minChild.getValue());
				}
				if(minChild.getValue() >= beta) return maxMove;
				if(minChild.getValue() > alpha) alpha = minChild.getValue();
			}//KLEINEI MAX
			break;
		}
		else if( (move1 + d1 < 24) && board.canMoveCh(move1, move1 + d1)){
			maxChild.moveCh(move1, move1 + d1);
			maxChild.setValue(maxChild.evaluate(true));
			
			for(int move2=0; move2<24; move2++){//DEUTERH KINHSH 
				if(board.noMoreMoves(d1)){
					//MAX
					for(int i=0; i<21; i++){
						
						Board minChild = new Board(Min(maxChild,luck[i][1],luck[i][2],depth + 1, alpha, beta));
						if(minChild.getValue() > maxMove.getValue() ){  // TRUE EINAI TO MAVRO
							maxMove.setBoard(minChild.getBoard());
							maxMove.setValue(minChild.getValue());
						}
						if(minChild.getValue() >= beta) return maxMove;
						if(minChild.getValue() > alpha) alpha = minChild.getValue();
					}//KLEINEI MAX
					break;
				}
				else if( (move2 + d1 < 24) && board.canMoveCh(move2, move2 + d1)){
					maxChild.moveCh(move2, move2 + d1);
					maxChild.setValue(maxChild.evaluate(true));
				
					for(int move3=0; move3<24; move3++){//TRITH KINHSH 
						if(board.noMoreMoves(d1)){
							//MAX
							for(int i=0; i<21; i++){
								
								Board minChild = new Board(Min(maxChild,luck[i][1],luck[i][2],depth + 1, alpha, beta));
								if(minChild.getValue() > maxMove.getValue() ){  // TRUE EINAI TO MAVRO
									maxMove.setBoard(minChild.getBoard());
									maxMove.setValue(minChild.getValue());
								}
								if(minChild.getValue() >= beta) return maxMove;
								if(minChild.getValue() > alpha) alpha = minChild.getValue();
							}//KLEINEI MAX
							break;
						}
						else if( (move3 + d1 < 24) && board.canMoveCh(move3, move3 + d1)){
							maxChild.moveCh(move3, move3 + d1);
							maxChild.setValue(maxChild.evaluate(true));
						
							for(int move4=0; move4<24; move4++){//TETARTH KINHSH
								if(board.noMoreMoves(d1)){
									//MAX
									for(int i=0; i<21; i++){
										
										Board minChild = new Board(Min(maxChild,luck[i][1],luck[i][2],depth + 1, alpha, beta));
										if(minChild.getValue() > maxMove.getValue() ){  // TRUE EINAI TO MAVRO
											maxMove.setBoard(minChild.getBoard());
											maxMove.setValue(minChild.getValue());
										}
										if(minChild.getValue() >= beta) return maxMove;
										if(minChild.getValue() > alpha) alpha = minChild.getValue();
									}//KLEINEI MAX
									break;
								}
								else if( (move4 + d1 < 24) && board.canMoveCh(move4, move4 + d1)){
									maxChild.moveCh(move4, move4 + d1);

									for(int i=0; i<21; i++){
							
										Board minChild = new Board(Min(maxChild,luck[i][1],luck[i][2],depth + 1, alpha, beta));
										if(minChild.getValue() > maxMove.getValue() ){  // TRUE EINAI TO MAVRO
											maxMove.setBoard(minChild.getBoard());
											maxMove.setValue(minChild.getValue());
										}
										if(minChild.getValue() >= beta) return maxMove;
										if(minChild.getValue() > alpha) alpha = minChild.getValue();
									}
			
								

									
public Board getNextMove(Board b,int d1,int d2){									
	if(d1 == d2){//DIPLES
		if(maxChild.noMoreMoves(d1)){
			/*
			//MAX 
			for(int i=0; i<21; i++){
				
				Board minChild = new Board(Min(maxChild,luck[i][1],luck[i][2],depth + 1, alpha, beta));
				if(minChild.getValue() > maxMove.getValue() ){  // TRUE EINAI TO MAVRO
					maxMove = minChild;
				}
				if(minChild.getValue() >= beta) return maxMove;
				if(minChild.getValue() > alpha) alpha = minChild.getValue();
			}//KLEINEI MAX
			*/
		}else{
			for(int i=0; i<24; i++){ 
				if( (i + d1 < 24) && board.canMoveCh(i, i + d1)){
					Board maxChild =new Board(b);//to maxChild ginetai to tamplo
					maxChild.moveCh(i, i + d1);
					maxChild.setValue(maxChild.evaluate(true));	
					maxChild.getNextMove(maxChild,int d1,int d2);
		}
		
						
					
