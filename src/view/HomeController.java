package view;

import application.Main;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HomeController extends Application {
	@FXML
	Button toevoegenDanser;
	
	public HomeController(){
	}
	public void test(){
		
	}
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/HomeView.fxml"));
			AnchorPane pane = loader.load();
			
			Scene scene = new Scene(pane);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setFullScreen(true);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void showAddDancer(){
		new DancerController().start(new Stage());
	}
}
