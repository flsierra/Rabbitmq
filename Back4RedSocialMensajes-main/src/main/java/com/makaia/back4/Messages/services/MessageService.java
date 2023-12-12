package com.makaia.back4.Messages.services;

import com.makaia.back4.Messages.dtos.CrearMessageDTO;
import com.makaia.back4.Messages.entities.Mensaje;
import com.makaia.back4.Messages.entities.Publicacion;
import com.makaia.back4.Messages.entities.Usuario;
import com.makaia.back4.Messages.exceptions.RedSocialApiException;
import com.makaia.back4.Messages.repositories.MensajeRepository;
import com.makaia.back4.Messages.repositories.PublicacionRepository;
import com.makaia.back4.Messages.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.StreamSupport;

@org.springframework.stereotype.Service
public class MessageService {
    MensajeRepository repository;
    UsuarioRepository usuarioRepository;

    public MessageService(MensajeRepository repository, UsuarioRepository usuarioRepository) {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
    }

    @Autowired


    public Mensaje crear(CrearMessageDTO dto) {
        Usuario usuario = this.usuarioRepository
                .findById(dto.getEmisor())
                .orElseThrow(
                        () -> new RedSocialApiException("El usuario no existe y no puede crear publicaciones"));
        Mensaje nuevoMensaje = new Mensaje();
        return this.repository.save(nuevoMensaje);
    }

    public List<Mensaje> listar() {
        return StreamSupport
                .stream(this.repository.findAll().spliterator(), false)
                .toList();
    }
}
