package org.sid.radarquerysid.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.sid.radarquerysid.entities.Radar;
import org.sid.radarquerysid.repositories.RadarRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class RadarEventHandlerService {

    private RadarRepository radarRepository;


    @EventHandler
    public void on(RadarCreatedEvent event){
        Radar radar = new Radar(
                event.getId(),
                event.getLatitude(),
                event.getLongitude(),
                event.getVitesse_max()
        );
        radarRepository.save(radar);
        log.info(" Radar persisted  ");
    }

    @EventHandler
    public void on( RadarUpdatedEvent event){
        Radar radar = repository.findById(event.getId()).get();
        radar.setLatitude(event.getLatitude());
        radar.setLongitude(event.getLongitude());
        radar.setVitesse_max(event.getVitesse_max());
        radarRepository.save(radar);
        log.info(" Radar updated ");
    }


    @EventHandler
    public void on( RadarDeletedEvent event){
        radarRepository.deleteById(event.getId());
        log.info("Radar deleted !");
    }

}