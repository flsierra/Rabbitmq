package com.makaia.back4.Publish.repositories;

import com.makaia.back4.Publish.entities.Comentario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends CrudRepository<Comentario, Long> {
}
