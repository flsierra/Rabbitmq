package com.makaia.back4.Comments.dtos;

public class CrearCommentsDTO {


    private String contenido;

    private Long usuarioId;
    private Long Publicacion;

    public CrearCommentsDTO() {
    }

    public CrearCommentsDTO(String contenido, Long usuarioId, Long publicacion) {
        this.contenido = contenido;
        this.usuarioId = usuarioId;
        Publicacion = publicacion;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getPublicacion() {
        return Publicacion;
    }

    public void setPublicacion(Long publicacion) {
        Publicacion = publicacion;
    }
}
