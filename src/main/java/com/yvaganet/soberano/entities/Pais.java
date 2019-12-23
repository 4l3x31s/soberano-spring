package com.yvaganet.soberano.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Pais {
    private int idPais;
    private String nombrePais;
    private int estado;
    private Collection<Ciudad> ciudadsByIdPais;

    @Id
    @Column(name = "id_pais", nullable = false)
    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    @Basic
    @Column(name = "nombre_pais", nullable = false, length = 200)
    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
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

        Pais pais = (Pais) o;

        if (idPais != pais.idPais) return false;
        if (estado != pais.estado) return false;
        if (nombrePais != null ? !nombrePais.equals(pais.nombrePais) : pais.nombrePais != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPais;
        result = 31 * result + (nombrePais != null ? nombrePais.hashCode() : 0);
        result = 31 * result + estado;
        return result;
    }

    @OneToMany(mappedBy = "paisByIdPais")
    public Collection<Ciudad> getCiudadsByIdPais() {
        return ciudadsByIdPais;
    }

    public void setCiudadsByIdPais(Collection<Ciudad> ciudadsByIdPais) {
        this.ciudadsByIdPais = ciudadsByIdPais;
    }
}
