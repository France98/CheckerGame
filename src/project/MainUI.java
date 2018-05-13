package project;

import java.io.File;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainUI extends Application {

	private Stage window;
	private Scene scene1, scene2;
	private CheckerApp checker;
	

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		checker = new CheckerApp();
		window = primaryStage;
		
		
		Label label1 = new Label("Welcome to Checker Game");
		label1.setPrefWidth(500);
		label1.setFont(new Font("Arial", 40));
		label1.setAlignment(Pos.CENTER);
		Button button1 = new Button("Start Game");
		button1.setPrefSize(200, 100);
		button1.setOnAction(e -> window.setScene(scene2));
		Image image1 = new Image(new File("C:\\Users\\France98\\workspace\\FinalProject\\src\\project\\Capture.PNG").toURI().toURL().toExternalForm());
		
		
		VBox layout1 = new VBox();
		layout1.setAlignment(Pos.CENTER);
		ImageView selectedImage = new ImageView();
		selectedImage.setImage(image1);
		layout1.getChildren().addAll(label1,selectedImage,button1);
		scene1 = new Scene(layout1,500,600);
		
		scene2 = new Scene(checker.createContent());
		window.setScene(scene1);
		window.setTitle("Checker Game");
		window.show();
		
	}

}
