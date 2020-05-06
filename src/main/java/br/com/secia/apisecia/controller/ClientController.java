package br.com.secia.apisecia.controller;

import br.com.secia.apisecia.model.Client;
import br.com.secia.apisecia.security.SeciaUserDetails;
import br.com.secia.apisecia.service.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
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
    public List<Client> findAll(){
        return clientService.findAll();
    }

    @PostMapping("/save")
    @ResponseBody
    @ApiOperation(value = "Gravar Cliente")
    public ResponseEntity<Client> save(@RequestBody Client client) {
        clientService.save(client);
        return new ResponseEntity<Client>(client, HttpStatus.CREATED);
    }

}
