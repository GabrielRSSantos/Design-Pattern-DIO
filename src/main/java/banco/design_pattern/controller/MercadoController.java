package banco.design_pattern.controller;

import banco.design_pattern.model.Carrefour;
import banco.design_pattern.model.IMercado;
import banco.design_pattern.service.MercadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrefour")
public class MercadoController {

    @Autowired
    private MercadoService mercadoService;

    @GetMapping
    public List<IMercado> listarTodas() {
        return mercadoService.listarTodas();
    }

    @PostMapping
    public void salvarMercado(@RequestBody Carrefour mercado){
        mercadoService.salvar(mercado);
    }
}
