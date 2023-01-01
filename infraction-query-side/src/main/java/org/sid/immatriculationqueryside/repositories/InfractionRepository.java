package org.sid.immatriculationqueryside.repositories;

import org.sid.immatriculationqueryside.entities.Infraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfractionRepository extends JpaRepository<Infraction, String> {

}