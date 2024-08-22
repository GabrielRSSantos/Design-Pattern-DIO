package banco.design_pattern;

import banco.design_pattern.model.Carrefour;
import banco.design_pattern.model.Funcionario;
import banco.design_pattern.model.IMercado;
import banco.design_pattern.model.Produto;
import banco.design_pattern.repository.ProdutoRepository;
import banco.design_pattern.service.MercadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;

import java.util.List;

@OpenAPIDefinition(servers = { @Server(url = "/", description = "Default Server URL") })
@SpringBootApplication
public class DesignPatternApplication {

	@Autowired
	private MercadoService mercadoService;

	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(DesignPatternApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() {
		return args -> {

			List<Funcionario> funcionarios = List.of(
					new Funcionario.FuncionarioBuilder()
							.nome("Gabriel")
							.cargo("Gerente")
							.idade(29)
							.salario(6000.00)
							.build(),
					new Funcionario.FuncionarioBuilder()
							.nome("Ana")
							.idade(22)
							.cargo("Caixa")
							.salario(1900.00)
							.build()
			);

			List<Produto> produtos = List.of(
					new Produto("Maça", 100),
					new Produto("Banana", 20),
					new Produto("Pão", 10)
			);

			Carrefour carrefour = (Carrefour) new Carrefour.MercadoBuilder()
					.nome("Carrefour")
					.cep("18035-490")
					.funcionarios(funcionarios)
					.produtos(produtos)
					.build();

			mercadoService.salvar(carrefour);
		};
	}

}
