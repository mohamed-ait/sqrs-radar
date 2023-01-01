package org.sid.immatriculationqueryside.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.sid.immatriculationqueryside.entities.Infraction;
import org.sid.immatriculationqueryside.repositories.InfractionRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class QueryHandlerService {

    private ProprietaireRepository proprietaireRepository;
    private InfractionRepository vehiculeRepository;


    @QueryHandler
    public List<Proprietaire> on(GetAllProprietairesQuery query){
        return proprietaireRepository.findAll();
    }

    @QueryHandler
    public List<Infraction> on(GetAllVehiculesQuery query){
        List<Infraction> list = vehiculeRepository.findAll();
        return list;
    }

    @QueryHandler
    public Infraction on(GetVehiculeById query){
        return vehiculeRepository.findById(query.getId()).get();
    }

    @QueryHandler
    public Proprietaire on(GetProprietaireById query){
        return proprietaireRepository.findById(query.getId()).get();
    }

}