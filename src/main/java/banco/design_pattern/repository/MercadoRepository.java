package banco.design_pattern.repository;

import banco.design_pattern.model.IMercado;
import org.springframework.data.repository.CrudRepository;

public interface MercadoRepository extends CrudRepository<IMercado, Integer> {

}
