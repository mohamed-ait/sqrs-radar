package org.sid.immatriculationqueryside.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.sid.immatriculationqueryside.entities.Vehicule;
import org.sid.immatriculationqueryside.repositories.ProprietaireRepository;
import org.sid.immatriculationqueryside.repositories.VehiculeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class EventHandlerService {

    private ProprietaireRepository proprietaireRepository;
    private VehiculeRepository vehiculeRepository;


    @EventHandler
    public void hanlder(VehiculeCreatedEvent event){
        Vehicule vehicule = new Vehicule(
                event.getId(),
                event.getMarque(),
                event.getMatricule(),
                event.getModele(),
                event.getPuissance() ,
                null
        );
        vehiculeRepository.save(vehicule);
        log.info("Vehicule created  ");
    }

    @EventHandler
    public void hanlder(VehiculeUpdatedEvent event){
        Vehicule vehicule = vehiculeRepository.findById(event.getId()).get();
        vehicule.setMarque( event.getMarque() );
        vehicule.setMatricule( event.getMatricule() );
        vehicule.setModele( event.getModele() );
        vehicule.setPuissance( event.getPuissance() );
        vehiculeRepository.save(vehicule);
        log.info("Vehicule updated  ");
    }

    @EventHandler
    public void hanlder(VehiculeDeletedEvent event){
        vehiculeRepository.deleteById(event.getId());
        log.info("Vehicule deleted  ");
    }


    @EventHandler
    public void hanlder(ProprietaireCreatedEvent event){
        Proprietaire proprietaire = new Proprietaire(
                event.getId(),
                event.getNom(),
                event.getPrenom(),
                event.getEmail(),
                event.getTel(),
                event.getDate_naissance(),
                null
        );
        proprietaireRepository.save(proprietaire);
        log.info("Proprietaire created  ");
    }

    @EventHandler
    public void hanlder(ProprietaireUpdatedEvent event){
        Proprietaire proprietaire = proprietaireRepository.findById(event.getId()).get();
        proprietaire.setEmail(event.getEmail());
        proprietaire.setDate_naissance(event.getDate_naissance());
        proprietaire.setNom(event.getNom());
        proprietaire.setPrenom(event.getPrenom());
        proprietaire.setTel(event.getTel());
        proprietaireRepository.save(proprietaire);
        log.info("Proprietaire updated  ");
    }

    @EventHandler
    public void hanlder(ProprietaireDeletedEvent event){
        proprietaireRepository.deleteById(event.getId());
        log.info("Proprietaire deleted  ");
    }



}