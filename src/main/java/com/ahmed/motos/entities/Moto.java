package com.ahmed.motos.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
public class Moto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMoto;
	private String nomMoto;
	private Double prixMoto;
	private Date dateCreation;
	
	@ManyToOne
	private Model model;
	public Moto() {
		super();
	}
	
	public Moto(String nomMoto, Double prixMoto, Date dateCreation) {
		super();
		this.nomMoto = nomMoto;
		this.prixMoto = prixMoto;
		this.dateCreation = dateCreation;
	}

	public Long getIdMoto() {
		return idMoto;
	}
	public void setIdMoto(Long idMoto) {
		this.idMoto = idMoto;
	}
	public String getNomMoto() {
		return nomMoto;
	}
	public void setNomMoto(String nomMoto) {
		this.nomMoto = nomMoto;
	}
	public Double getPrixMoto() {
		return prixMoto;
	}
	public void setPrixMoto(Double prixMoto) {
		this.prixMoto = prixMoto;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Moto [idMoto=" + idMoto + ", nomMoto=" + nomMoto + ", prixMoto=" + prixMoto + ", dateCreation="
				+ dateCreation + "]";
	}
	
	
	
}
