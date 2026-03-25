import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            Telas.menuPrincipal();
            opcao = Integer.parseInt(scanner.nextLine().trim());
            
            switch (opcao) {
                case 1:
                    Telas.opcao("Opção 1 selecionada: Criar conta");
                    break;
                case 2:
                    Telas.opcao("Opção 2 selecionada: Acessar conta ");
                    break;
                case 3:
                    System.out.println("Encerrando...Falo amigão!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");

            }

        } while (opcao != 3);
    }
}
