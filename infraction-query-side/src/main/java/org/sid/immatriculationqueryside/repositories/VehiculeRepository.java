package org.sid.immatriculationqueryside.repositories;

import org.sid.immatriculationqueryside.entities.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule, String> {

}