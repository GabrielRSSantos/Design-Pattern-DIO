package banco.design_pattern.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Carrefour implements IMercado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    private String nome;
    private String cep;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Funcionario> funcionarios;
    private List<Produto> produtos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
    }

    private Carrefour(MercadoBuilder builder){
        this.nome = builder.nome;
        this.cep = builder.cep;
        this.funcionarios = builder.funcionarios;
        this.produtos = builder.produtos;
    }

    public static class MercadoBuilder {
        private String nome;
        private String cep;
        private List<Funcionario> funcionarios;
        private List<Produto> produtos;

        public MercadoBuilder nome(String nome){
            this.nome = nome;
            return this;
        }

        public MercadoBuilder cep(String cep){
            this.cep = cep;
            return this;
        }

        public MercadoBuilder funcionarios(List<Funcionario> funcionarios){
            this.funcionarios = funcionarios;
            return this;
        }

        public MercadoBuilder produtos(List<Produto> produtos){
            this.produtos = produtos;
            return this;
        }

        public IMercado build(){
            return new Carrefour(this);
        }
    }

    @Override
    public void contratarFuncionario(Funcionario func) {
        this.funcionarios.add(func);
    }

    @Override
    public void mostrarFuncionarios() {
        this.funcionarios.forEach(func -> {
            System.out.println(func);
        });
    }

    @Override
    public void mostrarProdutos() {
        this.produtos.forEach(produto -> {
            System.out.println("Produto: " + produto.getNome() + " Qty: " + produto.getQuantidade());
        });
    }
}
