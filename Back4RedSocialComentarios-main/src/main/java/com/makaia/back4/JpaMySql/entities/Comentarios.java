package com.makaia.back4.JpaMySql.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Comentarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;



    @Column
    private String contenido;

    @ManyToOne(optional = false)
    Usuario usuario;

    @OneToMany(mappedBy = "publicacion")
    List<Comentario> comentarios;

    public Comentarios() {
    }

    public Comentarios(String contenido, Usuario usuario) {

        this.contenido = contenido;
        this.usuario = usuario;
    }


    public Long getId() {
        return id;
    }



    public String getContenido() {
        return contenido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }
}
