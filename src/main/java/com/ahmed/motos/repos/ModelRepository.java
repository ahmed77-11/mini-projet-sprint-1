package com.ahmed.motos.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahmed.motos.entities.Model;

public interface ModelRepository extends JpaRepository<Model,Long> {

}
