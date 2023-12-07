package com.makaia.back4.Publish.repositories;

import com.makaia.back4.Publish.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query
    public Usuario findByNombre(String nombre);
    @Query
    public Usuario findByApellido(String nombre);
}
