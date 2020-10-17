package br.com.secia.apisecia.controller;

import br.com.secia.apisecia.model.Client;
import br.com.secia.apisecia.service.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clients")
@Api(value = "API Rest CLIENT")
@CrossOrigin(origins = "*")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/findAll")
    @ResponseBody
    @ApiOperation(value = "Listar todas os Clientes")
    @PreAuthorize("hasRole('ROLE_PAGINA_TASKS')")
    @Cacheable(value = "listaDeClientes")
    public List<Client> findAll(){
        return clientService.findAll();
    }

    @PostMapping("/save")
    @ResponseBody
    @CacheEvict(value = "listaDeClientes", allEntries = true)
    @ApiOperation(value = "Gravar Cliente")
    @PreAuthorize("hasRole('ROLE_PAGINA_TASKS')")
    public ResponseEntity<Client> save(@RequestBody Client client) {
        clientService.save(client);
        return new ResponseEntity<Client>(client, HttpStatus.CREATED);
    }

    @PutMapping("/atualiza")
    @ResponseBody
    @CacheEvict(value = "listaDeClientes", allEntries = true)
    @ApiOperation(value = "Gravar Cliente")
    @PreAuthorize("hasRole('ROLE_PAGINA_TASKS')")
    public ResponseEntity<Client> atualiza(@RequestBody Client client) {
        clientService.save(client);
        return new ResponseEntity<Client>(client, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{codigo}")
    @ResponseBody
    @CacheEvict(value = "listaDeClientes", allEntries = true)
    @ApiOperation(value = "Deletar Cliente")
    @PreAuthorize("hasRole('ROLE_PAGINA_TASKS')")
    public ResponseEntity<?> delete(@PathVariable Long codigo) {
        clientService.delete(codigo);
        return ResponseEntity.ok().build();
    }

}
