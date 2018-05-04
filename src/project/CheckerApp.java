package project;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CheckerApp extends Application{
	
	public static final int WIDTH = 8;
	public static final int HEIGHT = 8;
	public static final int TILESIZE = 100;
	
	private Tile[][] board = new Tile[WIDTH][HEIGHT];

    private Group tileGroup = new Group();
    private Group pieceGroup = new Group();
	
	private Parent createContent() {
		Pane root = new Pane();
		root.setPrefSize(WIDTH * TILESIZE , HEIGHT * TILESIZE);
		root.getChildren().addAll(tileGroup, pieceGroup);
		
		for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                Tile tile = new Tile((x + y) % 2 == 0, x, y);
                board[x][y] = tile;

                tileGroup.getChildren().add(tile);
            }
        }
		
		
		return root;
	}

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene scene = new Scene(createContent());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Checker");
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}
