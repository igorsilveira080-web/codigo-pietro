import java.util.Scanner;
public class main {
        public static void main(String[] args) {
                
        
        Scanner sc = new Scanner(System.in);
         Biblioteca biblioteca = new Biblioteca();

        // Adicionando livros
        Livro livro1 = new Livro("Dom Casmurro", "Machado de Assis", 1899);
        Livro livro2 = new Livro("O Hobbit", "J.R.R. Tolkien", 1937);
        Livro livro3 = new Livro("1984", "George Orwell", 1949);
        Livro livro4 = new Livro("A Revolução dos Bichos", "George Orwell", 1945);

        biblioteca.adicionar(livro1);
        biblioteca.adicionar(livro2);
        biblioteca.adicionar(livro3);
        biblioteca.adicionar(livro4);
        int opcao;
        do {
                System.out.println("\n===MENU===");
                System.out.println("1. Listar livros da biblioteca");
                System.out.println("2. Adicionar Livro");
                System.out.println("3. Buscar por título");
                System.out.println("4. Sair");
                opcao = lerIntEntre(sc, "Escolha uma opção:" 1, 4);

                switch (opcao) {
                        case 1:
                                biblioteca.listar();
                                break;
                        case 2: 
                        System.out.println("Titulo");
                        String titulo = sc.nextLine();
                        System.out.println("Autor:");
                        String autor = sc.nextLine();

                int ano = lerAnoComPadraoPadrao(sc, "Ano (ou ENTER para 0):", 0);

                biblioteca.adicionar(new Livro(titulo, autor, ano));
                System.out.println("Livro adicionar com sucesso.");
                break;

        }
}
}
        static int lerIntEntre(Scanner sc, String prompt, int min, int max){
                while (true){
                        System.out.print(prompt);
                        
                }
        }