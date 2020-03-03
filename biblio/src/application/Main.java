package application;
	
import java.io.IOException;

import entity.Auteur;
import entity.DaoAuteur;
import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application 
{
	
	private Stage primaryStage;
	public Stage getStage()
	{
		return this.primaryStage;
	}
	
	public Main getMainApp()
	{
		return this;
	}
	
	@Override
	public void start(Stage primaryStage) {
		try 
		{
			this.primaryStage=primaryStage;
			FXMLLoader loader = new FXMLLoader();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root,621,650);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
