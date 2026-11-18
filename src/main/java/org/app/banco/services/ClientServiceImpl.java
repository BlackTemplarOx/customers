package org.app.banco.services;

import org.app.banco.models.Client;
import org.app.banco.models.request.ClientRequest;
import org.app.banco.models.response.ClientResponse;
import org.app.banco.repositories.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService{

    private final ClientRepository repository;

    public ClientServiceImpl(ClientRepository repository){
        this.repository = repository;
    }


    @Override
    public List<ClientResponse> findAllClients() {

        List<Client> clients = repository.findAll();

        return clients.stream().map(client -> new ClientResponse(
                client.getName(),
                client.getPaternalLastname(),
                client.getMaternalLastname(),
                client.getCurp(),
                client.getRfc(),
                client.getNss()
        )).toList();

    }

    @Override
    public ClientResponse findByCurp(String curp) {

        return repository.findByCurp(curp).map(
                client -> new ClientResponse(
                    client.getName(),
                    client.getPaternalLastname(),
                    client.getMaternalLastname(),
                    client.getCurp(),
                    client.getRfc(),
                    client.getNss()
                )).orElseThrow(() -> new RuntimeException("Customer not exists"));
    }

    @Transactional
    @Override
    public void save(ClientRequest client) {

        repository.findByCurp(client.getCurp()).ifPresent(
                c -> {
                    throw new RuntimeException("The CURP has already been registered.");
                });

        repository.findByRfc(client.getRfc()).ifPresent(
                c ->{
                    throw new RuntimeException("The RFC has already been registered.");
                });

        repository.findByNss(client.getNss()).ifPresent(
                c -> {
                    throw new RuntimeException("The NSS has already been registered.");
                });

        Client register = new Client();
        register.setName(client.getName());
        register.setPaternalLastname(client.getPaternalLastname());
        register.setMaternalLastname(client.getMaternalLastname());
        register.setCurp(client.getCurp());
        register.setRfc(client.getRfc());
        register.setNss(client.getNss());
        register.setAvaible(true);
        register.setCreatedAt(LocalDateTime.now());
        register.setUpdatedAt(LocalDateTime.now());

        repository.save(register);
    }

    @Transactional
    @Override
    public void update(String curp, ClientRequest client) {

        Client findClient = repository.findByCurp(curp).orElseThrow();

        repository.findByCurp(client.getCurp())
                .filter(c -> !c.getIdClient().equals(findClient.getIdClient()))
                .ifPresent( c -> {
                    throw new RuntimeException("The CURP has already been registered");
                });

        repository.findByRfc(client.getRfc())
                .filter(c -> !c.getIdClient().equals(findClient.getIdClient()))
                .ifPresent( c -> {
                    throw new RuntimeException("The RFC has already been registered.");
                });

        repository.findByNss(client.getNss())
                .filter( c -> !c.getIdClient().equals(findClient.getIdClient()))
                .ifPresent( c -> {
                    throw new RuntimeException("The NSS has already been registered.");
                });

        findClient.setName(client.getName());
        findClient.setPaternalLastname(client.getPaternalLastname());
        findClient.setMaternalLastname(client.getMaternalLastname());
        findClient.setCurp(client.getCurp());
        findClient.setRfc(client.getRfc());
        findClient.setNss(client.getNss());
        findClient.setUpdatedAt(LocalDateTime.now());

        repository.save(findClient);

    }

    @Transactional
    @Override
    public void remove(String curp) {

        Client client = repository.findByCurp(curp).orElseThrow();

        repository.delete(client);
    }
}
