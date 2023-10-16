package tingeso.proyecto1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name="estudiantes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)

    private Integer id_estudiantes;
    private String rut;
    private String apellidos;
    private String nombres;
    private Date fecha_nacimiento;
    private String tipo_colegio_procedencia;
    private String nombre_colegio;
    private Integer anyo_egreso;

    public Integer getId_estudiantes() {
        return id_estudiantes;
    }

    public void setId_estudiantes(Integer id_estudiantes) {
        this.id_estudiantes = id_estudiantes;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getTipo_colegio_procedencia() {
        return tipo_colegio_procedencia;
    }

    public void setTipo_colegio_procedencia(String tipo_colegio_procedencia) {
        this.tipo_colegio_procedencia = tipo_colegio_procedencia;
    }

    public String getNombre_colegio() {
        return nombre_colegio;
    }

    public void setNombre_colegio(String nombre_colegio) {
        this.nombre_colegio = nombre_colegio;
    }

    public Integer getAnyo_egreso() {
        return anyo_egreso;
    }

    public void setAnyo_egreso(Integer anyo_egreso) {
        this.anyo_egreso = anyo_egreso;
    }
}
