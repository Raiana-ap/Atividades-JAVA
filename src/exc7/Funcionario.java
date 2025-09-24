package exc7;

public class Funcionario implements Identificavel<String>{
    private final String id;
    private final String nome;
    private final double cargo;

    public Funcionario(String id, String nome, double cargo){
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
    }

    public String getId(){
        return id;
    }
    public String getNome(){
        return nome;
    }
    public double getCargo(){
        return cargo;
    }
}
