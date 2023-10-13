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
}
