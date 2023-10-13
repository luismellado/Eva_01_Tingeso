package tingeso.proyecto1.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tingeso.proyecto1.entities.CuotaEntity;

public interface CuotaRepository extends CrudRepository<CuotaEntity, Integer>{
}
