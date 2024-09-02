package com.microservices.descovery.repository;

import com.microservices.descovery.model.Ressource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RessourceRepository extends JpaRepository<Ressource, Long> {
    List<Ressource> findByIdTache(int idTache);
}
