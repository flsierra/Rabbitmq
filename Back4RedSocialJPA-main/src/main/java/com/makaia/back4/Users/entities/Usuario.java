package com.makaia.back4.Users.entities;


import com.makaia.back4.Comments.entities.Amistad;
import com.makaia.back4.Comments.entities.Comentario;
import com.makaia.back4.Comments.entities.Mensaje;
import com.makaia.back4.Comments.entities.Publicacion;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table()
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(length = 50)
    private String nombre;

    @Column(length = 50)
    private String apellido;

    @Column(length = 150)
    private String direccion;

    @Column
    private Integer edad;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String direccion, Integer edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.edad = edad;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public Integer getEdad() {
        return edad;
    }

    public List<com.makaia.back4.Comments.entities.Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public List<com.makaia.back4.Comments.entities.Mensaje> getMensajesEnviados() {
        return mensajesEnviados;
    }

    public List<com.makaia.back4.Comments.entities.Mensaje> getMensajesRecibidos() {
        return mensajesRecibidos;
    }

    public List<com.makaia.back4.Comments.entities.Comentario> getComentarios() {
        return comentarios;
    }

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    List<Publicacion> publicaciones;

    @OneToMany(mappedBy = "emisor")
    List<com.makaia.back4.Comments.entities.Mensaje> mensajesEnviados;

    @OneToMany(mappedBy = "receptor")
    List<Mensaje> mensajesRecibidos;

    @OneToMany(mappedBy = "solicitante")
    List<com.makaia.back4.Comments.entities.Amistad> solicitudasEnviadas;

    @OneToMany(mappedBy = "solicitado")
    List<Amistad> solicitudasRecibidas;

    @OneToMany(mappedBy = "usuario")
    List<Comentario> comentarios;

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", edad=" + edad +
                '}';
    }
}
