package org.example;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Alumno")
public class Alumno implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "dni", insertable = false, nullable = false)
    private Integer dni;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "clase_id", nullable = false)
    private Integer claseId;

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setClaseId(Integer claseId) {
        this.claseId = claseId;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", claseId=" + claseId +
                '}';
    }
}