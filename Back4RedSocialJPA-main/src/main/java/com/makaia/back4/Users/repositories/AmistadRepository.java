package com.makaia.back4.Users.repositories;

import com.makaia.back4.Comments.entities.Amistad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmistadRepository extends CrudRepository<Amistad, Long> {
}
