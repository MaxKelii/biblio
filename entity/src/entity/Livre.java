package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the livre database table.
 * 
 */
@Entity
@NamedQuery(name="Livre.findAll", query="SELECT l FROM Livre l")
public class Livre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int num;

	private short annee;

	private String editeur;

	private String isbn;

	private String titre;

	//bi-directional many-to-one association to Auteur
	@ManyToOne
	@JoinColumn(name="numAuteur")
	private Auteur auteur;

	public Livre() {
	}

	
	public Livre(short annee, String editeur, String isbn, String titre, Auteur auteur) {
		super();
		this.annee = annee;
		this.editeur = editeur;
		this.isbn = isbn;
		this.titre = titre;
		this.auteur = auteur;
	}


	public int getNum() {
		return this.num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public short getAnnee() {
		return this.annee;
	}

	public void setAnnee(short annee) {
		this.annee = annee;
	}

	public String getEditeur() {
		return this.editeur;
	}

	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Auteur getAuteur() {
		return this.auteur;
	}

	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}
	
	@Override
	public String toString()
	{
		return this.titre+" "+this.editeur+" "+this.annee+ " "+this.isbn;
	}

}