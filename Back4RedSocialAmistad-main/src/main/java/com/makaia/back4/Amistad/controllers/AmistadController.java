package com.makaia.back4.Amistad.controllers;

import com.makaia.back4.Amistad.dtos.CrearFriendsDTO;
import com.makaia.back4.Amistad.entities.Amistad;
import com.makaia.back4.Amistad.services.AmistadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/amistad")
public class AmistadController {
    private AmistadService service;
@Autowired
    public AmistadController(AmistadService service) {
        this.service = service;
    }
    @GetMapping()
    public List<Amistad> listaAmistades(){
    return this.service.listar();
    }
    @PostMapping()
    public  Amistad crear(@RequestBody CrearFriendsDTO dto){
    return this.service.CrearAmistad(dto);
    }
    @GetMapping("/{id}")
    public Amistad obtenerAmistadPorId(@PathVariable Long id){
    return this.service.obtnerDatos(id);
    }
    @PutMapping("/{id}")
    public Amistad actualizaAmistad(@PathVariable Long id, @RequestBody CrearFriendsDTO dto){
    return this.service.actualiza(id,dto);
    }
    @DeleteMapping("/{id}")
    public void eliminaAmistad(@PathVariable Long id){
    this.service.elimina(id);
    }
    @PutMapping("/acept/{id}")
    public Amistad aceptarSolicitudAmistad(@PathVariable Long id, @RequestBody CrearFriendsDTO dto){
    return this.service.aceptarSolicitud(id, dto);
    }
}
