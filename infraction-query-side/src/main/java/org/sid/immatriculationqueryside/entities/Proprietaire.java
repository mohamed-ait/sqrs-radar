package org.sid.immatriculationqueryside.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Proprietaire {

    @Id
    private String id;
    private String nom;
    private String prenom;
    private String email;
    private String tel;
    private Date date_naissance;

    @OneToMany( mappedBy = "proprietaire")
    private List<Vehicule> vehicules = new ArrayList<>();

}