package com.arabsoft.stage2023.repository;

import com.arabsoft.stage2023.entity.Operateur;
import com.arabsoft.stage2023.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OperateurRepository extends CrudRepository<Operateur, Long> {
    Optional<Operateur> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
