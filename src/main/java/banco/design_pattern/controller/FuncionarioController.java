package banco.design_pattern.controller;

import banco.design_pattern.model.Funcionario;
import banco.design_pattern.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private Funcionario.FuncionarioBuilder builderFuncionario;

    @GetMapping
    public List<Funcionario> listarTodas() {
        return funcionarioService.listarTodas();
    }

    @PostMapping
    public void salvarFuncionario(@RequestBody Funcionario funcionario){
        Funcionario func = builderFuncionario
                .nome(funcionario.getNome())
                .cargo(funcionario.getCargo())
                .salario(funcionario.getSalario())
                .idade(funcionario.getIdade())
                .build();

        funcionarioService.salvar(func);
    }
}
