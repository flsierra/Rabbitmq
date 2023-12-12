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
    private boolean isAceptado = false;

    @Column(nullable = true)
    private Date desde;

    @ManyToOne(optional = false)
    com.makaia.back4.Comments.entities.Usuario solicitante;

    @ManyToOne(optional = false)
    com.makaia.back4.Comments.entities.Usuario solicitado;

    public Amistad() {
    }

    public Amistad(boolean isAceptado, Date desde, com.makaia.back4.Comments.entities.Usuario usuario) {
        this.isAceptado = isAceptado;
        this.desde = desde;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAceptado() {
        return isAceptado;
    }



    public Date getDesde() {
        return desde;
    }

    public void setDesde(Date desde) {
        this.desde = desde;
    }

    public com.makaia.back4.Comments.entities.Usuario getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(com.makaia.back4.Comments.entities.Usuario solicitante) {
        this.solicitante = solicitante;
    }

    public com.makaia.back4.Comments.entities.Usuario getSolicitado() {
        return solicitado;
    }

    public void setSolicitado(Usuario solicitado) {
        this.solicitado = solicitado;
    }
}