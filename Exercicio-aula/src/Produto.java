public class Produto {
    private String nome;
    private int quantidade;
    private String categoria;

    public Produto(String nome, int quantidade, String categoria) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "Produto: " + nome + ", Quantidade: " + quantidade + ", Categoria: " + categoria;
    }
}