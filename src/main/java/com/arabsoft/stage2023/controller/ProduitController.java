package com.arabsoft.stage2023.controller;

import com.arabsoft.stage2023.entity.Produit;
import com.arabsoft.stage2023.service.ProduitService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
@RequestMapping("/api/v1")
public class ProduitController {
    private ProduitService produitService;

    @GetMapping("/produit")
    public List<Produit> getProduit() {
        return produitService.getProduit();

    }

    @GetMapping("/produit/{id}")
    public Produit getProduit(@PathVariable Long id) {
        return produitService.getProduitById(id).orElseThrow(
                () -> new EntityNotFoundException("produit exist pas")
        );
    }

    @PostMapping("/produit")
    public Produit addProduit(@RequestBody Produit produit) {
        return produitService.save(produit);
    }

    @PutMapping("/produit/{id}")
    public ResponseEntity<?> addProduit(@RequestBody Produit produit, @PathVariable Long id) {
        if (produitService.existsById(id)) {
            Produit produit1 = produitService.getProduitById(id).orElseThrow(
                    () -> new EntityNotFoundException(" found produit")
            );
            produit1.setDescription(produit.getDescription());
            produit1.setName(produit.getName());
            produit1.setPrix(produit.getPrix());

            return ResponseEntity.ok().body(produit);
        } else {
            HashMap<String, String> message = new HashMap<>();
            message.put("message", id + "produit not found or matched");

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);


        }


    }


    @DeleteMapping("produit/{id}")
    public ResponseEntity<?> deleteProduit(@PathVariable Long id) {
        // Check if the product with the given id exists in the database
        if (produitService.existsById(id)) {
            produitService.deleteProduit(id);
            HashMap<String ,String> message = new HashMap<>();
            message.put("message","produit with id" + id+"delete successfully.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
        else
         {
             HashMap<String ,String> message = new HashMap<>();
             message.put("message", id+"product  not found.");
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }


}





