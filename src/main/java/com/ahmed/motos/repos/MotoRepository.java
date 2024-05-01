package com.ahmed.motos.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ahmed.motos.entities.Model;
import com.ahmed.motos.entities.Moto;

@RepositoryRestResource(path="rest")
public interface MotoRepository extends JpaRepository<Moto, Long> {
	List<Moto> findByNomMoto(String Nom);
	List<Moto> findByNomMotoContains(String nom);
	
	
	@Query("select m from Moto m where m.nomMoto like %?1 and m.prixMoto > ?2")
	List<Moto> findByNomPrix(String nom,Double prix);
	
	/*
	 * @Query("select m from Moto m where m.nomMoto like %:nom and m.prixMoto > :prix"
	 * ) List<Moto> findByNomPrix (@Param("nom") String nom,@Param("prix") Double
	 * prix);
	 */
	
	@Query("Select m from Moto m where m.model=?1")
	List<Moto> findByModel(Model model);
	
	List<Moto> findByModelIdModel(Long id);
	List<Moto> findByOrderByNomMotoAsc();
	
	@Query("Select m from Moto m order by m.nomMoto ASC,m.prixMoto DESC")
	List<Moto> trierMotosNomsPrix();
}

