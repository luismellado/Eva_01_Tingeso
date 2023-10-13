package tingeso.proyecto1.services;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tingeso.proyecto1.entities.CuotaEntity;
import tingeso.proyecto1.repositories.CuotaRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CuotaService {
    @Autowired
    CuotaRepository cuotaRepository;
    public ArrayList<CuotaEntity> obtenerCuotas(){
        return (ArrayList<CuotaEntity>) cuotaRepository.findAll();
    }

    public CuotaEntity guardarCuota(CuotaEntity cuota){ return cuotaRepository.save(cuota); }

    public Optional<CuotaEntity> obtenerPorId(Integer id) { return cuotaRepository.findById(id); }

    public boolean eliminarCuota(Integer id){
        try{
            cuotaRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }
}
