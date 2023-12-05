package com.makaia.back4.JpaMySql.repositories;

import com.makaia.back4.JpaMySql.entities.Comentarios;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicacionRepository extends CrudRepository<Comentarios, Long> {
}
