package com.makaia.back4.Users.entities;


import com.makaia.back4.Comments.entities.Publicacion;
import com.makaia.back4.Comments.entities.Usuario;
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
