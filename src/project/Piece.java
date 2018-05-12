package project;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class Piece extends StackPane {

    private PieceType type;

    private double mouseX, mouseY;
    private double oldX, oldY;
    boolean isKing = false;

    public PieceType getType() {
        return type;
    }
    
    public boolean isKing(){
    	return isKing;
    }

    public double getOldX() {
        return oldX;
    }

    public double getOldY() {
        return oldY;
    }

    public Piece(PieceType type, int x, int y) {
        this.type = type;
        move(x, y);

        Ellipse ellipse = new Ellipse(100 * 0.3125, 100 * 0.26);
        ellipse.setFill(type == PieceType.BLACK
                ? Color.valueOf("#808080"): Color.valueOf("#fff9f4"));

        ellipse.setStroke(Color.BLACK);
        ellipse.setStrokeWidth(100 * 0.03);

        ellipse.setTranslateX((100 - 100 * 0.3125 * 2) / 2);
        ellipse.setTranslateY((100 - 100 * 0.26 * 2) / 2);

        getChildren().addAll(ellipse);
      

        setOnMousePressed(e -> {
            mouseX = e.getSceneX();
            mouseY = e.getSceneY();
        });

        setOnMouseDragged(e -> {
            relocate(e.getSceneX() - mouseX + oldX, e.getSceneY() - mouseY + oldY);
        });
    }

    public void move(int x, int y) {
        oldX = x * 100;
        oldY = y * 100;
        relocate(oldX, oldY);
    }
    
    public void setKing(){
    	getChildren().removeAll();

        Ellipse ellipse = new Ellipse(100 * 0.3125, 100 * 0.26);
        ellipse.setFill(type == PieceType.BLACK
                ? Color.valueOf("#000000"): Color.valueOf("#aaf9f4"));

        ellipse.setStroke(Color.BLACK);
        ellipse.setStrokeWidth(100 * 0.03);

        ellipse.setTranslateX((100 - 100 * 0.3125 * 2) / 2);
        ellipse.setTranslateY((100 - 100 * 0.26 * 2) / 2);
        
        getChildren().addAll(ellipse);
        isKing = true;
        
        setOnMousePressed(e -> {
            mouseX = e.getSceneX();
            mouseY = e.getSceneY();
        });

        setOnMouseDragged(e -> {
            relocate(e.getSceneX() - mouseX + oldX, e.getSceneY() - mouseY + oldY);
        });
    }

    public void abortMove() {
        relocate(oldX, oldY);
    }
}
