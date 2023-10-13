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
}
