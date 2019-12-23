package com.yvaganet.soberano.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Rol {
    private int idRol;
    private String nombreRol;
    private int estado;
    private Collection<Usuario> usuariosByIdRol;

    @Id
    @Column(name = "id_rol", nullable = false)
    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    @Basic
    @Column(name = "nombre_rol", nullable = false, length = 150)
    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
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

        Rol rol = (Rol) o;

        if (idRol != rol.idRol) return false;
        if (estado != rol.estado) return false;
        if (nombreRol != null ? !nombreRol.equals(rol.nombreRol) : rol.nombreRol != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRol;
        result = 31 * result + (nombreRol != null ? nombreRol.hashCode() : 0);
        result = 31 * result + estado;
        return result;
    }

    @OneToMany(mappedBy = "rolByIdRol")
    public Collection<Usuario> getUsuariosByIdRol() {
        return usuariosByIdRol;
    }

    public void setUsuariosByIdRol(Collection<Usuario> usuariosByIdRol) {
        this.usuariosByIdRol = usuariosByIdRol;
    }
}
