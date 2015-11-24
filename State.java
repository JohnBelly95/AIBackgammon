public class State {
	private Board move;
	private int value;
	private State parent;
	private int[][] luck;
	private Luck chance;
	
	public State(Board move,int value){
		this.setMove(move);
		this.setValue(value);
		this.parent = null;
		luck = filluck();
		this.chance = null; 
	}
	
	public State(Board move){
		this.setMove(move);
		this.parent = null;
		luck = filluck();
		this.chance = null; 
	}
	public State(int value){
		this.value = value;
		this.parent = null;
		luck = filluck();
		this.chance = null; 
	}

	public Board getMove() {
		return move;
	}

	public void setMove(Board move) {
		this.move = move;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	private int[][] filluck(){
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
