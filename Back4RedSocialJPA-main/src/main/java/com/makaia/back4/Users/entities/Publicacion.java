package com.makaia.back4.Users.entities;

import com.makaia.back4.Comments.entities.Comentario;
import com.makaia.back4.Comments.entities.Usuario;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Publicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column
    private String titulo;

    @Column
    private String contenido;

    @ManyToOne(optional = false)
    Usuario usuario;

    @OneToMany(mappedBy = "publicacion")
    List<com.makaia.back4.Comments.entities.Comentario> comentarios;

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }
}
