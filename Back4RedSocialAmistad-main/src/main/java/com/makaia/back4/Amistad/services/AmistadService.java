package com.makaia.back4.Amistad.services;

import com.makaia.back4.Amistad.dtos.CrearFriendsDTO;
import com.makaia.back4.Amistad.entities.Amistad;
import com.makaia.back4.Amistad.entities.Usuario;
import com.makaia.back4.Amistad.exceptions.RedSocialApiException;
import com.makaia.back4.Amistad.publisher.PublisherFriends;
import com.makaia.back4.Amistad.repositories.AmistadRepository;
import com.makaia.back4.Amistad.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class AmistadService {
    AmistadRepository repository;
    PublisherFriends publisherFriends;
    UsuarioRepository usuarioRepository;
@Autowired
    public AmistadService(AmistadRepository repository, PublisherFriends publisherFriends, UsuarioRepository usuarioRepository) {
        this.repository = repository;
        this.publisherFriends = publisherFriends;
        this.usuarioRepository = usuarioRepository;
    }
    public Amistad CrearAmistad(CrearFriendsDTO dto){
        Usuario solicitante = buscaUsuarioId(dto.getSolicitanteId());
        Usuario solicitado = buscaUsuarioId(dto.getSolicitadoId());
        validaAmistadNoExistente(solicitante,solicitado);
        Amistad nuevaAmistad = new Amistad();
        nuevaAmistad.setSolicitante(solicitante);
        nuevaAmistad.setSolicitado(solicitado);
        nuevaAmistad.setAceptado(false);
        nuevaAmistad = this.repository.save(nuevaAmistad);
        this.publisherFriends.send(nuevaAmistad.getId());
        return nuevaAmistad;
    }
    private Usuario buscaUsuarioId(Long idUser){
    return this.usuarioRepository.findById(idUser)
            .orElseThrow(()-> new RedSocialApiException("Usuario digitado no encontrado, valide datos "+idUser));
    }
    private void validaAmistadNoExistente(Usuario solicitante, Usuario solicitado){
   if (existeAmistad(solicitante,solicitado) || existeAmistad(solicitado,solicitante)){
       throw new RedSocialApiException("Los usuarios ya son amigos, valide ");
   }
    }
    private boolean existeAmistad(Usuario user1, Usuario user2){
    return false;
    }
    public List<Amistad> listar(){
    return StreamSupport
            .stream(this.repository.findAll().spliterator(),false)
            .toList();
    }
    public Amistad aceptarSolicitud(Long solicitanteId, CrearFriendsDTO dto){
    Amistad solicitudPendiente = repository
            .findBySolicitanteAndSolicitado(new Usuario(solicitanteId), new Usuario(dto.getSolicitadoId()));
    if (solicitudPendiente != null){
        solicitudPendiente.setAceptado(true);
        return repository.save(solicitudPendiente);
    }
    else {
        throw new RedSocialApiException("No se encontró solicitudes pendientes");
    }
    }
    public Amistad obtnerDatos(Long id){
    return this.repository.findById(id)
            .orElseThrow(() -> new RedSocialApiException("Relación de amistad no encontrada "+id));
    }
    public Amistad actualiza(Long id, CrearFriendsDTO dto){
    Amistad amistadExist = obtnerDatos(id);
    amistadExist.setAceptado(dto.isAceptado());
    return this.repository.save(amistadExist);
    }
    public void elimina(Long id){
    Amistad amistadExist = obtnerDatos(id);
    this.repository.delete(amistadExist);
    }
}
