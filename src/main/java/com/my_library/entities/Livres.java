package com.my_library.entities;

import java.util.Date;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.my_library.Enum.StatutLivre;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Livres {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotEmpty(message = "Titre est obligatoire")
    @Column(name = "titre")
	private String titre;
	
	@NotEmpty(message = "Nom auteur est obligatoire")
    @Column(name = "Auteur")
	private String auteur;
	
	@NotEmpty(message = "IBSN est obligatoire")
    @Column(name = "IBSN", unique = true)
	private String ISBN;
	
	@NotEmpty(message = "category est obligatoire")
    @Column(name = "category")
	private String category;
	
	@NotEmpty(message = "nombre des Exemplaires est obligatoire")
    @Column(name = "nombre des Exemplaires")
	private int nbExemplaires;
	
	@NotEmpty(message = "date de Publication est obligatoire")
    @Column(name = "date de Publication")
	private Date datePub;
	
	@NotEmpty(message = "localisation est obligatoire")
    @Column(name = "localisation", unique = true)
	private String localisation;
	
	@NotEmpty(message = "Statut de livre est obligatoire")
	@Column(name = "Statut de livre")
	@Enumerated(EnumType.STRING)
	private StatutLivre statutliv;
	
	
	//getters and setters

	public long getId() {
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
	
	@ManyToOne( fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
		

}
