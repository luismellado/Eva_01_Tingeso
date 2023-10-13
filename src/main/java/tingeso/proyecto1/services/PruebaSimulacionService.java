package tingeso.proyecto1.services;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tingeso.proyecto1.entities.PruebaSimulacionEntity;
import tingeso.proyecto1.repositories.PruebaSimulacionRepository;

import java.util.ArrayList;
import java.util.Optional;

public class PruebaSimulacionService {

    @Autowired
    PruebaSimulacionRepository pruebaSimulacionRepository;
    public ArrayList<PruebaSimulacionEntity> obtenerPruebasSimulacion(){
        return (ArrayList<PruebaSimulacionEntity>) pruebaSimulacionRepository.findAll();
    }

    public PruebaSimulacionEntity guardarPruebaSimulacion(PruebaSimulacionEntity pruebaSimulacion){ return pruebaSimulacionRepository.save(pruebaSimulacion); }

    public Optional<PruebaSimulacionEntity> obtenerPorId(Integer id) { return pruebaSimulacionRepository.findById(id); }

    public boolean eliminarPruebaSimulacion(Integer id){
        try{
            pruebaSimulacionRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }
}
