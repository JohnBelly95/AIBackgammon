public class Board {
	Checker token=null;
	Stack[] board;
	int wLocked,wDoor,wAlone,moves;
	int value;
	
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
}
