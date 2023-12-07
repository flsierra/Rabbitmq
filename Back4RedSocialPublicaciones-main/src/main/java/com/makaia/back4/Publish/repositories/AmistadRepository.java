package com.makaia.back4.Publish.repositories;

import com.makaia.back4.Publish.entities.Amistad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmistadRepository extends CrudRepository<Amistad, Long> {
}
