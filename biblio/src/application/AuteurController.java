package application;

//import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import entity.DaoAuteur;
import entity.DaoLivre;
import entity.Auteur;
import entity.Livre;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;


public class AuteurController {
	
	   	private DaoLivre daoLivre;
	    private DaoAuteur daoAuteur;
	    private Main mainapp;
	    private Stage primaire;
	    private Stage dialogStage;
	    private AjoutA aj;
	    
	   
	    
	    public AuteurController()
	    {
	    	daoAuteur = new DaoAuteur();
	        daoLivre = new DaoLivre();
	        this.AuteursView =new ListView<Auteur>();
	        this.LivresView =new ListView<Livre>();
	        this.derouleAuteurs=new ComboBox<Auteur>();
	        this.mainapp=new Main().getMainApp();
	        this.primaire = mainapp.getStage();
	        this.aj=new AjoutA();
	        
	    }
	    

	   @FXML
	    private TextField isbn;

	    @FXML
	    private TextField titre;

	    @FXML
	    private TextField editeur;

	    @FXML
	    private TextField annee;

	    @FXML
	    private ListView<Auteur> AuteursView;
	    
	    private ObservableList<Auteur> observablesAuteurs= FXCollections.observableArrayList();
	    
	    @FXML
	    private ListView<Livre> LivresView;
	    
	    private ObservableList<Livre> observablesLivres = FXCollections.observableArrayList();
	    
	    @FXML
	    private ComboBox<Auteur> derouleAuteurs ;
	    
	  

	    
	    
	   @FXML
	   private void initialize()
	   {
		   
		   observablesAuteurs= FXCollections.observableArrayList(daoAuteur.selectAll());
		   AuteursView.setItems(observablesAuteurs);
		   AuteursView.getSelectionModel().select(0);
		   
		   List<Livre> l=AuteursView.getSelectionModel().getSelectedItem().getLivres();
		   observablesLivres=FXCollections.observableArrayList(l);
		   LivresView.setItems(observablesLivres);
		   
		   derouleAuteurs.setItems(observablesAuteurs);
		   derouleAuteurs.getSelectionModel().selectFirst();
		  
	
	   }
	   
	   @FXML
	   private void refresh()
	   {
		   observablesAuteurs= FXCollections.observableArrayList(daoAuteur.selectAll());
		   AuteursView.setItems(observablesAuteurs);
		   List<Livre> l=AuteursView.getSelectionModel().getSelectedItem().getLivres();
		   observablesLivres=FXCollections.observableArrayList(l);
		   LivresView.setItems(observablesLivres);
	   }
	   
	   private void refresh(int index)
	   {
		   observablesAuteurs= FXCollections.observableArrayList(daoAuteur.selectAll());
		   AuteursView.setItems(observablesAuteurs);
		   AuteursView.getSelectionModel().select(index);
		   
		   List<Livre> l=AuteursView.getSelectionModel().getSelectedItem().getLivres();
		   observablesLivres=FXCollections.observableArrayList(l);
		   LivresView.setItems(observablesLivres);
	   }
	    
	    @FXML
	    public void refreshAuteurs()
	    {
	       this.AuteursView.getItems().clear();
	       	List<Auteur>la=	daoAuteur.selectAll();
	      for(Auteur e : la)
	    	  this.AuteursView.getItems().add(e);
	    }
	    

	
	    private void refreshLivres()
	    {
	        this.LivresView.getItems().clear();
	        observablesAuteurs= FXCollections.observableArrayList(daoAuteur.selectAll());
	        
	        List<Livre>l =daoLivre.selectAll();
	        for(Livre li :l)
	        	this.LivresView.getItems().add(li);
	    }

	    @FXML
	    private void ajouteAuteur()
	    {
	    	
	    	aj.ouvrefenetre(primaire);

	    } 

	    @FXML
	    private void ajouteLivre()
	    {
	    	if(!this.isbn.getText().isEmpty() && !this.titre.getText().isEmpty() && !this.editeur.getText().isEmpty() && !this.annee.getText().isEmpty())
	    	{
	    		String _isbn=this.isbn.getText();
	    		String _titre=this.titre.getText();
	    		String _editeur=this.editeur.getText();
	    		short __annee=Short.parseShort(this.annee.getText());
	    		
	    		Auteur a= this.derouleAuteurs.getSelectionModel().getSelectedItem();
	    		

	    		Livre l= new Livre(__annee,_editeur,_isbn,_titre,a);
	    		Livre lr= a.addLivre(l);
	    		this.daoLivre.ajouter(l);
	    		refresh();
	    		this.AuteursView.getSelectionModel().select(a);
	    	}
	    	
	    }

	    @FXML
	    private void supprimeLivre()
	    {
	        Livre l = this.LivresView.getSelectionModel().getSelectedItem();
	        Auteur a= this.AuteursView.getSelectionModel().getSelectedItem();
	        Livre lr = a.removeLivre(l);
	        daoLivre.delete(l);
	        refresh();
	        
	    }

}
