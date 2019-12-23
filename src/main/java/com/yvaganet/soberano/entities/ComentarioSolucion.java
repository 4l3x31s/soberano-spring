package com.yvaganet.soberano.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "comentario_solucion", schema = "soberano", catalog = "")
public class ComentarioSolucion {
    private long idComentarioSolucion;
    private long idSolucion;
    private long idUsuario;
    private String comentario;
    private Timestamp fechaRegistro;
    private int estado;
    private Solucion solucionByIdSolucion;
    private Usuario usuarioByIdUsuario;

    @Id
    @Column(name = "id_comentario_solucion", nullable = false)
    public long getIdComentarioSolucion() {
        return idComentarioSolucion;
    }

    public void setIdComentarioSolucion(long idComentarioSolucion) {
        this.idComentarioSolucion = idComentarioSolucion;
    }

    @Basic
    @Column(name = "id_solucion", nullable = false)
    public long getIdSolucion() {
        return idSolucion;
    }

    public void setIdSolucion(long idSolucion) {
        this.idSolucion = idSolucion;
    }

    @Basic
    @Column(name = "id_usuario", nullable = false)
    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Basic
    @Column(name = "comentario", nullable = false, length = -1)
    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Basic
    @Column(name = "fecha_registro", nullable = false)
    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Basic
    @Column(name = "estado", nullable = false)
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComentarioSolucion that = (ComentarioSolucion) o;

        if (idComentarioSolucion != that.idComentarioSolucion) return false;
        if (idSolucion != that.idSolucion) return false;
        if (idUsuario != that.idUsuario) return false;
        if (estado != that.estado) return false;
        if (comentario != null ? !comentario.equals(that.comentario) : that.comentario != null) return false;
        if (fechaRegistro != null ? !fechaRegistro.equals(that.fechaRegistro) : that.fechaRegistro != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idComentarioSolucion ^ (idComentarioSolucion >>> 32));
        result = 31 * result + (int) (idSolucion ^ (idSolucion >>> 32));
        result = 31 * result + (int) (idUsuario ^ (idUsuario >>> 32));
        result = 31 * result + (comentario != null ? comentario.hashCode() : 0);
        result = 31 * result + (fechaRegistro != null ? fechaRegistro.hashCode() : 0);
        result = 31 * result + estado;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_solucion", referencedColumnName = "id_solucion", nullable = false, insertable = false, updatable = false)
    public Solucion getSolucionByIdSolucion() {
        return solucionByIdSolucion;
    }

    public void setSolucionByIdSolucion(Solucion solucionByIdSolucion) {
        this.solucionByIdSolucion = solucionByIdSolucion;
    }

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false, insertable = false, updatable = false)
    public Usuario getUsuarioByIdUsuario() {
        return usuarioByIdUsuario;
    }

    public void setUsuarioByIdUsuario(Usuario usuarioByIdUsuario) {
        this.usuarioByIdUsuario = usuarioByIdUsuario;
    }
}
