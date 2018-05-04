package project;

public enum PieceType {

	Black(1) , White(-1) ,KingB(1) , KingW(-1);
	
	private final int MOVE;
	
	PieceType(int move){
		this.MOVE = move;
	}

}
