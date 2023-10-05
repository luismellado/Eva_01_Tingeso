package tingeso.proyecto1.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tingeso.proyecto1.entities.EstudianteEntity;

@Repository
public interface EstudianteRepository extends CrudRepository<EstudianteEntity, Integer> {

}
