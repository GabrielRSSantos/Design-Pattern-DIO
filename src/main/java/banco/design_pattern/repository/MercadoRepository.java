package banco.design_pattern.repository;

import banco.design_pattern.model.Carrefour;
import org.springframework.data.repository.CrudRepository;

public interface MercadoRepository extends CrudRepository<Carrefour, Integer> {

}
