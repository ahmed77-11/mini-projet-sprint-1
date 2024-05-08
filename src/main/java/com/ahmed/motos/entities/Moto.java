package com.ahmed.motos.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
public class Moto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMoto;
	
	@NotNull
	@Size (min = 4,max = 15)
	private String nomMoto;
	
	@Min(value = 10)
	@Max(value = 10000)
	private Double prixMoto;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
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
