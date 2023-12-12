package com.makaia.back4.Messages.repositories;

import com.makaia.back4.Messages.entities.Publicacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicacionRepository extends CrudRepository<Publicacion, Long> {
}
