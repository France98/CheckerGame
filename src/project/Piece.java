package project;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

/**
 * Create piece
 * @author Phanuwatch Luangpradit
 *
 */
public class Piece extends StackPane {

    private PieceType type;

    private double mouseX, mouseY;
    private double oldX, oldY;
    boolean isKing = false;

    /**
     * Get type of piece
     * @return type of piece
     */
    public PieceType getType() {
        return type;
    }
    
    /**
     * Tell that piece is king or not
     * @return false if it's not a king
     */
    public boolean isKing(){
    	return isKing;
    }

    /**
     * Get old x position
     */
    public double getOldX() {
        return oldX;
    }

    /**
     * Get old y position
     */
    public double getOldY() {
        return oldY;
    }

    /**
     * Constructor that create the UI
     * @param type
     * @param x
     * @param y
     */
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

    /**
     * Move piece
     * @param x
     * @param y
     */
    public void move(int x, int y) {
        oldX = x * 100;
        oldY = y * 100;
        relocate(oldX, oldY);
    }
    
    /**
     * Change the normal piece to King piece
     */
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

    /**
     * back to old X and Y pposition
     */
    public void abortMove() {
        relocate(oldX, oldY);
    }
}
