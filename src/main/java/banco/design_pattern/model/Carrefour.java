package banco.design_pattern.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Carrefour implements IMercado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nome;
    private String cep;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Funcionario> funcionarios = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Produto> produtos = new ArrayList<>();

    public Carrefour() {
    }

    private Carrefour(MercadoBuilder builder) {
        this.nome = builder.nome;
        this.cep = builder.cep;
        this.funcionarios = builder.funcionarios != null ? builder.funcionarios : new ArrayList<>();
        this.produtos = builder.produtos != null ? builder.produtos : new ArrayList<>();
    }

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

    public void addFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public static class MercadoBuilder {
        private String nome;
        private String cep;
        private List<Funcionario> funcionarios;
        private List<Produto> produtos;

        public MercadoBuilder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public MercadoBuilder cep(String cep) {
            this.cep = cep;
            return this;
        }

        public MercadoBuilder funcionarios(List<Funcionario> funcionarios) {
            this.funcionarios = funcionarios;
            return this;
        }

        public MercadoBuilder produtos(List<Produto> produtos) {
            this.produtos = produtos;
            return this;
        }

        public Carrefour build() {
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
