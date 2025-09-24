package exc2;

/* Estenda Produto com o metodo aplicarDesconto(double porcentagem).
 Permita apenas valores entre 0 e 50 (inclusive) e lance exceção (IllegalArgumentException
ou DescontoInvalidoException) se a regra for violada. Mostre, em um main ou
testes, o preço antes/depois do desconto e a reação a entradas inválidas.*/
class DescontoInvalidoException extends IllegalArgumentException {
    public DescontoInvalidoException(String message) {
        super(message);
    }
}

public class ProdutoExtendido {
    private  String nome;
    private double preco;
    private int quantidadeEmEstoque;

    public ProdutoExtendido(String nome, double preco, int quantidadeEmEstoque) {
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
    public void aplicarDesconto(double porcentagem){
        if(porcentagem <= 0 || porcentagem > 50){
            throw new DescontoInvalidoException("A porcentagem de desconto é inválida.");
        }
        double valorDesconto = preco * porcentagem / 100;
        System.out.println("Desconto: " + valorDesconto);
        this.preco -= valorDesconto;
    }
    public void exibirInformacoes(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Preço: " + this.preco);
        System.out.println("Quantidade em estoque: " + this.quantidadeEmEstoque);
    }

    public static void main(String[] args){
        try{
            ProdutoExtendido produto = new ProdutoExtendido("Pincel",10, 20 );
            produto.exibirInformacoes();
            produto.aplicarDesconto(25);
            System.out.println("Preço após desconto: " + produto.getPreco());
        }catch(DescontoInvalidoException ex) {
            ex.printStackTrace();
        }
    }

}

