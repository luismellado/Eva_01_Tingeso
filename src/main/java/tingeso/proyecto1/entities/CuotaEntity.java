package tingeso.proyecto1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name="cuotas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CuotaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)

    private Integer id_cuotas;
    private Double valor_cuota;
    private Date fecha_pago;
    private String estado_cuota;
    private Integer id_estudiantes;

    public Integer getId_cuotas() {
        return id_cuotas;
    }

    public void setId_cuotas(Integer id_cuotas) {
        this.id_cuotas = id_cuotas;
    }

    public Double getValor_cuota() {
        return valor_cuota;
    }

    public void setValor_cuota(Double valor_cuota) {
        this.valor_cuota = valor_cuota;
    }

    public Date getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(Date fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public String getEstado_cuota() {
        return estado_cuota;
    }

    public void setEstado_cuota(String estado_cuota) {
        this.estado_cuota = estado_cuota;
    }

    public Integer getId_estudiantes() {
        return id_estudiantes;
    }

    public void setId_estudiantes(Integer id_estudiantes) {
        this.id_estudiantes = id_estudiantes;
    }
}
