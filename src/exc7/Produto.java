package exc7;

public class Produto implements Identificavel<Integer>{
    private final Integer id;
    private final String nome;
    private final double preco;

    public Produto(Integer id, String nome, double preco){
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Integer getId(){
        return id;
    }
    public String getNome(){
        return nome;
    }
    public double getPreco(){
        return preco;
    }
}
