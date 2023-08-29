package com.arabsoft.stage2023.entity;

import lombok.*;

import javax.persistence.*;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id ;
    private String name;
    private String description ;
    private float prix;


}
