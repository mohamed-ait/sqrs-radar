package org.sid.radarquerysid.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Radar {

    @Id
    private String id ;

    private Float latitude;
    private Float longitude;
    private Float vitesse_max;

}