package org.app.banco.repositories;

import org.app.banco.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByCurp(String curp);
    Optional<Client> findByRfc(String rfc);
    Optional<Client> findByNss(String nss);


}
