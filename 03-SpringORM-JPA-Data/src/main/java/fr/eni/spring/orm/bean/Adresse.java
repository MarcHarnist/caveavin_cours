package fr.eni.spring.orm.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SpringDataAdresses")
public class Adresse {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String codePostal;
	private String ville;
	
	
	
	public Adresse() {
	}
	public Adresse(String codePostal, String ville) {
		this.codePostal = codePostal;
		this.ville = ville;
	}
	public Adresse(int id, String codePostal, String ville) {
		this.id = id;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	@Override
	public String toString() {
		return "Adresse [id=" + id + ", codePostal=" + codePostal + ", ville=" + ville + "]";
	}
	
	
}
