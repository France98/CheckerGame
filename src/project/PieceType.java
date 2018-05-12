package project;

public enum PieceType {

	BLACK(1), WHITE(-1), KBLACK(2) , KWHITE(-2);
	
	final int moveD;
	
	PieceType(int moveD){
		this.moveD = moveD;
	}

}
