package project;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle{
	
	public static final int TILESIZE = 100;
	
	public Tile(boolean light , int x , int y){
		setWidth(100);
        setHeight(100);
        
        relocate(x * TILESIZE, y * TILESIZE);
        setFill(light ? Color.valueOf("#F8C471") : Color.valueOf("#DC7633"));
	}
	
	
	private Piece piece;

	public void setPiece(Piece piece){
		this.piece = piece;
	}
	
	public boolean hasPiece(){
		return piece != null;
	}
	
	public Piece getPiece(){
		return this.piece;
	}
	
	
}
