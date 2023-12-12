package com.makaia.back4.Comments.entities;

import jakarta.persistence.*;

@Entity
@Table
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column
    private String contenido;

    @ManyToOne(optional = false)
    Usuario usuario;

    @ManyToOne(optional = false)
    Publicacion publicacion;

    public Comentario() {
    }

    public Comentario(String contenido, Usuario usuario, Publicacion publicacion) {
        this.contenido = contenido;
        this.usuario = usuario;
        this.publicacion = publicacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "id=" + id +
                ", contenido='" + contenido + '\'' +
                ", usuario=" + usuario +
                ", publicacion=" + publicacion +
                '}';
    }
}
