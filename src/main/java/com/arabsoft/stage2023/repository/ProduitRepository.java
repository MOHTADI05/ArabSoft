package com.arabsoft.stage2023.repository;

import com.arabsoft.stage2023.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProduitRepository extends JpaRepository <Produit,Long>{
}
