package br.com.secia.apisecia.repository;

import br.com.secia.apisecia.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByCodigo(Long id);
}
