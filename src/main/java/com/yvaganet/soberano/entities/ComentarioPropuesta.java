package com.yvaganet.soberano.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "comentario_propuesta", schema = "soberano", catalog = "")
public class ComentarioPropuesta {
    private long idComentarioPropuesta;
    private long idUsuario;
    private long idPropuesta;
    private String comentario;
    private Timestamp fechaRegistro;
    private Integer estado;
    private Usuario usuarioByIdUsuario;
    private Propuesta propuestaByIdPropuesta;

    @Id
    @Column(name = "id_comentario_propuesta", nullable = false)
    public long getIdComentarioPropuesta() {
        return idComentarioPropuesta;
    }

    public void setIdComentarioPropuesta(long idComentarioPropuesta) {
        this.idComentarioPropuesta = idComentarioPropuesta;
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
    @Column(name = "id_propuesta", nullable = false)
    public long getIdPropuesta() {
        return idPropuesta;
    }

    public void setIdPropuesta(long idPropuesta) {
        this.idPropuesta = idPropuesta;
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
    @Column(name = "estado", nullable = true)
    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComentarioPropuesta that = (ComentarioPropuesta) o;

        if (idComentarioPropuesta != that.idComentarioPropuesta) return false;
        if (idUsuario != that.idUsuario) return false;
        if (idPropuesta != that.idPropuesta) return false;
        if (comentario != null ? !comentario.equals(that.comentario) : that.comentario != null) return false;
        if (fechaRegistro != null ? !fechaRegistro.equals(that.fechaRegistro) : that.fechaRegistro != null)
            return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idComentarioPropuesta ^ (idComentarioPropuesta >>> 32));
        result = 31 * result + (int) (idUsuario ^ (idUsuario >>> 32));
        result = 31 * result + (int) (idPropuesta ^ (idPropuesta >>> 32));
        result = 31 * result + (comentario != null ? comentario.hashCode() : 0);
        result = 31 * result + (fechaRegistro != null ? fechaRegistro.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false, insertable = false, updatable = false)
    public Usuario getUsuarioByIdUsuario() {
        return usuarioByIdUsuario;
    }

    public void setUsuarioByIdUsuario(Usuario usuarioByIdUsuario) {
        this.usuarioByIdUsuario = usuarioByIdUsuario;
    }

    @ManyToOne
    @JoinColumn(name = "id_propuesta", referencedColumnName = "id_propuesta", nullable = false, insertable = false, updatable = false)
    public Propuesta getPropuestaByIdPropuesta() {
        return propuestaByIdPropuesta;
    }

    public void setPropuestaByIdPropuesta(Propuesta propuestaByIdPropuesta) {
        this.propuestaByIdPropuesta = propuestaByIdPropuesta;
    }
}
