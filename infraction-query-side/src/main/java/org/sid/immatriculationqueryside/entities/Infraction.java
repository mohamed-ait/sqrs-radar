package org.sid.immatriculationqueryside.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Infraction {

    @Id
    private String id;

    private String matricule;
    private Float maxVitesse;
    private Double montant;
    private Float vitesse;
    private Date date;


}