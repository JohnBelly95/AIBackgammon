import java.util.ArrayList;
public class Board {
	Checker token=null;
	Stack[] board;
	int wLocked,wDoor,wAlone,moves;
	int value;
	public ArrayList<Board> children;
	
	
	public Board(){
		board =new Stack[24];
		populate(board);
		wLocked = 20;
		wDoor = 50;
		wAlone = 20;
	}
	
	public Board(int value){
		board = null;
		this.value = value;
	}
	public Board(Board b){
		board = b.board;
		this.value = b.value;
	}
	
	
	public Stack[] getBoard(){
		return board;
	}
	public int getValue(){
		return value;
	}
	
	public void setBoard(Stack[] b){
		this.board = b;
	}
	public void setValue(int v){
		this.value = v;
	}
	public void populate(Stack[] board){
		Checker whiteToken = new Checker(1,false);
		Checker blackToken = new Checker(24,true);
		Stack st = new Stack();
		for(int i=0 ; i<24; i++){
			board[i] = st;
		}
		for(int i=0;i<15;i++){
			board[0].push(whiteToken);
			board[23].push(blackToken);
		}
	}
	public void moveCh(int stPos,int fnPos){
		if(!board[stPos].isEmpty() && available(stPos,fnPos)){
			token = board[stPos].pop();
			token.pos = fnPos;
			board[fnPos].push(token);
		}
	}
	public boolean noMoreMoves(int d){
		for(int i=0; i<24; i++){
			if(available(i,i + d)) return false;
		}
		return true;
	}
	public boolean available(int stPos, int fnPos){
		if((stPos-fnPos)>0 && board[stPos].lastNode.color){
			if(board[fnPos].isEmpty()){
				return true;
			}else if(board[fnPos].size()==1){
				return true;
				
			}else if(board[fnPos].size()>1 && board[fnPos].lastNode.color){
				return true;
			}
			else return false;
		}else if((stPos-fnPos)<0 && !board[stPos].lastNode.color){
			if(board[fnPos].isEmpty()){
				return true;
			}else if(board[fnPos].size()==1){
				return true;
				
			}else if(board[fnPos].size()>1 && !board[fnPos].lastNode.color){
				return true;
			}
			else return false;
		}else return false;
	}
	/*This method evaluates each state and returns the score.*/
	public int evaluate(boolean clr){
		int a = 0;
		if(clr==true){
			for(int i=24;i>0;i--){
				if(board[i].firstNode.color && board[i].lastNode.color) {
					if(board[i].size() > 1 ) a += i*board[i].size() + wDoor;
					else a -= i*wAlone;
				}
				if(!board[i].firstNode.color && board[i].lastNode.color) a += (25-i)*wLocked;
				if(board[i].firstNode.color && !board[i].lastNode.color) a += i;
			}
		}else{
			for(int i=1;i<25;i++){
				if(!board[i].firstNode.color && !board[i].lastNode.color) {
					if(board[i].size() > 1) a -= i*board[i].size() + wDoor;
					else a += i*wAlone;
				}
				if(board[i].firstNode.color && !board[i].lastNode.color) a -= i*wLocked;
				if(!board[i].firstNode.color && board[i].lastNode.color) a += (25-i);
				
			}
		}
		return a;
	}
	
	public ArrayList<Board> getChildren(Board parent,int d1,int d2,boolean clr){
		children = new ArrayList<Board>();
		if(!clr){
			if(d1 == d2){//DIPLES
				if(parent.noMoreMoves(d1)){
					return children;
				}
				for(int move1=0; move1<24; move1++){//PRWTH KINHSH
					Board child1 =new Board(parent);
					
					if( (move1 + d1 < 24) && child1.available(move1, move1 + d1)){
						child1.moveCh(move1, move1 + d1);
						child1.setValue(child1.evaluate(clr));
						children.add(child1);
						//ean exw prwth kinhsh paw na kanw thn deuterh
						for(int move2=0; move2<24; move2++){//DEUTERH KINHSH 
							if(child1.noMoreMoves(d1)){
								break;
							}
							Board child2 =new Board(child1);
							
							if( (move2 + d1 < 24) && child2.available(move2, move2 + d1)){
								child2.moveCh(move2, move2 + d1);
								child2.setValue(child2.evaluate(clr));
								children.add(child2);
								// to idio
								for(int move3=0; move3<24; move3++){//TRITH KINHSH 
									if(child2.noMoreMoves(d1)){
										break;
									}
									Board child3 =new Board(child2);
									if( (move3 + d1 < 24) && child3.available(move3, move3 + d1)){
										child3.moveCh(move3, move3 + d1);
										child3.setValue(child3.evaluate(clr));
										children.add(child3);
										//to idio
										for(int move4=0; move4<24; move4++){//TETARTH KINHSH
											if(child3.noMoreMoves(d1)){
												break;
											}
											Board child4 =new Board(child3);
											if( (move4 + d1 < 24) && child4.available(move4, move4 + d1)){
												child4.moveCh(move4, move4 + d1);
												child4.setValue(child4.evaluate(clr));
												children.add(child4);
											}
										}//TELOS TETARTHS KINHSHS
									}
								}//TELOS TRITHS KINHSHS
							}
						}//TELOS DEYTERHS KINHSHS
					}
				}//TELOS PRWTHS KINHSHS
				return children;
			}else{//kanonikh zaria
				if(parent.noMoreMoves(d1) && parent.noMoreMoves(d2)){
					return children;
				}
				for(int move1=0; move1<24; move1++){//PRWTH KINHSH
					
			}
		
													
	}
}
