package com.makaia.back4.Publish.controllers;

import com.makaia.back4.Publish.dtos.CrearDTO;
import com.makaia.back4.Publish.entities.Publicacion;
import com.makaia.back4.Publish.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/publicaciones")
public class Controller {
    private Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    @PostMapping()
    public Publicacion crearUsuario(@RequestBody CrearDTO dto) {
        return this.service.crear(dto);
    }

    @GetMapping()
    public List<Publicacion> listarUsuarios(){
        return  this.service.listar();
    }
}
