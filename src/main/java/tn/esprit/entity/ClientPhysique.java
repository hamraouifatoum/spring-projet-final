package tn.esprit.entity;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@DiscriminatorValue("PHYSIQUE")
public class ClientPhysique extends Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(unique=true)
	private Long cin;

	@Column(unique=true)
	private String numPasseport;

	private String nom;

	private String prenom;

	@Temporal(TemporalType.DATE)
	private Date dateNaissance;

	@Enumerated(EnumType.STRING)
	private Genre genre;

	private String etatCivil;

	private String profession;

	public ClientPhysique() {
		super();
	}

	public ClientPhysique(int telephone, int fax, String adresseEmail, String adresse) {
		super(telephone, fax, adresseEmail, adresse);
	}

	public Long getCin() {
		return cin;
	}

	public void setCin(Long cin) {
		this.cin = cin;
	}

	public String getNumPasseport() {
		return numPasseport;
	}

	public void setNumPasseport(String numPasseport) {
		this.numPasseport = numPasseport;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public String getEtatCivil() {
		return etatCivil;
	}

	public void setEtatCivil(String etatCivil) {
		this.etatCivil = etatCivil;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	@Override
	public String toString() {
		return super.toString()+" ClientPhysique [cin=" + cin + ", numPasseport=" + numPasseport + ", nom=" + nom + ", prenom=" + prenom
				+ ", dateNaissance=" + dateNaissance + ", genre=" + genre + ", etatCivil=" + etatCivil + ", profession="
				+ profession + "]";
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
