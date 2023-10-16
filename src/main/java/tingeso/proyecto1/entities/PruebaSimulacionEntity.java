package tingeso.proyecto1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Entity
@Table(name="prueba_simulacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PruebaSimulacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)

    private Integer id_prueba_simulacion;
    private String rut_estudiante;
    private Date fecha_prueba;
    private Integer puntaje;
    private Integer id_estudiantes;

    public Integer getId_prueba_simulacion() {
        return id_prueba_simulacion;
    }

    public void setId_prueba_simulacion(Integer id_prueba_simulacion) {
        this.id_prueba_simulacion = id_prueba_simulacion;
    }

    public String getRut_estudiante() {
        return rut_estudiante;
    }

    public void setRut_estudiante(String rut_estudiante) {
        this.rut_estudiante = rut_estudiante;
    }

    public Date getFecha_prueba() {
        return fecha_prueba;
    }

    public void setFecha_prueba(Date fecha_prueba) {
        this.fecha_prueba = fecha_prueba;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    public Integer getId_estudiantes() {
        return id_estudiantes;
    }

    public void setId_estudiantes(Integer id_estudiantes) {
        this.id_estudiantes = id_estudiantes;
    }
}
