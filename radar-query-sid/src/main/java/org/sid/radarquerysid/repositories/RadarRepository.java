package org.sid.radarquerysid.repositories;

import org.sid.radarquerysid.entities.Radar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RadarRepository extends JpaRepository<Radar, String> {
}
