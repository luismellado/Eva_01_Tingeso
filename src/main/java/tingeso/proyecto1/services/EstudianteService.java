package tingeso.proyecto1.services;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tingeso.proyecto1.entities.EstudianteEntity;
import tingeso.proyecto1.repositories.EstudianteRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EstudianteService {

    @Autowired
    EstudianteRepository estudianteRepository;
    public ArrayList<EstudianteEntity> obtenerEstudiantes(){
        return (ArrayList<EstudianteEntity>) estudianteRepository.findAll();
    }

    public EstudianteEntity guardarEstudiante(EstudianteEntity estudiante){ return estudianteRepository.save(estudiante); }

    public Optional<EstudianteEntity> obtenerPorId(Integer id) { return estudianteRepository.findById(id); }

    public boolean eliminarEstudiante(Integer id){
        try{
            estudianteRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }
}
