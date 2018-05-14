package project;

/**
 * This class tell that what piece can move
 * @author Phanuwatch Luangpradit
 *
 */
public class MoveResult {

	private MoveType type;
	
	private Piece piece;
	
	/**
	 * Constructor
	 * @param type
	 */
	public MoveResult(MoveType type) {
		this(type,null);
	}
	
	/**
	 * Constructor
	 * @param type
	 * @param piece
	 */
	public MoveResult(MoveType type, Piece piece) {
		this.type = type;
		this.piece = piece;
	}
	
	/**
	 * Get the type of move
	 * @return type of move
	 */
	public MoveType getType(){
		return this.type;
	}
	
	/**
	 * Get the piece
	 * @return piece
	 */
	public Piece getPiece(){
		return this.piece;
	}
}
