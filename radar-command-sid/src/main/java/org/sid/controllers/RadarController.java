package org.sid.controllers;

import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.sid.commands.CreateRadarCommand;
import org.sid.commands.DeleteRadarCommand;
import org.sid.commands.UpdateRadarCommand;
import org.sid.dtos.CreateRadarRequestDTO;
import org.sid.dtos.UpdateRadarRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@AllArgsConstructor
public class RadarController {

    private CommandGateway commandGateway;
    private EventStore eventStore;


    @PostMapping("/create")
    public ResponseEntity<String> createRadar(@RequestBody CreateRadarRequestDTO radar) {

        CompletableFuture<String> commandResponse = commandGateway.send(new CreateRadarCommand(
                UUID.randomUUID().toString(),
                radar.getLatitude(),
                radar.getLongitude(),
                radar.getVitesse_max()
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
    public ResponseEntity<String> updateRadar( @PathVariable String id, @RequestBody UpdateRadarRequestDTO radar){
        CompletableFuture<String> commandResponse = commandGateway.send(new UpdateRadarCommand(
                id,
                radar.getLatitude(),
                radar.getLongitude(),
                radar.getVitesse_max()
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
    public ResponseEntity<String> deleteRadar( @PathVariable String id)  {
        CompletableFuture<String> commandResponse = commandGateway.send(new DeleteRadarCommand(
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