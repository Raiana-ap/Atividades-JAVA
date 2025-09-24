package exc7;
//Generics (Repositório Genérico em Memória)
//Defina Identificavel com getId(). Crie IRepository<T extends Identificavel, ID>
//com salvar, buscarPorId (retorna Optional<T>), listarTodos e remover.
//Implemente InMemoryRepository com Map<ID, T>, garanta que listarTodos
//devolva cópia imutável e lance EntidadeNaoEncontradaException ao remover ID
//inexistente. Use com entidades como Produto e Funcionario.
public class Principal {
    public static void main(String[] args) {
        IRepository<Produto, Integer> produtoRepositorio = new InMemoryRepository<>();
        IRepository<Funcionario, String> funcionarioRepositorio = new InMemoryRepository<>();

        Produto produto1 = new Produto(1, "Caneta", 1.99);
        Produto produto2 = new Produto(2, "Copo", 15.99);

        produtoRepositorio.salvar(produto1);
        produtoRepositorio.salvar(produto2);

        System.out.println("Produtos cadastrados:");
        for(Produto produto : produtoRepositorio.getAll()){
            System.out.println(produto.getNome());
        }

        produtoRepositorio.remove(1);
        for (Produto produto : produtoRepositorio.getAll()) {
            System.out.println(produto.getNome() + " removido.");
        }

        try {
            produtoRepositorio.remove(99);
        } catch (EntidadeNaoEncontradaException e) {
            System.out.println("\nErro: " + e.getMessage());
        }
    }
}
