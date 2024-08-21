package banco.design_pattern.service;

import banco.design_pattern.model.Funcionario;
import banco.design_pattern.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> listarTodas() {
        return (List<Funcionario>) funcionarioRepository.findAll();
    }

    public Optional<Funcionario> buscarPorId(int id) {
        return funcionarioRepository.findById(id);
    }

    public Funcionario salvar(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public void deletar(int id) {
        funcionarioRepository.deleteById(id);
    }
}
