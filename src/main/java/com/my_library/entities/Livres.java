package com.my_library.entities;

import java.util.Date;

import com.my_library.Enum.StatutLivre;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Livres {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String titre;
	
	private String auteur;
	
	private String ISBN;
	
	private String category;
	
	private int nbExemplaires;
	
	private Date datePub;
	
	private String localisation;
	
	@Enumerated(EnumType.STRING)
	private StatutLivre statutliv;
	
	
	//getters and setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getNbExemplaires() {
		return nbExemplaires;
	}

	public void setNbExemplaires(int nbExemplaires) {
		this.nbExemplaires = nbExemplaires;
	}

	public Date getDatePub() {
		return datePub;
	}

	public void setDatePub(Date datePub) {
		this.datePub = datePub;
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public StatutLivre getStatutliv() {
		return statutliv;
	}

	public void setStatutliv(StatutLivre statutliv) {
		this.statutliv = statutliv;
	}

	/**
	 * @param id
	 * @param titre
	 * @param auteur
	 * @param iSBN
	 * @param category
	 * @param nbExemplaires
	 * @param datePub
	 * @param localisation
	 * @param statutliv
	 */
	public Livres(int id, String titre, String auteur, String iSBN, String category, int nbExemplaires, Date datePub,
			String localisation, StatutLivre statutliv) {
		super();
		this.id = id;
		this.titre = titre;
		this.auteur = auteur;
		this.ISBN = iSBN;
		this.category = category;
		this.nbExemplaires = nbExemplaires;
		this.datePub = datePub;
		this.localisation = localisation;
		this.statutliv = statutliv;
	}

	/**
	 * 
	 */
	public Livres() {}

	

}
