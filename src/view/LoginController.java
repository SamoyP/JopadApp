package view;

import java.sql.SQLException;

import application.Main;
import database.LoginDAO;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController {
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private Button aanmelden;
	
	LoginDAO database;
	
	public LoginController(){
		database = new LoginDAO();
	}
	public void checkLogin(){
		try {
			if(database.controleerLogin(username.getText(), password.getText()) == true){
				showLoginScreen();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public void showLoginScreen(){
		new HomeController().start(new Stage());
	}
}