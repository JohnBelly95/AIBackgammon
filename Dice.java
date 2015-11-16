import java.util.*;
public class Dice {
	int seed,rslt;
	Random rng = new Random();
	
	public Dice(){
		
	}
	
	public int roll(){
		seed = rng.nextInt(6);
		return seed+1;
	}
}
