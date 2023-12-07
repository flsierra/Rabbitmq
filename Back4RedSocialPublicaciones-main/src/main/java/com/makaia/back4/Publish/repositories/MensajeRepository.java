package com.makaia.back4.Publish.repositories;

import com.makaia.back4.Publish.entities.Mensaje;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensajeRepository extends CrudRepository<Mensaje, Long> {
}
