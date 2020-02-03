package org.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Clase")
public class Clase implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "rama")
    private String rama;

    @Column(name = "n_Alumnos")
    private Integer nAlumnos;

    @Column(name = "instituto_id", nullable = false)
    private Integer institutoId;


    public void setId(int i) {
        this.id = i;
    }

    public void setInstitutoId(int i) {
        this.institutoId = i;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRama(String rama) {
        this.rama = rama;
    }

    public void setnAlumnos(Integer nAlumnos) {
        this.nAlumnos = nAlumnos;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRama() {
        return rama;
    }

    public Integer getnAlumnos() {
        return nAlumnos;
    }

    public Integer getInstitutoId() {
        return institutoId;
    }

    @Override
    public String toString() {
        return "Clase{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", rama='" + rama + '\'' +
                ", nAlumnos=" + nAlumnos +
                ", institutoId=" + institutoId +
                '}';
    }
}