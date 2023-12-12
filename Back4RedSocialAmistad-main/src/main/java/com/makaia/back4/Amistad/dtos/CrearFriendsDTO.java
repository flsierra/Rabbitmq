package com.makaia.back4.Amistad.dtos;

public class CrearFriendsDTO {
   private boolean isAceptado;
   private Long solicitanteId;
   private Long solicitadoId;

    public CrearFriendsDTO(boolean isAceptado, Long solicitanteId, Long solicitadoId) {
        this.isAceptado = isAceptado;
        this.solicitanteId = solicitanteId;
        this.solicitadoId = solicitadoId;
    }

    public boolean isAceptado() {
        return isAceptado;
    }

    public void setAceptado(boolean aceptado) {
        this.isAceptado = aceptado;
    }

    public Long getSolicitanteId() {
        return solicitanteId;
    }

    public void setSolicitanteId(Long solicitanteId) {
        this.solicitanteId = solicitanteId;
    }

    public Long getSolicitadoId() {
        return solicitadoId;
    }

    public void setSolicitadoId(Long solicitadoId) {
        this.solicitadoId = solicitadoId;
    }
}
