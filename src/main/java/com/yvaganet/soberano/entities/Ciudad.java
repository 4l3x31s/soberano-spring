package com.yvaganet.soberano.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Ciudad {
    private int idCiudad;
    private int idPais;
    private String nombreCiudad;
    private int estado;
    private Pais paisByIdPais;
    private Collection<Propuesta> propuestasByIdCiudad;
    private Collection<Usuario> usuariosByIdCiudad;

    @Id
    @Column(name = "id_ciudad", nullable = false)
    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    @Basic
    @Column(name = "id_pais", nullable = false)
    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    @Basic
    @Column(name = "nombre_ciudad", nullable = false, length = 150)
    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
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

        Ciudad ciudad = (Ciudad) o;

        if (idCiudad != ciudad.idCiudad) return false;
        if (idPais != ciudad.idPais) return false;
        if (estado != ciudad.estado) return false;
        if (nombreCiudad != null ? !nombreCiudad.equals(ciudad.nombreCiudad) : ciudad.nombreCiudad != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCiudad;
        result = 31 * result + idPais;
        result = 31 * result + (nombreCiudad != null ? nombreCiudad.hashCode() : 0);
        result = 31 * result + estado;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_pais", referencedColumnName = "id_pais", nullable = false, insertable = false, updatable = false)
    public Pais getPaisByIdPais() {
        return paisByIdPais;
    }

    public void setPaisByIdPais(Pais paisByIdPais) {
        this.paisByIdPais = paisByIdPais;
    }

    @OneToMany(mappedBy = "ciudadByIdCiudad")
    public Collection<Propuesta> getPropuestasByIdCiudad() {
        return propuestasByIdCiudad;
    }

    public void setPropuestasByIdCiudad(Collection<Propuesta> propuestasByIdCiudad) {
        this.propuestasByIdCiudad = propuestasByIdCiudad;
    }

    @OneToMany(mappedBy = "ciudadByIdCiudad")
    public Collection<Usuario> getUsuariosByIdCiudad() {
        return usuariosByIdCiudad;
    }

    public void setUsuariosByIdCiudad(Collection<Usuario> usuariosByIdCiudad) {
        this.usuariosByIdCiudad = usuariosByIdCiudad;
    }
}
