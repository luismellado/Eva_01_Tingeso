package tingeso.proyecto1.services;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Service;
import tingeso.proyecto1.entities.CuotaEntity;
import tingeso.proyecto1.entities.EstudianteEntity;
import tingeso.proyecto1.entities.PruebaSimulacionEntity;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

@Service
public class OficinaRRHH {

    //Verificar si se puede asignar la cantidad de cuotas segun el tipo de colegio
    public boolean verificarCantidadCuotas(EstudianteEntity estudiante, Integer cantidadCuotas){
        if (estudiante.getTipo_colegio_procedencia().equals("Municipal") && cantidadCuotas > 1 && cantidadCuotas < 11){
            return true;
        }
        else{
            if (estudiante.getTipo_colegio_procedencia().equals("Subvencionado") && cantidadCuotas > 1 && cantidadCuotas < 8) {
                return true;
            }
            else{
                if (estudiante.getTipo_colegio_procedencia().equals("Privado") && cantidadCuotas > 1 && cantidadCuotas < 5){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
    }

    public void aplicarDescuentoTipoColegio(ArrayList<CuotaEntity> cuotasEstudiante, String tipoColegio) {
        if (tipoColegio.equals("Municipal")) {
            for (CuotaEntity cuota : cuotasEstudiante) {
                cuota.setValor_cuota(cuota.getValor_cuota() * 0.8);
            }
        }
        else {
            if (tipoColegio.equals("Subvencionado")) {
                for (CuotaEntity cuota : cuotasEstudiante) {
                    cuota.setValor_cuota(cuota.getValor_cuota() * 0.9);
                }
            }
            else {
                if (tipoColegio.equals("Privado")){
                    System.out.println("No se aplican descuentos por tipo de colegio para privados.");
                }
                else {
                    System.out.println("Valor de tipo de colegio ingresado no es valido.");
                }
            }
        }
    }
    public Integer obtenerAnioActual(){
        Date date = new Date();
        ZoneId timeZone = ZoneId.systemDefault();
        LocalDate getLocalDate = date.toInstant().atZone(timeZone).toLocalDate();
        Integer anioActual = getLocalDate.getYear();
        return anioActual;
    }

    public Integer obtenerMesActual(){
        Date date = new Date();
        ZoneId timeZone = ZoneId.systemDefault();
        LocalDate getLocalDate = date.toInstant().atZone(timeZone).toLocalDate();
        Integer mesActual = getLocalDate.getMonthValue();
        return mesActual;
    }

    public void aplicarDescuentoAnioEgreso(ArrayList<CuotaEntity> cuotasEstudiante, Integer anioEgreso){
        Integer anioActual = obtenerAnioActual();
        Integer aniosDesdeEgreso = anioActual - anioEgreso;
        if (aniosDesdeEgreso < 1){
            for (CuotaEntity cuota : cuotasEstudiante) {
                cuota.setValor_cuota(cuota.getValor_cuota() * 0.85);
            }
        }
        else {
            if (aniosDesdeEgreso >= 1 && aniosDesdeEgreso <= 2){
                for (CuotaEntity cuota : cuotasEstudiante) {
                    cuota.setValor_cuota(cuota.getValor_cuota() * 0.92);
                }
            }
            else {
                if (aniosDesdeEgreso >= 3 && aniosDesdeEgreso <= 4){
                    for (CuotaEntity cuota : cuotasEstudiante) {
                        cuota.setValor_cuota(cuota.getValor_cuota() * 0.96);
                    }
                }
                else {
                    System.out.println("No se aplica descuento de egreso para este estudiante.");
                }
            }
        }
    }
    //El array que deberia entrar aqui es uno que tenga el filtro de puntajes correspondiente a pruebas rendidas el mismo mes
    public Integer calcularPromedioPruebas(ArrayList<PruebaSimulacionEntity> pruebas){
        Integer acumulador = 0;
        for (PruebaSimulacionEntity prueba: pruebas) {
            acumulador = acumulador + prueba.getPuntaje();
        }
        Integer promedioPuntajes = acumulador/pruebas.size();
        return promedioPuntajes;
    }

    //La lista de cuotas del estudiante corresponden a todas las cuotas posteriores a la rendicion de la prueba que aun esten pendientes de pago
    public void aplicarDescuentoPruebas(ArrayList<CuotaEntity> cuotasEstudiante, Integer promedioPuntajes){
        if (promedioPuntajes >= 950 && promedioPuntajes <= 1000) {
            for (CuotaEntity cuota : cuotasEstudiante) {
                cuota.setValor_cuota(cuota.getValor_cuota() * 0.90);
            }
        }
        else{
            if (promedioPuntajes >= 900 && promedioPuntajes <= 949) {
                for (CuotaEntity cuota : cuotasEstudiante) {
                    cuota.setValor_cuota(cuota.getValor_cuota() * 0.95);
                }
            }
            else {
                if (promedioPuntajes >= 850 && promedioPuntajes <= 899) {
                    for (CuotaEntity cuota : cuotasEstudiante) {
                        cuota.setValor_cuota(cuota.getValor_cuota() * 0.98);
                    }
                }
                else {
                    System.out.println("Promedio de pruebas no figura para descuento.");
                }
            }
        }
    }

    public void aplicarInteresAtraso(ArrayList<CuotaEntity> cuotasEstudiante){
        Integer mesActual = obtenerMesActual();
        for (CuotaEntity cuota: cuotasEstudiante) {
            if (cuota.getEstado_cuota().equals("Pendiente")){
                if((mesActual - cuota.getFecha_pago().getMonth()) > 3){
                    cuota.setValor_cuota(cuota.getValor_cuota()*1.15);
                }
                else {
                    if((mesActual - cuota.getFecha_pago().getMonth()) == 3){
                        cuota.setValor_cuota(cuota.getValor_cuota()*1.09);
                    }
                    else {
                        if((mesActual - cuota.getFecha_pago().getMonth()) == 2){
                            cuota.setValor_cuota(cuota.getValor_cuota()*1.06);
                        }
                        else {
                            if((mesActual - cuota.getFecha_pago().getMonth()) == 1){
                                cuota.setValor_cuota(cuota.getValor_cuota()*1.03);
                            }
                            else {
                                System.out.println("No se aplica interes para la cuota " + cuota.getId_cuotas() + ".");
                            }
                        }
                    }
                }
            }
            else {
                System.out.println("La cuota " + cuota.getId_cuotas() + " esta pagada.");
            }
        }
    }
}
