package com.makaia.back4.Messages.entities;

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
    Usuario emisor;

    @ManyToOne(optional = false)
    Usuario receptor;
}
