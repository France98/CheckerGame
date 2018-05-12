package project;

public class MoveResult {

	private MoveType type;
	
	private Piece piece;
	
	public MoveResult(MoveType type) {
		this(type,null);
	}
	
	public MoveResult(MoveType type, Piece piece) {
		this.type = type;
		this.piece = piece;
	}
	
	public MoveType getType(){
		return this.type;
	}
	
	public Piece getPiece(){
		return this.piece;
	}
}
