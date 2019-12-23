package com.yvaganet.soberano.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
public class Solucion {
    private long idSolucion;
    private long idPropuestaFinal;
    private long idUsuario;
    private String subArea;
    private String titulo;
    private String descripcion;
    private Timestamp fechaRegistro;
    private int estado;
    private Collection<ComentarioSolucion> comentarioSolucionsByIdSolucion;
    private PropuestaFinal propuestaFinalByIdPropuestaFinal;
    private Usuario usuarioByIdUsuario;

    @Id
    @Column(name = "id_solucion", nullable = false)
    public long getIdSolucion() {
        return idSolucion;
    }

    public void setIdSolucion(long idSolucion) {
        this.idSolucion = idSolucion;
    }

    @Basic
    @Column(name = "id_propuesta_final", nullable = false)
    public long getIdPropuestaFinal() {
        return idPropuestaFinal;
    }

    public void setIdPropuestaFinal(long idPropuestaFinal) {
        this.idPropuestaFinal = idPropuestaFinal;
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
    @Column(name = "sub_area", nullable = true, length = -1)
    public String getSubArea() {
        return subArea;
    }

    public void setSubArea(String subArea) {
        this.subArea = subArea;
    }

    @Basic
    @Column(name = "titulo", nullable = true, length = -1)
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Basic
    @Column(name = "descripcion", nullable = false, length = -1)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

        Solucion solucion = (Solucion) o;

        if (idSolucion != solucion.idSolucion) return false;
        if (idPropuestaFinal != solucion.idPropuestaFinal) return false;
        if (idUsuario != solucion.idUsuario) return false;
        if (estado != solucion.estado) return false;
        if (subArea != null ? !subArea.equals(solucion.subArea) : solucion.subArea != null) return false;
        if (titulo != null ? !titulo.equals(solucion.titulo) : solucion.titulo != null) return false;
        if (descripcion != null ? !descripcion.equals(solucion.descripcion) : solucion.descripcion != null)
            return false;
        if (fechaRegistro != null ? !fechaRegistro.equals(solucion.fechaRegistro) : solucion.fechaRegistro != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idSolucion ^ (idSolucion >>> 32));
        result = 31 * result + (int) (idPropuestaFinal ^ (idPropuestaFinal >>> 32));
        result = 31 * result + (int) (idUsuario ^ (idUsuario >>> 32));
        result = 31 * result + (subArea != null ? subArea.hashCode() : 0);
        result = 31 * result + (titulo != null ? titulo.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (fechaRegistro != null ? fechaRegistro.hashCode() : 0);
        result = 31 * result + estado;
        return result;
    }

    @OneToMany(mappedBy = "solucionByIdSolucion")
    public Collection<ComentarioSolucion> getComentarioSolucionsByIdSolucion() {
        return comentarioSolucionsByIdSolucion;
    }

    public void setComentarioSolucionsByIdSolucion(Collection<ComentarioSolucion> comentarioSolucionsByIdSolucion) {
        this.comentarioSolucionsByIdSolucion = comentarioSolucionsByIdSolucion;
    }

    @ManyToOne
    @JoinColumn(name = "id_propuesta_final", referencedColumnName = "id_propuesta_final", nullable = false, insertable = false, updatable = false)
    public PropuestaFinal getPropuestaFinalByIdPropuestaFinal() {
        return propuestaFinalByIdPropuestaFinal;
    }

    public void setPropuestaFinalByIdPropuestaFinal(PropuestaFinal propuestaFinalByIdPropuestaFinal) {
        this.propuestaFinalByIdPropuestaFinal = propuestaFinalByIdPropuestaFinal;
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
