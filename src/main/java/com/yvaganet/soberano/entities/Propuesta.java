package com.yvaganet.soberano.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
public class Propuesta {
    private long idPropuesta;
    private int idArea;
    private long idUsuario;
    private Long idPropuestaFinal;
    private int idCiudad;
    private String subArea;
    private String titulo;
    private String descripcion;
    private Timestamp fechaRegistro;
    private Integer estado;
    private Collection<ComentarioPropuesta> comentarioPropuestasByIdPropuesta;
    private Area areaByIdArea;
    private Usuario usuarioByIdUsuario;
    private PropuestaFinal propuestaFinalByIdPropuestaFinal;
    private Ciudad ciudadByIdCiudad;

    @Id
    @Column(name = "id_propuesta", nullable = false)
    public long getIdPropuesta() {
        return idPropuesta;
    }

    public void setIdPropuesta(long idPropuesta) {
        this.idPropuesta = idPropuesta;
    }

    @Basic
    @Column(name = "id_area", nullable = false)
    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
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
    @Column(name = "id_propuesta_final", nullable = true)
    public Long getIdPropuestaFinal() {
        return idPropuestaFinal;
    }

    public void setIdPropuestaFinal(Long idPropuestaFinal) {
        this.idPropuestaFinal = idPropuestaFinal;
    }

    @Basic
    @Column(name = "id_ciudad", nullable = false)
    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    @Basic
    @Column(name = "sub_area", nullable = false, length = -1)
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

        Propuesta propuesta = (Propuesta) o;

        if (idPropuesta != propuesta.idPropuesta) return false;
        if (idArea != propuesta.idArea) return false;
        if (idUsuario != propuesta.idUsuario) return false;
        if (idCiudad != propuesta.idCiudad) return false;
        if (idPropuestaFinal != null ? !idPropuestaFinal.equals(propuesta.idPropuestaFinal) : propuesta.idPropuestaFinal != null)
            return false;
        if (subArea != null ? !subArea.equals(propuesta.subArea) : propuesta.subArea != null) return false;
        if (titulo != null ? !titulo.equals(propuesta.titulo) : propuesta.titulo != null) return false;
        if (descripcion != null ? !descripcion.equals(propuesta.descripcion) : propuesta.descripcion != null)
            return false;
        if (fechaRegistro != null ? !fechaRegistro.equals(propuesta.fechaRegistro) : propuesta.fechaRegistro != null)
            return false;
        if (estado != null ? !estado.equals(propuesta.estado) : propuesta.estado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idPropuesta ^ (idPropuesta >>> 32));
        result = 31 * result + idArea;
        result = 31 * result + (int) (idUsuario ^ (idUsuario >>> 32));
        result = 31 * result + (idPropuestaFinal != null ? idPropuestaFinal.hashCode() : 0);
        result = 31 * result + idCiudad;
        result = 31 * result + (subArea != null ? subArea.hashCode() : 0);
        result = 31 * result + (titulo != null ? titulo.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (fechaRegistro != null ? fechaRegistro.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "propuestaByIdPropuesta")
    public Collection<ComentarioPropuesta> getComentarioPropuestasByIdPropuesta() {
        return comentarioPropuestasByIdPropuesta;
    }

    public void setComentarioPropuestasByIdPropuesta(Collection<ComentarioPropuesta> comentarioPropuestasByIdPropuesta) {
        this.comentarioPropuestasByIdPropuesta = comentarioPropuestasByIdPropuesta;
    }

    @ManyToOne
    @JoinColumn(name = "id_area", referencedColumnName = "id_area", nullable = false, insertable = false, updatable = false)
    public Area getAreaByIdArea() {
        return areaByIdArea;
    }

    public void setAreaByIdArea(Area areaByIdArea) {
        this.areaByIdArea = areaByIdArea;
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
    @JoinColumn(name = "id_propuesta_final", referencedColumnName = "id_propuesta_final", insertable = false, updatable = false)
    public PropuestaFinal getPropuestaFinalByIdPropuestaFinal() {
        return propuestaFinalByIdPropuestaFinal;
    }

    public void setPropuestaFinalByIdPropuestaFinal(PropuestaFinal propuestaFinalByIdPropuestaFinal) {
        this.propuestaFinalByIdPropuestaFinal = propuestaFinalByIdPropuestaFinal;
    }

    @ManyToOne
    @JoinColumn(name = "id_ciudad", referencedColumnName = "id_ciudad", nullable = false, insertable = false, updatable = false)
    public Ciudad getCiudadByIdCiudad() {
        return ciudadByIdCiudad;
    }

    public void setCiudadByIdCiudad(Ciudad ciudadByIdCiudad) {
        this.ciudadByIdCiudad = ciudadByIdCiudad;
    }
}
