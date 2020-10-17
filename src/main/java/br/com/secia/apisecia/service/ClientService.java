package br.com.secia.apisecia.service;

import br.com.secia.apisecia.model.Client;
import br.com.secia.apisecia.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @CacheEvict(value = "clientes", allEntries = true)
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @CacheEvict(value = "clientes", allEntries = true)
    public void delete(Long codigo) {
        clientRepository.deleteById(codigo);
    }
}
