package org.sid.immatriculationqueryside.repositories;

import org.sid.immatriculationqueryside.entities.Proprietaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProprietaireRepository extends JpaRepository<Proprietaire, String> {
}
