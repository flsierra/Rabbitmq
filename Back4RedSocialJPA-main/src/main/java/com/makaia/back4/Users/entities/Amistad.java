package com.makaia.back4.Users.entities;

import com.makaia.back4.Comments.entities.Usuario;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class Amistad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column
    private boolean isAceptado;

    @Column(nullable = true)
    private Date desde;

    @ManyToOne(optional = false)
    com.makaia.back4.Comments.entities.Usuario solicitante;

    @ManyToOne(optional = false)
    Usuario solicitado;
}
