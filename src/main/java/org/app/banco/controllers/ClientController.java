package org.app.banco.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.app.banco.models.Client;
import org.app.banco.models.request.ClientRequest;
import org.app.banco.models.response.APIResponse;
import org.app.banco.models.response.ClientResponse;
import org.app.banco.services.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/app/customers")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<APIResponse<List<ClientResponse>>> findAllClients(){

        return ResponseEntity.status(HttpStatus.OK).body(
                new APIResponse<>(
                        LocalDateTime.now(),
                        200,
                        "List of customers.",
                        null,
                        service.findAllClients()
                ));
    }

    @GetMapping("/{curp}")
    public ResponseEntity<APIResponse<ClientResponse>> findByCurp(
            @PathVariable
            @NotNull(message = "The CURP is required.")
            @Size(max = 18, min = 18, message = "The CURP is not valid.")
            String curp){

        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse<>(
                LocalDateTime.now(),
                200,
                "Client find succesfully.",
                null,
                service.findByCurp(curp)
        ));
    }

    @PostMapping
    public ResponseEntity<APIResponse<Void>> insert(@Valid @RequestBody ClientRequest clientRequest){

        service.save(clientRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                new APIResponse<>(
                        LocalDateTime.now(),
                        201,
                        "Client succesfully register!.",
                        null,
                        null
                ));
    }

    @PutMapping("/{curp}")
    public ResponseEntity<APIResponse<Void>> update(
            @PathVariable
            @NotBlank(message = "The CURP is required.")
            @Size(min = 18, max = 18, message = "The CURP is not valid.")
            String curp,
            @Valid @RequestBody ClientRequest clientRequest){



        return ResponseEntity.status(HttpStatus.OK).body(
                new APIResponse<>(
                        LocalDateTime.now(),
                        200,
                        "Client succesfully updated!.",
                        null,
                        null
                ));
    }

}
