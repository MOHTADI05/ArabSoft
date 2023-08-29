package com.arabsoft.stage2023.service;

import com.arabsoft.stage2023.entity.Produit;
import com.arabsoft.stage2023.repository.ProduitRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
    public class ProduitService {
    private ProduitRepository produitRepository;
    public List<Produit> getProduit(){
         return produitRepository.findAll();
    }
    public Optional<Produit> getProduitById(Long id){
        return produitRepository.findById(id);
    }
    public Produit save(Produit produit){
        //https://www.baeldong.com/spring-datajpa-save-saveandflush
        return produitRepository.saveAndFlush(produit);
    }


    public boolean existsById(Long id) {
        return produitRepository.existsById(id);
    }

    public void deleteProduit(Long id){
        produitRepository.deleteById(id);
    }


}
