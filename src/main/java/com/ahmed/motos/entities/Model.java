package com.ahmed.motos.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Model {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long idModel;
	
	
	 private String nomModel;
	 private String descriptionModel;
	 
	 @JsonIgnore
	 @JsonManagedReference
	 @OneToMany(mappedBy = "model")
	 private List<Moto> motos;
	 
	 
	 
	 

}
