package exc1;

/*Implemente a classe Produto com atributos privados nome, preco e
quantidadeEmEstoque. Forneça getters e setters com validações: preco e
quantidadeEmEstoque não podem ser negativos e nome não pode ser nulo ou
vazio. Lance IllegalArgumentException em casos inválidos. Demonstre o uso
criando instâncias, alterando valores válidos e tentando atribuições inválidas.*/

public class Produto {
    private  String nome;
    private double preco;
    private int quantidadeEmEstoque;

    public Produto(String nome, double preco, int quantidadeEmEstoque) {
        setNome(nome);
        setPreco(preco);
        setQuantidadeEmEstoque(quantidadeEmEstoque);
    }

    public String getNome() {return nome;}
    public void setNome(String nome) {
        if(nome == null || nome.isEmpty()){
            throw new IllegalArgumentException("O nome deve ser informado.");
        }
        this.nome = nome;
    }

    public double getPreco() {return preco;}
    public void setPreco(double preco) {
        if(preco <= 0){
            throw new IllegalArgumentException("O preço deve ser um valor positivo.");
        }
        this.preco = preco;
    }

    public int getQuantidadeEmEstoque() {return quantidadeEmEstoque;}
    public  void setQuantidadeEmEstoque(int quantidadeEmEstoque){
        if(quantidadeEmEstoque <= 0){
            throw new IllegalArgumentException("A quantidadeEmEstoque deve ser um valor positivo.");
        }
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }
    public void exibirInformacoes(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Preço: " + this.preco);
        System.out.println("Quantidade em estoque: " + this.quantidadeEmEstoque);
    }

    public static void main(String[] args){
        try{
            Produto produto = new Produto("Caneca",12.99, 20 );
            produto.exibirInformacoes();
        }catch(IllegalArgumentException ex) {
            ex.printStackTrace();
        }

        try{
            Produto produtoInvalido = new Produto("Lixeira", 40, -10);
            produtoInvalido.exibirInformacoes();
        }catch(IllegalArgumentException ex) {
            System.out.println("Erro:" + ex.getMessage());;
        }

        try {
            Produto p = new Produto("Copo", 5.0, 10);
            p.setPreco(8.0);
            p.setQuantidadeEmEstoque(15);
            p.setNome("");
        } catch (IllegalArgumentException ex) {
            System.out.println("Erro:" + ex.getMessage());
        }
    }

}
