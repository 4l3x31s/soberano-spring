package com.yvaganet.soberano.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "tasa_aceptacion", schema = "soberano", catalog = "")
public class TasaAceptacion {
    private long idTasa;
    private long idUsuario;
    private long propuestaId;
    private String nombreTabla;
    private int tipoReaccion;
    private Timestamp fechaRegistro;
    private int estado;
    private Usuario usuarioByIdUsuario;

    @Id
    @Column(name = "id_tasa", nullable = false)
    public long getIdTasa() {
        return idTasa;
    }

    public void setIdTasa(long idTasa) {
        this.idTasa = idTasa;
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
    @Column(name = "propuesta_id", nullable = false)
    public long getPropuestaId() {
        return propuestaId;
    }

    public void setPropuestaId(long propuestaId) {
        this.propuestaId = propuestaId;
    }

    @Basic
    @Column(name = "nombre_tabla", nullable = false, length = -1)
    public String getNombreTabla() {
        return nombreTabla;
    }

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    @Basic
    @Column(name = "tipo_reaccion", nullable = false)
    public int getTipoReaccion() {
        return tipoReaccion;
    }

    public void setTipoReaccion(int tipoReaccion) {
        this.tipoReaccion = tipoReaccion;
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

        TasaAceptacion that = (TasaAceptacion) o;

        if (idTasa != that.idTasa) return false;
        if (idUsuario != that.idUsuario) return false;
        if (propuestaId != that.propuestaId) return false;
        if (tipoReaccion != that.tipoReaccion) return false;
        if (estado != that.estado) return false;
        if (nombreTabla != null ? !nombreTabla.equals(that.nombreTabla) : that.nombreTabla != null) return false;
        if (fechaRegistro != null ? !fechaRegistro.equals(that.fechaRegistro) : that.fechaRegistro != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idTasa ^ (idTasa >>> 32));
        result = 31 * result + (int) (idUsuario ^ (idUsuario >>> 32));
        result = 31 * result + (int) (propuestaId ^ (propuestaId >>> 32));
        result = 31 * result + (nombreTabla != null ? nombreTabla.hashCode() : 0);
        result = 31 * result + tipoReaccion;
        result = 31 * result + (fechaRegistro != null ? fechaRegistro.hashCode() : 0);
        result = 31 * result + estado;
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
}
