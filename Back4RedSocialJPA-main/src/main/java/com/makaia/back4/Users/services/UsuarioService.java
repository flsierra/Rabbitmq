package com.makaia.back4.Users.services;

import com.makaia.back4.Users.dtos.CrearPublicacionDTO;
import com.makaia.back4.Users.dtos.CrearUsuarioDTO;
import com.makaia.back4.Comments.entities.Publicacion;
import com.makaia.back4.Comments.entities.Usuario;
import com.makaia.back4.Comments.exceptions.RedSocialApiException;

import com.makaia.back4.Comments.repositories.UsuarioRepository;
import com.makaia.back4.Users.publisher.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class UsuarioService {
    UsuarioRepository repository;

    Publisher publisher;

    @Autowired
    public UsuarioService(UsuarioRepository repository, Publisher publisher) {
        this.repository = repository;
        this.publisher = publisher;
    }

    public Usuario crear(CrearUsuarioDTO dto) {
        Usuario exists = this.repository.findByNombre(dto.getNombre());
        if (exists != null) {
            throw new RedSocialApiException("User aleady exists", HttpStatusCode.valueOf(400));
        }
        Usuario nuevoUsuario = new Usuario(dto.getNombre(), dto.getApellido(), dto.getDireccion(), dto.getEdad());
        nuevoUsuario = this.repository.save(nuevoUsuario);

        System.out.println(nuevoUsuario);

        crearPublicacionPorDefecto(nuevoUsuario.getId());

        return nuevoUsuario;
    }

    private void crearPublicacionPorDefecto(Long userId) {
        this.publisher.send(userId);
    }

    private Publicacion crearPublicacionPorDefectoOld(Long userId) {
        RestTemplate template = new RestTemplate();
        CrearPublicacionDTO publicacionDto = new CrearPublicacionDTO("Mi primera publicacion",
                "El contenido",
                userId);
        ResponseEntity<Publicacion> responseEntity = template.postForEntity("http://localhost:8080/api/v1/publicaciones",
                publicacionDto,
                Publicacion.class);
        return responseEntity.getBody();
    }

    private boolean isEmpty(String valor) {
        return valor == null || valor.isEmpty();
    }


    public List<Usuario> listar() {
        return StreamSupport
                .stream(this.repository.findAll().spliterator(), false)
                .toList();
    }
    public boolean eliminarUsuario(Long userID){
        Optional<Usuario> existUsuario = this.repository.findById(userID);
        if ((existUsuario.isEmpty())){
            throw new RedSocialApiException("usuario no encontrado, verifique ");
        }
        this.repository.delete(existUsuario.get());
        return true;
    }
}
