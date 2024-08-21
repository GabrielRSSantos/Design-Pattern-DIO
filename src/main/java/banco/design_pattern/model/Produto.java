package banco.design_pattern.model;

public class Produto {
    private String nome;
    private int quantidade;

    public Produto(String nome, int qnt){
        this.nome = nome;
        this.quantidade = qnt;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
