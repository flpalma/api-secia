package br.com.secia.apisecia.controller;


import br.com.secia.apisecia.security.SeciaUserDetailsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
@Api(value = "API Rest USER")
public class UserController {

    @Autowired
    SeciaUserDetailsService service;
//
    @GetMapping("/buscarPermissoes/{email}")
    @ResponseBody
    @ApiOperation(value = "Listar todas as permissoes")
    public UserDetails buscarDetalhesUsuario(@PathVariable( "email" ) String email){
        return service.loadUserByUsername(email);
    }

}
