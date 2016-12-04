package view;

import java.sql.SQLException;
import java.time.ZoneId;
import java.util.Date;

import application.Main;
import database.DancerDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Dancer;

public class DancerController {
	private DancerDAO database;
	@FXML
	private TextField voornaam;
	@FXML
	private TextField achternaam;
	@FXML
	private ComboBox groep;
	@FXML
	private TextField adres;
	@FXML
	private TextField postcode;
	@FXML
	private TextField gemeente;
	@FXML
	private TextField email;
	@FXML
	private TextField telefoon;
	@FXML
	private DatePicker geboortedatum;
	ObservableList<String> geslachten = FXCollections.observableArrayList("","M","V");
	@FXML
	private ComboBox<String> geslacht = new ComboBox<String>(geslachten);
	@FXML
	private Button toevoegenLid;
	
	public DancerController(){
		database = new DancerDAO();
	}
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/AddDancer.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene(pane);
			
			geslacht.getItems().addAll("", "M", "V");
			
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setFullScreen(true);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void addDancer(){
		Date date = Date.from(geboortedatum.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		java.sql.Date dateSql = (java.sql.Date)date;
		try {
			database.addDancer(new Dancer(voornaam.getText(), achternaam.getText(), adres.getText(), Integer.parseInt(postcode.getText()), gemeente.getText(), email.getText(), telefoon.getText(),  dateSql, geslacht.getValue().toString()));
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
