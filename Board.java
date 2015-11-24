
public class Board {
	Checker token=null;
	Stack[] board;
	
	public Board(){
		board =new Stack[24];
		populate(board);
	}
	public Board(Board b){
		this.board = b.board;
	}
	public void populate(Stack[] board){
		Checker whiteToken = new Checker(1,false);
		Checker blackToken = new Checker(24,true);
		Stack st = new Stack();
		for(int i=0; i<24 ;i++){
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
}
