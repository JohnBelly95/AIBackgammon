
public class Checker {
	int pos;
	boolean color;
	Checker nextCh;
	
	public Checker(int pos, boolean color){
		this.pos = pos;
		this.color = color;
		nextCh = null;
	}
	public boolean isBlack(){
		return color;
	}
}
