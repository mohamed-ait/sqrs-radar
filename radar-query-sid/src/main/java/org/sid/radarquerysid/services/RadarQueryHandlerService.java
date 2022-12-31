package org.sid.radarquerysid.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.sid.radarquerysid.entities.Radar;
import org.sid.radarquerysid.repositories.RadarRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class RadarQueryHandlerService {

    private RadarRepository radarRepository;


    @QueryHandler
    public List<Radar> on(GetAllRadarsQuery query){
        return radarRepository.findAll();
    }

    @QueryHandler
    public Radar on( GetRadarById query){
        return radarRepository.findById(query.getId()).get();
    }



}