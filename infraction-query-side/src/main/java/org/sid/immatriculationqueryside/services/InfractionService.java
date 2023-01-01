package org.sid.immatriculationqueryside.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.sid.immatriculationqueryside.entities.Infraction;
import org.sid.immatriculationqueryside.repositories.InfractionRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class InfractionService {


    private InfractionRepository infractionRepository;

    @EventHandler
    public void on(InfractionCreatedEvent event){
        Infraction infraction = new Infraction(
                event.getId(),
                event.getMatricule(),
                event.getMaxVitesse(),
                event.getMontant(),
                event.getVitesse(),
                event.getDate()
        );
        infractionRepository.save(infraction);
        log.info("Infraction created  ");
    }


    @EventHandler
    public void on(InfractionUpdatedEvent event){// no business logic here !
        Infraction infraction = infractionRepository.findById(event.getId()).get();
        infraction.setDate( event.getDate() );
        infraction.setMatricule( event.getMatricule() );
        infraction.setMaxVitesse( event.getMaxVitesse() );
        infraction.setMontant( event.getMontant() );
        infraction.setVitesse( event.getVitesse());
        infractionRepository.save(infraction);
        log.info("Infraction saved  ");
    }


    @EventHandler
    public void on(InfractionDeletedEvent event){// no business logic here !
        infractionRepository.deleteById(event.getId());
        log.info("Infraction deleted !");
    }
''
    @QueryHandler
    public List<Infraction> on(GetAllInfractionsQuery event){// no business logic here !
        return infractionRepository.findAll();
    }

    @QueryHandler
    public Infraction on(GetInfractionById event){// no business logic here !
        return infractionRepository.findById(event.getId()).get();
    }


}}