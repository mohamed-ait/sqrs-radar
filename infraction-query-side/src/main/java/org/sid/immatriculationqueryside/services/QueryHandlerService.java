package org.sid.immatriculationqueryside.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.sid.immatriculationqueryside.entities.Proprietaire;
import org.sid.immatriculationqueryside.entities.Vehicule;
import org.sid.immatriculationqueryside.repositories.ProprietaireRepository;
import org.sid.immatriculationqueryside.repositories.VehiculeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class QueryHandlerService {

    private ProprietaireRepository proprietaireRepository;
    private VehiculeRepository vehiculeRepository;


    @QueryHandler
    public List<Proprietaire> on(GetAllProprietairesQuery query){
        return proprietaireRepository.findAll();
    }

    @QueryHandler
    public List<Vehicule> on(GetAllVehiculesQuery query){
        List<Vehicule> list = vehiculeRepository.findAll();
        return list;
    }

    @QueryHandler
    public Vehicule on(GetVehiculeById query){
        return vehiculeRepository.findById(query.getId()).get();
    }

    @QueryHandler
    public Proprietaire on(GetProprietaireById query){
        return proprietaireRepository.findById(query.getId()).get();
    }

}