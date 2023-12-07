package com.makaia.back4.Comments.services;

import com.makaia.back4.Comments.Publisher.PublisherComments;
import com.makaia.back4.Comments.entities.Publicacion;
import com.makaia.back4.Comments.entities.Usuario;
import com.makaia.back4.Comments.exceptions.RedSocialApiException;
import com.makaia.back4.Comments.repositories.ComentarioRepository;
import com.makaia.back4.Comments.repositories.PublicacionRepository;
import com.makaia.back4.Comments.repositories.UsuarioRepository;
import com.makaia.back4.Comments.dtos.CrearCommentsDTO;
import com.makaia.back4.Comments.entities.Comentario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class CommentService {
    ComentarioRepository repository;
    UsuarioRepository usuarioRepository;
    PublicacionRepository publicacionRepository;
    PublisherComments publisher;
@Autowired
    public CommentService(ComentarioRepository repository, UsuarioRepository usuarioRepository, PublicacionRepository publicacionRepository, PublisherComments publisher) {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
        this.publicacionRepository = publicacionRepository;
        this.publisher = publisher;
    }

    public Comentario crearComent(CrearCommentsDTO dto) {
        Usuario usuario = this.usuarioRepository
                .findById(dto.getUsuarioId())
                .orElseThrow(
                        () ->
                                new RedSocialApiException("El usuario no existe y no puede crear comentarios"));
        Publicacion publicacion = this.publicacionRepository.findById(dto.getPublicacion())
                .orElseThrow (() ->
        new RedSocialApiException("No se puede encontrar la publicación"));

        Comentario nuevoComentario = new Comentario(dto.getContenido(), usuario,publicacion);
        nuevoComentario = this.repository.save(nuevoComentario);
        System.out.println(nuevoComentario);
        crearComentarioParaUsuario(nuevoComentario.getId());
        return nuevoComentario;
    }
    private void crearComentarioParaUsuario(Long comentario){
        this.publisher.send(comentario);
    }
    public List<Comentario> listar() {
        return StreamSupport
                .stream(this.repository.findAll().spliterator(), false)
                .toList();
    }


}
