package org.sid.immatriculationcommandsid.controllers;

import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@AllArgsConstructor
@RequestMapping("/infractions")
public class InfractionCommandController {

    private CommandGateway commandGateway;
    private EventStore eventStore;

    @PostMapping("/create")
    public ResponseEntity<String> createInfraction(@RequestBody CreateInfractionRequestDTO dto) throws FieldRequiredException,InvalidFractionSpeedException {

        if( dto.getVitesse()<dto.getMaxVitesse() )
            throw new InvalidFractionSpeedException("Vitesses Invalides !");
        if( dto.getMatricule()==null )
            throw new FieldRequiredException("Matricule est manquant! ");

        CompletableFuture<String> commandResponse = commandGateway.send(new CreateInfractionCommand(
                UUID.randomUUID().toString(),
                dto.getMatricule(),
                dto.getMaxVitesse(),
                dto.getMontant(),
                dto.getVitesse(),
                dto.getDate()
        ));
        String response=null;
        try{
            response = commandResponse.get();
        } catch (Exception e){
            return ResponseEntity.unprocessableEntity().body(response);
        }
        return ResponseEntity.ok(response);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateInfraction(@PathVariable String id, @RequestBody UpdateInfractionCommand dto) throws FieldRequiredException, InvalidFractionSpeedException {

        if( dto.getVitesse()<dto.getMaxVitesse() )
            throw new InvalidFractionSpeedException("Vitesses Invalides !");
        if( dto.getMatricule()==null )
            throw new FieldRequiredException("Matricule est manquant! ");

        CompletableFuture<String> commandResponse = commandGateway.send(new UpdateInfractionCommand(
                id,
                dto.getMatricule(),
                dto.getMaxVitesse(),
                dto.getMontant(),
                dto.getVitesse(),
                dto.getDate()
        ));
        String response=null;
        try{
            response = commandResponse.get();
        } catch (Exception exc){
            return ResponseEntity.unprocessableEntity().body(response);
        }
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteInfraction( @PathVariable String id)  {
        CompletableFuture<String> commandResponse = commandGateway.send(new DeleteInfractionCommand(
                id
        ));
        String response=null;
        try{
            response = commandResponse.get();
        } catch (Exception exc){
            return ResponseEntity.unprocessableEntity().body(response);
        }
        return ResponseEntity.ok(response);
    }



    @GetMapping("/eventStore/{id}")
    public Stream eventStore(@PathVariable String id ) {
        return eventStore.readEvents( id).asStream();
    }


}