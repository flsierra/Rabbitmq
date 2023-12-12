package com.makaia.back4.Messages.dtos;

public class CrearMessageDTO {

   private String contenido;
   private Long emisor;
   private Long receptor;

    public CrearMessageDTO() {
    }

    public CrearMessageDTO(String contenido, Long emisor, Long receptor) {
        this.contenido = contenido;
        this.emisor = emisor;
        this.receptor = receptor;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Long getEmisor() {
        return emisor;
    }

    public void setEmisor(Long emisor) {
        this.emisor = emisor;
    }

    public Long getReceptor() {
        return receptor;
    }

    public void setReceptor(Long receptor) {
        this.receptor = receptor;
    }
}
