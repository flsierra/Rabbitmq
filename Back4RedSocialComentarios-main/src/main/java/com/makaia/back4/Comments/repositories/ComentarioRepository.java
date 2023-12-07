package com.makaia.back4.Comments.repositories;

import com.makaia.back4.Comments.entities.Comentario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends CrudRepository<Comentario, Long> {
}
