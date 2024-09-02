package com.microservices.descovery.controller;


import com.microservices.descovery.model.Projet;
import com.microservices.descovery.service.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projets")
public class ProjectController {

    @Autowired
    private ProjetService projetService;

    @PostMapping("/add")
    public ResponseEntity<String> ajouterProjet(@RequestBody Projet projet){
        try {
            projetService.addProjet(projet);
            return ResponseEntity.status(HttpStatus.CREATED).body("created successfully");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("not created" + e.getMessage());
        }
    }

    @GetMapping("/")
    public List<Projet> getAllProjets() {
        return projetService.getAllProjets();
    }

    @GetMapping("/idprojet")
    public ResponseEntity<?> showsProjetById(@RequestParam Long idprojet) {
        try {
            Projet projet = projetService.getProjet(idprojet);
            return ResponseEntity.ok(projet);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving project: " + e.getMessage());
        }
    }


    @PutMapping("/update/{idprojet}")
    public ResponseEntity<?> modifierProjet(@PathVariable int idprojet, @RequestBody Projet projet){
        try {
            projetService.updateProjet(idprojet, projet);
            return ResponseEntity.ok("updated successfully");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ErroR NO PRODUCT WITH THIS ID AVAILABLE : " + e.getMessage());

        }

    }

    @DeleteMapping("/delete/{idprojet}")
    public ResponseEntity<?>  supprimerProjet(@PathVariable Long  idprojet){
        try {
            projetService.deleteProjet(idprojet);
            return ResponseEntity.ok("delete successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting project: " + e.getMessage());
        }
    }
}
