package com.makaia.back4.Users.entities;


import com.makaia.back4.Comments.entities.Usuario;
import jakarta.persistence.*;

@Entity
@Table
public class Mensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column
    private String contenido;

    @ManyToOne(optional = false)
    com.makaia.back4.Comments.entities.Usuario emisor;

    @ManyToOne(optional = false)
    Usuario receptor;
}
