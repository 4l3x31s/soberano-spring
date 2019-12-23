package com.yvaganet.soberano.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Area {
    private int idArea;
    private String nombreArea;
    private int estado;
    private Collection<Propuesta> propuestasByIdArea;

    @Id
    @Column(name = "id_area", nullable = false)
    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    @Basic
    @Column(name = "nombre_area", nullable = false, length = 200)
    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
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

        Area area = (Area) o;

        if (idArea != area.idArea) return false;
        if (estado != area.estado) return false;
        if (nombreArea != null ? !nombreArea.equals(area.nombreArea) : area.nombreArea != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idArea;
        result = 31 * result + (nombreArea != null ? nombreArea.hashCode() : 0);
        result = 31 * result + estado;
        return result;
    }

    @OneToMany(mappedBy = "areaByIdArea")
    public Collection<Propuesta> getPropuestasByIdArea() {
        return propuestasByIdArea;
    }

    public void setPropuestasByIdArea(Collection<Propuesta> propuestasByIdArea) {
        this.propuestasByIdArea = propuestasByIdArea;
    }
}
