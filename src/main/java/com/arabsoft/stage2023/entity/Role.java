package com.arabsoft.stage2023.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {
    class User implements Serializable {
        @Id
        @GeneratedValue(strategy =
                GenerationType.AUTO)
        private int id;
        @Enumerated(EnumType.STRING)
        private RoleName role;
    }



}