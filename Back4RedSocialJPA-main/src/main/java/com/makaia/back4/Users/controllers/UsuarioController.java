package com.makaia.back4.Users.controllers;

import com.makaia.back4.Users.services.UsuarioService;
import com.makaia.back4.Users.dtos.CrearUsuarioDTO;
import com.makaia.back4.Comments.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UsuarioController {
    private  UsuarioService service;

    @Autowired
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping()
    public Usuario crearUsuario(@RequestBody CrearUsuarioDTO dto) {
        return this.service.crear(dto);
    }

    @GetMapping
    public List<Usuario> listarUsuarios(){
        System.out.println("Started");
        return  this.service.listar();
    }
    @DeleteMapping("usuario/{userID}")
    public boolean eliminarUsuarioPorID(@PathVariable ("userID") Long userID){
        return this.service.eliminarUsuario(userID);
    }
}
