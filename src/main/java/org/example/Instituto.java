package org.example;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "Instituto")
@Entity
public class Instituto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "n_alumnos")
    private Integer nAlumnos;


    public void setId(int i) {
        this.id = i;
    }

    public void setNAlumnos(int i) {
        this.nAlumnos = i;
    }


    public void setNombre(String s) {
        this.nombre = s;
    }

    @Override
    public String toString() {
        return "Instituto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nAlumnos=" + nAlumnos +
                '}';
    }
}