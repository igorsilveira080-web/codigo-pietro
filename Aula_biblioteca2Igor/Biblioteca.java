import java.util.ArrayList;

public class Biblioteca {

    ArrayList<Livro> acervo;

    Biblioteca() {
        this.acervo = new ArrayList<>();
    }

    // 1. Adicionar livro
    void adicionar(Livro livro) {
        acervo.add(livro);
    }

    // 2. Listar livros
    void listarLivros() {
        System.out.println("=== Acervo da Biblioteca ===");
        for (Livro livroPercorridoNesteInstante : acervo)
            livroPercorridoNesteInstante.exibirInfo();
        return;

    }

    // 3. Buscar livro pelo título
    void buscarLivro(String titulo) {
        System.out.println("n=== Busca ===");
        for (Livro livroPercorridoNesteInstante : acervo) {
            if (livroPercorridoNesteInstante.titulo().equalsIgnoreCase(titulo)) {
                livroPercorridoNesteInstante.exibirInfo();
            }
        }

    }
}
