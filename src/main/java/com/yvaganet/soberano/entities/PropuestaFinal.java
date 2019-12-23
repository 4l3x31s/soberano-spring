package com.yvaganet.soberano.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "propuesta_final", schema = "soberano", catalog = "")
public class PropuestaFinal {
    private long idPropuestaFinal;
    private long idUsuario;
    private String subArea;
    private String titulo;
    private String descripcion;
    private Timestamp fechaRegistro;
    private int estado;
    private Collection<Propuesta> propuestasByIdPropuestaFinal;
    private Usuario usuarioByIdUsuario;
    private Collection<Solucion> solucionsByIdPropuestaFinal;

    @Id
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
    @Column(name = "titulo", nullable = false, length = -1)
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

        PropuestaFinal that = (PropuestaFinal) o;

        if (idPropuestaFinal != that.idPropuestaFinal) return false;
        if (idUsuario != that.idUsuario) return false;
        if (estado != that.estado) return false;
        if (subArea != null ? !subArea.equals(that.subArea) : that.subArea != null) return false;
        if (titulo != null ? !titulo.equals(that.titulo) : that.titulo != null) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (fechaRegistro != null ? !fechaRegistro.equals(that.fechaRegistro) : that.fechaRegistro != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idPropuestaFinal ^ (idPropuestaFinal >>> 32));
        result = 31 * result + (int) (idUsuario ^ (idUsuario >>> 32));
        result = 31 * result + (subArea != null ? subArea.hashCode() : 0);
        result = 31 * result + (titulo != null ? titulo.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (fechaRegistro != null ? fechaRegistro.hashCode() : 0);
        result = 31 * result + estado;
        return result;
    }

    @OneToMany(mappedBy = "propuestaFinalByIdPropuestaFinal")
    public Collection<Propuesta> getPropuestasByIdPropuestaFinal() {
        return propuestasByIdPropuestaFinal;
    }

    public void setPropuestasByIdPropuestaFinal(Collection<Propuesta> propuestasByIdPropuestaFinal) {
        this.propuestasByIdPropuestaFinal = propuestasByIdPropuestaFinal;
    }

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false, insertable = false, updatable = false)
    public Usuario getUsuarioByIdUsuario() {
        return usuarioByIdUsuario;
    }

    public void setUsuarioByIdUsuario(Usuario usuarioByIdUsuario) {
        this.usuarioByIdUsuario = usuarioByIdUsuario;
    }

    @OneToMany(mappedBy = "propuestaFinalByIdPropuestaFinal")
    public Collection<Solucion> getSolucionsByIdPropuestaFinal() {
        return solucionsByIdPropuestaFinal;
    }

    public void setSolucionsByIdPropuestaFinal(Collection<Solucion> solucionsByIdPropuestaFinal) {
        this.solucionsByIdPropuestaFinal = solucionsByIdPropuestaFinal;
    }
}
