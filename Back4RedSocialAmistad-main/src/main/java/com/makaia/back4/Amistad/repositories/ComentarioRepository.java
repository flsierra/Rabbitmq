package com.makaia.back4.Amistad.repositories;

import com.makaia.back4.Amistad.entities.Comentario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends CrudRepository<Comentario, Long> {
}
