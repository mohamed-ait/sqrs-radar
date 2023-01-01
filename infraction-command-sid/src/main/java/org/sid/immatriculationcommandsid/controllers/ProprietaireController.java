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
@RequestMapping("/proprietaires")
public class ProprietaireController {

    private CommandGateway commandGateway;
    private EventStore eventStore;

    @PostMapping("/create")
    public ResponseEntity<String> createProprietaire(@RequestBody CreateProprietaireRequestDTO dto) throws FieldRequiredException {
        CompletableFuture<String> commandResponse = commandGateway.send(new CreateProprietaireCommand(
                UUID.randomUUID().toString(),
                dto.getNom(),
                dto.getPrenom(),
                dto.getEmail(),
                dto.getTel(),
                dto.getDate_naissance()
        ));
        String response=null;
        try{
            response = commandResponse.get();
        } catch (Exception exc){
            return ResponseEntity.unprocessableEntity().body(response);
        }
        return ResponseEntity.ok(response);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateRadar(@PathVariable String id, @RequestBody UpdateProprietaireCommand dto) throws FieldRequiredException {


        CompletableFuture<String> commandResponse = commandGateway.send(new UpdateProprietaireCommand(
                id,
                dto.getNom(),
                dto.getPrenom(),
                dto.getEmail(),
                dto.getTel(),
                dto.getDate_naissance()
        ));
        String response=null;
        try{
            response = commandResponse.get();
        } catch (Exception e){
            return ResponseEntity.unprocessableEntity().body(response);
        }
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRadar( @PathVariable String id)  {
        CompletableFuture<String> commandResponse = commandGateway.send(new DeleteProprietaireCommand(
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
