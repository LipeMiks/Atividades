public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        // Adicionando 10 livros à biblioteca
        biblioteca.adicionarLivro(new Livro("Dom Casmurro", "Machado de Assis", 1899, 29.90));
        biblioteca.adicionarLivro(new Livro("O Alienista", "Machado de Assis", 1882, 19.90));
        biblioteca.adicionarLivro(new Livro("Memórias Póstumas de Brás Cubas", "Machado de Assis", 1881, 34.90));
        biblioteca.adicionarLivro(new Livro("Grande Sertão: Veredas", "João Guimarães Rosa", 1956, 49.90));
        biblioteca.adicionarLivro(new Livro("A Hora da Estrela", "Clarice Lispector", 1977, 22.50));
        biblioteca.adicionarLivro(new Livro("Capitães da Areia", "Jorge Amado", 1937, 27.30));
        biblioteca.adicionarLivro(new Livro("O Cortiço", "Aluísio Azevedo", 1890, 24.00));
        biblioteca.adicionarLivro(new Livro("Vidas Secas", "Graciliano Ramos", 1938, 26.70));
        biblioteca.adicionarLivro(new Livro("Iracema", "José de Alencar", 1865, 20.00));
        biblioteca.adicionarLivro(new Livro("Senhora", "José de Alencar", 1875, 23.00));

        // Buscar um livro pelo título
        String tituloBusca = "Vidas Secas";
        Livro livroEncontrado = biblioteca.buscarLivroPorTitulo(tituloBusca);
        if (livroEncontrado != null) {
            System.out.println("\nLivro encontrado: " + livroEncontrado.getTitulo() + " por " + livroEncontrado.getAutor());
        } else {
            System.out.println("\nLivro '" + tituloBusca + "' não encontrado.");
        }

        // Listar livros disponíveis
        System.out.println();
        biblioteca.listarLivrosDisponiveis();

        // Calcular e mostrar o valor total dos livros
        double valorTotal = biblioteca.calcularValorTotal();
        System.out.printf("\nValor total dos livros na biblioteca: R$ %.2f\n", valorTotal);
    }
}
