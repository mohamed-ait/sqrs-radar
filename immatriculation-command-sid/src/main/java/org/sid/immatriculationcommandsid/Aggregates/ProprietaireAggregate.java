package org.sid.immatriculationcommandsid.Aggregates;


import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.Date;

@Aggregate
@NoArgsConstructor
public class ProprietaireAggregate {

    @AggregateIdentifier
    private String id;
    private String nom;
    private String prenom;
    private String email;
    private String tel;
    private Date date_naissance;

    private boolean deleted;

    @CommandHandler
    public ProprietaireAggregate(CreateProprietaireCommand command){
        AggregateLifecycle.apply( new ProprietaireCreatedEvent(
                command.getId(),
                command.getNom(),
                command.getPrenom(),
                command.getEmail(),
                command.getTel(),
                command.getDate_naissance()
        ));
    }
    @EventSourcingHandler
    public void on(ProprietaireCreatedEvent event){
        this.id=event.getId();
        this.date_naissance=event.getDate_naissance();
        this.nom=event.getNom();
        this.prenom = event.getPrenom();
        this.tel = event.getTel();
        this.email = event.getEmail();
        this.deleted=false;
    }


    @CommandHandler
    public void handle( UpdateProprietaireCommand command){
        if(this.deleted) return;
        AggregateLifecycle.apply( new ProprietaireUpdatedEvent(
                command.getId(),
                command.getNom(),
                command.getPrenom(),
                command.getEmail(),
                command.getTel(),
                command.getDate_naissance()
        ));
    }
    @EventSourcingHandler
    public void on(ProprietaireUpdatedEvent event){
        this.id=event.getId();
        this.date_naissance=event.getDate_naissance();
        this.nom=event.getNom();
        this.prenom = event.getPrenom();
        this.tel = event.getTel();
        this.email = event.getEmail();
        this.deleted=false;
    }


    @CommandHandler
    public void handle( DeleteProprietaireCommand command){
        if(this.deleted) return;
        AggregateLifecycle.apply( new ProprietaireDeletedEvent(
                command.getId()
        ));
    }
    @EventSourcingHandler
    public void on(ProprietaireDeletedEvent event){
        this.id=event.getId();
        this.deleted=true;
    }



}