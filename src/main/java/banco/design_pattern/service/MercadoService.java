package banco.design_pattern.service;

import banco.design_pattern.model.IMercado;
import banco.design_pattern.repository.MercadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MercadoService {

    @Autowired
    private MercadoRepository mercadoRepository;

    public List<IMercado> listarTodas() {
        return (List<IMercado>) mercadoRepository.findAll();
    }

    public Optional<IMercado> buscarPorId(int id) {
        return mercadoRepository.findById(id);
    }

    public IMercado salvar(IMercado mercado) {
        return mercadoRepository.save(mercado);
    }

    public void deletar(int id) {
        mercadoRepository.deleteById(id);
    }
}
