package banco.design_pattern.repository;

import banco.design_pattern.model.Funcionario;
import org.springframework.data.repository.CrudRepository;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer> {
}
