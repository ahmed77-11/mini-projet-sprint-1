package com.ahmed.motos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ahmed.motos.entities.Moto;
import com.ahmed.motos.repos.MotoRepository;

@Service
public class MotoServiceImpl implements MotoService {
	
	@Autowired
	MotoRepository motoRepository;

	@Override
	public Moto saveMoto(Moto m) {
		return motoRepository.save(m);
	}

	@Override
	public Moto updateMoto(Moto m) {
		return motoRepository.save(m);
	}

	@Override
	public void deleteMoto(Moto m) {
		motoRepository.delete(m);
	}

	@Override
	public void deleteMotoById(Long id) {
		motoRepository.deleteById(id);

	}

	@Override
	public Moto getMoto(Long id) {
		return motoRepository.findById(id).get();
	}

	@Override
	public List<Moto> getAllMotos() {
		return motoRepository.findAll();
	}
	@Override
	public Page<Moto> getAllMotosParPage(int page,int size){
		return motoRepository.findAll(PageRequest.of(page, size));
		
	}

}
