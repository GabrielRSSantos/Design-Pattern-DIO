package banco.design_pattern.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nome;
    private int idade;
    private String cargo;
    private double salario;

    public Funcionario(){}

    private Funcionario(FuncionarioBuilder builder) {
        this.nome = builder.nome;
        this.idade = builder.idade;
        this.cargo = builder.cargo;
        this.salario = builder.salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Component
    public static class FuncionarioBuilder {

        private String nome;
        private int idade;
        private String cargo;
        private double salario;

        public FuncionarioBuilder nome(String nome){
            this.nome = nome;
            return this;
        }

        public FuncionarioBuilder cargo(String cargo){
            this.cargo = cargo;
            return this;
        }

        public FuncionarioBuilder idade(int idade){
            this.idade = idade;
            return this;
        }

        public FuncionarioBuilder salario(double salario){
            this.salario = salario;
            return this;
        }

        public Funcionario build(){
            return new Funcionario(this);
        }
    }
}
