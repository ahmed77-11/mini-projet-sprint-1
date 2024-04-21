package com.ahmed.motos.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahmed.motos.entities.Moto;

public interface MotoRepository extends JpaRepository<Moto, Long> {

}
