package project;


/**
 * Type of piece
 * @author Phanuwatch Luangpradit
 *
 */
public enum PieceType {

	BLACK(1), WHITE(-1);
	
	final int moveD;
	
	PieceType(int moveD){
		this.moveD = moveD;
	}

}
