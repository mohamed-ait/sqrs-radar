package org.sid.immatriculationcommandsid.Aggregates;

import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@NoArgsConstructor
public class VehiculeAggregate {

    @AggregateIdentifier
    private String id;
    private String marque;
    private String matricule;
    private String modele;
    private int puissance;

    private boolean deleted;

    @CommandHandler
    public VehiculeAggregate( CreateVehiculeCommand command){
        AggregateLifecycle.apply( new VehiculeCreatedEvent(
                command.getId(),
                command.getMarque(),
                command.getMatricule(),
                command.getModele(),
                command.getPuissance()
        ));
    }
    @EventSourcingHandler
    public void on(VehiculeCreatedEvent event){
        this.id=event.getId();
        this.marque=event.getMarque();
        this.matricule=event.getMatricule();
        this.modele = event.getMatricule();
        this.puissance = event.getPuissance();
        this.deleted=false;
    }


    @CommandHandler
    public void handle( UpdateVehiculeCommand command){
        if(this.deleted) return;
        AggregateLifecycle.apply( new VehiculeUpdatedEvent(
                command.getId(),
                command.getMarque(),
                command.getMatricule(),
                command.getModele(),
                command.getPuissance()
        ));
    }
    @EventSourcingHandler
    public void on(VehiculeUpdatedEvent event){
        this.id=event.getId();
        this.marque=event.getMarque();
        this.matricule=event.getMatricule();
        this.modele = event.getMatricule();
        this.puissance = event.getPuissance();
        this.deleted=false;
    }


    @CommandHandler
    public void handle( DeleteVehiculeCommand command){
        if(this.deleted) return;
        AggregateLifecycle.apply( new VehiculeDeletedEvent(
                command.getId()
        ));
    }
    @EventSourcingHandler
    public void on(VehiculeDeletedEvent event){
        this.id=event.getId();
        this.deleted=true;
    }



}