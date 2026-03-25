
import java.util.Scanner;

public class Telas {

    // Menu
    private static final Scanner scanner = new Scanner(System.in);

    private static void limparTela() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }

    }
    public static void opcao(String texto) {
        limparTela();
        System.out.println("===================");
        System.out.println(texto);
        System.out.println("===================");
        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine();
    }

    public static void menuPrincipal() {
        limparTela();

        System.out.println("===================");
        System.out.println(" ONE PIERCE BANK");
        System.out.println("===================");
        System.out.println("Bem-vindo ao One Pierce Bank!");
        System.out.println("1. Criar conta;");
        System.out.println("2. Acessar conta:");
        System.out.println("3. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private void mensagem(String nomeCliente, double saldo) {
        limparTela();
        System.out.println("===================");
        System.out.println("Olá, " + nomeCliente + ("! Bem-vindo ao One Pierce Bank."));
        System.out.printf("Saldo: R$ %.2f%n", saldo);
        System.out.println("===================");
        System.out.println("1. Depositar: ");
        System.out.println("2. Sacar: ");
        System.out.println("3. Transferir: ");
        System.out.println("4. Ver extrato: ");
        System.out.println("5. Sair da conta😒 ");
        System.out.print("Escolha uma opção: ");
    }
    

    static void cabecalhoLogin() {
        limparTela();
        System.out.println("===================");
        System.out.println("Login");
        System.out.println("===================");
    }

    public static void cabecalhoCadastro() {
        limparTela();
        System.out.println("===================");
        System.out.println("Login/Cadastro");
        System.out.println("===================");
    }

    public static String lerTexto(String label) {
        System.out.print(label + ": ");
        return scanner.nextLine().trim();
    }

    public static int lerOpcao() {
        try {
            int opcao = Integer.parseInt(scanner.nextLine().trim());
            return opcao;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static double lerValor(String label) {
        System.out.print(label + ": R$ ");
        try {
            return Double.parseDouble(scanner.nextLine().trim().replace(",", "."));
        } catch (NumberFormatException e) {
            return -1;
        }

    }

    public static void mensagem(String texto, boolean eErro) {

        limparTela();
        if (eErro) {
            System.out.println("===================");
            System.out.println("\n" + texto);
            System.out.println("===================");
            System.out.println("Pressione Enter para continuar...");
            scanner.nextLine();

        } else {
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println("Erro: " + texto);
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println("Pressione Enter para continuar...");
            scanner.nextLine();
        }
    }
    // public static void erro(String texto) {
    // limparTela();
    // System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    // System.out.println("Erro: " + texto);
    // System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    // System.out.println("Pressione Enter para continuar...");
    // scanner.nextLine();

}
