package com.ahmed.motos.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ahmed.motos.entities.Model;
import com.ahmed.motos.entities.Moto;

public interface MotoService {
	Moto saveMoto(Moto m);
	Moto updateMoto(Moto m);
	void deleteMoto(Moto m);
	void deleteMotoById(Long id);
	Moto getMoto(Long id);
	List<Moto> getAllMotos();
	Page<Moto> getAllMotosParPage(int page,int size);
	List<Moto> findByNomMoto(String nom);
	List<Moto> findByNomMotoContains(String nom);
	List<Moto> findByNomPrix(String nom,Double prix);
	List<Moto> findByModel(Model model);
	List<Moto> findByModelIdMod(Long id);
	List<Moto> findByOrderByNomMotoAsc();
	List<Moto> trierMotosNomsPrix();
	
	
}
