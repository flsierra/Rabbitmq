package com.makaia.back4.Messages.controllers;

import com.makaia.back4.Messages.dtos.CrearMessageDTO;
import com.makaia.back4.Messages.entities.Mensaje;
import com.makaia.back4.Messages.entities.Publicacion;
import com.makaia.back4.Messages.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/mensajes")
public class MensajeController {
    private MessageService messageService;

    @Autowired
    public MensajeController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping()
    public Mensaje crearMensaje(@RequestBody CrearMessageDTO dto) {
        return this.messageService.crear(dto);
    }

    @GetMapping()
    public List<Mensaje> listarMensajes(){
        return  this.messageService.listar();
    }
}
