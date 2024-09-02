package com.microservices.descovery.service;


import com.microservices.descovery.exception.ProjetNotFoundException;
import com.microservices.descovery.model.Projet;
import com.microservices.descovery.repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetService {
    @Autowired
    private ProjetRepository projetRepository;

    public void addProjet(Projet projet){
        projetRepository.save(projet);
    }

    public Projet getProjet(Long idProjet) {

        Projet projet = projetRepository
                .findById(idProjet)
                .orElseThrow(ProjetNotFoundException::new);
        return projet;
    }

    public List<Projet> getAllProjets() {
        return projetRepository.findAll();
    }

    public void updateProjet(int idProjet, Projet projet) {
        projetRepository
                .findById((long) idProjet)
                .orElseThrow(ProjetNotFoundException::new);

        projet.setIdProjet(idProjet);

        projetRepository.save(projet);
    }

    public void deleteProjet(Long idProjet) {
        Projet projetSupprime = projetRepository
                .findById(idProjet)
                .orElseThrow(ProjetNotFoundException::new);

        projetRepository.delete(projetSupprime);
    }
}
