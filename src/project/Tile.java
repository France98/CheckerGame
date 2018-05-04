package project;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle{
	
	public Tile(boolean light , int x , int y){
		setWidth(CheckerApp.TILESIZE);
        setHeight(CheckerApp.TILESIZE);
        
        relocate(x * CheckerApp.TILESIZE, y * CheckerApp.TILESIZE);
        setFill(light ? Color.valueOf("#9f2b68") : Color.valueOf("#ff033e"));
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
