
public class Checker {
	int pos;
	boolean color;
	
	public Checker(int pos, boolean color){
		this.pos = pos;
		this.color = color;
	}
	public boolean isBlack(){
		return color;
	}
}
