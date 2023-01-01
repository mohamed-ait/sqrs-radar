package org.sid.immatriculationqueryside.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vehicule {

    @Id
    private String id;
    private String marque;

    @Column(unique = true)
    private String matricule;
    private String modele;
    private int puissance;

    @ManyToOne
    private Proprietaire proprietaire;
}