package org.app.banco.services;

import org.app.banco.models.Client;
import org.app.banco.models.request.ClientRequest;
import org.app.banco.models.response.ClientResponse;

import java.util.List;

public interface ClientService {

    List<ClientResponse> findAllClients();
    ClientResponse findByCurp(String curp);
    void save(ClientRequest client);
    void update(String curp, ClientRequest client);
    void remove(String curp);

}
