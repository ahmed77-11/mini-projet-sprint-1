package com.ahmed.motos;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.ahmed.motos.entities.Moto;
import com.ahmed.motos.repos.MotoRepository;
import com.ahmed.motos.service.MotoService;

@SpringBootTest
class MotosApplicationTests {

	@Autowired
	private MotoRepository motoRepository;
	@Autowired
	private MotoService motoService;
	
	@Test
	public void testCreateMoto() {
		Moto moto=new Moto("Forza",2200.2,new Date());
		motoRepository.save(moto);	
	}
	@Test
	public void findAllMotos() {
		List<Moto> motos=motoRepository.findAll();
		for(Moto m:motos) {
			System.out.println(m);
		}
	}
	@Test
	public void testFindMoto() {
		Moto m=motoRepository.findById(1L).get();
		System.out.println(m);
	}
	@Test
	public void testUpdateMoto(){
	Moto m = motoRepository.findById(1L).get();
	m.setPrixMoto(1000.0);
	motoRepository.save(m);
	}
	@Test
	public void testDeleteMoto() {
		motoRepository.deleteById(1L);
	}
	@Test
	public void testListerTousMotos() {
		List<Moto> motos=motoRepository.findAll();
		for (Moto m:motos) {
			System.out.println(m);
		}
	}
	@Test
	public void testFindByNomMotoContains()
	{
	Page<Moto> motos =motoService.getAllMotosParPage(0, 2);
	System.out.println(motos.getSize());
	System.out.println(motos.getTotalElements());
	System.out.println(motos.getTotalPages());
	motos.getContent().forEach(m -> {System.out.println(m.toString());
	 });
	/*ou bien
	for (Produit p : prods)
	{
	System.out.println(p);
	} */
	}
}
