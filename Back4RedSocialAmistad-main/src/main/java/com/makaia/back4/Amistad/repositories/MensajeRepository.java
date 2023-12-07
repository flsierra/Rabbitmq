package com.makaia.back4.Amistad.repositories;

import com.makaia.back4.Amistad.entities.Mensaje;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensajeRepository extends CrudRepository<Mensaje, Long> {
}
