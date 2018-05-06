package project;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class Piece extends StackPane{

	private PieceType type;
	
	public PieceType getType(){
		return this.type;
	}
	
	public Piece(PieceType type , int x , int y) {
		this.type = type;
		
		relocate(x * CheckerApp.TILESIZE , y * CheckerApp.TILESIZE);
		
		Ellipse e = new Ellipse(CheckerApp.TILESIZE * 0.3125, CheckerApp.TILESIZE * 0.26);
		
		e.setFill(type == PieceType.Black ?  Color.valueOf("#000000") : Color.valueOf("fff9f4"));
		e.setStroke(Color.GRAY);
		e.setStrokeWidth(CheckerApp.TILESIZE * 0.03);
		
		e.setTranslateX((CheckerApp.TILESIZE - CheckerApp.TILESIZE * 0.3125 * 2) / 2);
		e.setTranslateY((CheckerApp.TILESIZE - CheckerApp.TILESIZE * 0.26 * 2) / 2);
		
		
		
		getChildren().addAll(e);
		
	}
	
}
