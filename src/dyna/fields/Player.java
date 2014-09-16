package dyna.fields;

public class Player extends Ground {
	
	private String name;
	private int score;
	
	public Player(String name, int score, int x, int y){
		super(x,y);
		this.name = name;
		this.score = score;
		
	}
	
	
	
}
