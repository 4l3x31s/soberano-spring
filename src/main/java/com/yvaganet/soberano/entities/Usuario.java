package com.yvaganet.soberano.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
public class Usuario {
    private long idUsuario;
    private int idRol;
    private int idCiudad;
    private String nombreCompleto;
    private String documentoIdentidad;
    private String email;
    private Integer telefono;
    private int celular;
    private String direccion;
    private Timestamp fechaRegistro;
    private int estado;
    private Collection<ComentarioPropuesta> comentarioPropuestasByIdUsuario;
    private Collection<ComentarioSolucion> comentarioSolucionsByIdUsuario;
    private Collection<Propuesta> propuestasByIdUsuario;
    private Collection<PropuestaFinal> propuestaFinalsByIdUsuario;
    private Collection<Solucion> solucionsByIdUsuario;
    private Collection<TasaAceptacion> tasaAceptacionsByIdUsuario;
    private Rol rolByIdRol;
    private Ciudad ciudadByIdCiudad;

    @Id
    @Column(name = "id_usuario", nullable = false)
    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Basic
    @Column(name = "id_rol", nullable = false)
    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
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
    @Column(name = "nombre_completo", nullable = false, length = -1)
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    @Basic
    @Column(name = "documento_identidad", nullable = true, length = 25)
    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    @Basic
    @Column(name = "email", nullable = true, length = -1)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "telefono", nullable = true)
    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    @Basic
    @Column(name = "celular", nullable = false)
    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    @Basic
    @Column(name = "direccion", nullable = true, length = -1)
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Basic
    @Column(name = "fecha_registro", nullable = true)
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

        Usuario usuario = (Usuario) o;

        if (idUsuario != usuario.idUsuario) return false;
        if (idRol != usuario.idRol) return false;
        if (idCiudad != usuario.idCiudad) return false;
        if (celular != usuario.celular) return false;
        if (estado != usuario.estado) return false;
        if (nombreCompleto != null ? !nombreCompleto.equals(usuario.nombreCompleto) : usuario.nombreCompleto != null)
            return false;
        if (documentoIdentidad != null ? !documentoIdentidad.equals(usuario.documentoIdentidad) : usuario.documentoIdentidad != null)
            return false;
        if (email != null ? !email.equals(usuario.email) : usuario.email != null) return false;
        if (telefono != null ? !telefono.equals(usuario.telefono) : usuario.telefono != null) return false;
        if (direccion != null ? !direccion.equals(usuario.direccion) : usuario.direccion != null) return false;
        if (fechaRegistro != null ? !fechaRegistro.equals(usuario.fechaRegistro) : usuario.fechaRegistro != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUsuario ^ (idUsuario >>> 32));
        result = 31 * result + idRol;
        result = 31 * result + idCiudad;
        result = 31 * result + (nombreCompleto != null ? nombreCompleto.hashCode() : 0);
        result = 31 * result + (documentoIdentidad != null ? documentoIdentidad.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (telefono != null ? telefono.hashCode() : 0);
        result = 31 * result + celular;
        result = 31 * result + (direccion != null ? direccion.hashCode() : 0);
        result = 31 * result + (fechaRegistro != null ? fechaRegistro.hashCode() : 0);
        result = 31 * result + estado;
        return result;
    }

    @OneToMany(mappedBy = "usuarioByIdUsuario")
    public Collection<ComentarioPropuesta> getComentarioPropuestasByIdUsuario() {
        return comentarioPropuestasByIdUsuario;
    }

    public void setComentarioPropuestasByIdUsuario(Collection<ComentarioPropuesta> comentarioPropuestasByIdUsuario) {
        this.comentarioPropuestasByIdUsuario = comentarioPropuestasByIdUsuario;
    }

    @OneToMany(mappedBy = "usuarioByIdUsuario")
    public Collection<ComentarioSolucion> getComentarioSolucionsByIdUsuario() {
        return comentarioSolucionsByIdUsuario;
    }

    public void setComentarioSolucionsByIdUsuario(Collection<ComentarioSolucion> comentarioSolucionsByIdUsuario) {
        this.comentarioSolucionsByIdUsuario = comentarioSolucionsByIdUsuario;
    }

    @OneToMany(mappedBy = "usuarioByIdUsuario")
    public Collection<Propuesta> getPropuestasByIdUsuario() {
        return propuestasByIdUsuario;
    }

    public void setPropuestasByIdUsuario(Collection<Propuesta> propuestasByIdUsuario) {
        this.propuestasByIdUsuario = propuestasByIdUsuario;
    }

    @OneToMany(mappedBy = "usuarioByIdUsuario")
    public Collection<PropuestaFinal> getPropuestaFinalsByIdUsuario() {
        return propuestaFinalsByIdUsuario;
    }

    public void setPropuestaFinalsByIdUsuario(Collection<PropuestaFinal> propuestaFinalsByIdUsuario) {
        this.propuestaFinalsByIdUsuario = propuestaFinalsByIdUsuario;
    }

    @OneToMany(mappedBy = "usuarioByIdUsuario")
    public Collection<Solucion> getSolucionsByIdUsuario() {
        return solucionsByIdUsuario;
    }

    public void setSolucionsByIdUsuario(Collection<Solucion> solucionsByIdUsuario) {
        this.solucionsByIdUsuario = solucionsByIdUsuario;
    }

    @OneToMany(mappedBy = "usuarioByIdUsuario")
    public Collection<TasaAceptacion> getTasaAceptacionsByIdUsuario() {
        return tasaAceptacionsByIdUsuario;
    }

    public void setTasaAceptacionsByIdUsuario(Collection<TasaAceptacion> tasaAceptacionsByIdUsuario) {
        this.tasaAceptacionsByIdUsuario = tasaAceptacionsByIdUsuario;
    }

    @ManyToOne
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol", nullable = false, insertable = false, updatable = false)
    public Rol getRolByIdRol() {
        return rolByIdRol;
    }

    public void setRolByIdRol(Rol rolByIdRol) {
        this.rolByIdRol = rolByIdRol;
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
