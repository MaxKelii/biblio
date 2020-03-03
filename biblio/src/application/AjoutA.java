package application;



import java.io.IOException;

import entity.Auteur;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import entity.DaoAuteur;


public class AjoutA 
{
	private DaoAuteur daoauteur;
	private AuteurController ac;
	private Stage dialogStage;
	private Stage parent;
	
	public AjoutA()
	{
		this.daoauteur=new DaoAuteur();
	}
	
	
	public void setParentStage(Stage primari)
	{
		this.parent=primari;
	}

	
	public void ouvrefenetre(Stage parentStage)
	{ // Load person overview.
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("AjoutAuteur.fxml"));
    try 
    {
    	//AjoutA controller = loader.getController();
        //controller.setMain(this.getClass());
        
		AnchorPane auteur = (AnchorPane)FXMLLoader.load(getClass().getResource("AjoutAuteur.fxml"));
		// Give the controller access to the main app.
        
		Scene scene = new Scene(auteur,500,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        
		//Creation du stage 
		dialogStage = new Stage();
        dialogStage.setTitle("Ajout d'un auteur");
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.initOwner(parentStage);
        dialogStage.setScene(scene);
        
        // La méthode suivante montre le formulaire puis attend que l'utilisateur le ferme.
        // Fermeture effectuée dans le contrôleur du formulaire lorsque l'utilisateur clique // sur un des 2 boutons.
       
        dialogStage.showAndWait();
        
        
		
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
	
	
	
	public void initialize(){
	
	}
	
	  @FXML
	    private TextField nomF;
	    
	    @FXML
	    private TextField prenomF;
	    
	    @FXML
	    private TextField nationaliteF;
	    
	    
	    @FXML
	    private Button closeButton;
	    
	    @FXML
	    private void closeFenetre()
	    {
	    	Stage actual=(Stage)this.closeButton.getScene().getWindow();
	    	actual.close();
	    }
	    
	    @FXML
	    private void valide()
	    {
	    	if (!this.nomF.getText().isEmpty() && !this.prenomF.getText().isEmpty() && !this.nationaliteF.getText().isEmpty()) 
	    	{
				Auteur a = new Auteur(this.nomF.getText(), this.prenomF.getText(), this.nationaliteF.getText());
				daoauteur.aujoute(a);
				//refreshAuteurs();
			}
	    	else
	    	{
	    		this.nomF.setText("ho la la il n y a rien dans les cases.....");
	    	}
	    }

		

}
