package com.makaia.back4.Publish.services;

import com.makaia.back4.Publish.dtos.CrearDTO;
import com.makaia.back4.Publish.entities.Publicacion;
import com.makaia.back4.Publish.entities.Usuario;
import com.makaia.back4.Publish.exceptions.RedSocialApiException;
import com.makaia.back4.Publish.repositories.PublicacionRepository;
import com.makaia.back4.Publish.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.StreamSupport;

@org.springframework.stereotype.Service
public class Service {
    PublicacionRepository repository;
    UsuarioRepository usuarioRepository;

    @Autowired
    public Service(PublicacionRepository repository, UsuarioRepository usuarioRepository) {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
    }

    public Publicacion crear(CrearDTO dto) {
        Usuario usuario = this.usuarioRepository
                .findById(dto.getUsuarioId())
                .orElseThrow(
                        () -> new RedSocialApiException("El usuario no existe y no puede crear publicaciones"));
        Publicacion nuevoUsuario = new Publicacion(dto.getTitulo(), dto.getContenido(), usuario);
        return this.repository.save(nuevoUsuario);
    }

    public List<Publicacion> listar() {
        return StreamSupport
                .stream(this.repository.findAll().spliterator(), false)
                .toList();
    }
}
