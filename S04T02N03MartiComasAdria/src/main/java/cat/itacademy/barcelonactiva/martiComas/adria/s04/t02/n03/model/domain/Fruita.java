package cat.itacademy.barcelonactiva.martiComas.adria.s04.t02.n03.model.domain;

import javax.persistence.*;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "Fruies")
public class Fruita {


	@Id
	private Long id;
	private String nom;
	private int quantitatQuilos;

	public Fruita() {
	}

	public Fruita(String nom, int quantitatQuilos) {
		this.nom = nom;
		this.quantitatQuilos = quantitatQuilos;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getQuantitatQuilos() {
		return quantitatQuilos;
	}

	public void setQuantitatQuilos(int quantitatQuilos) {
		this.quantitatQuilos = quantitatQuilos;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Fruita [id=" + id + ", nom=" + nom + ", quantitatQuilos=" + quantitatQuilos + "]";
	}

}