import java.util.Scanner;


public class Telas {
    // Menu

    public static void menuPrincipal() {   
        Scanner scanner = new Scanner(System.in);
       
       
            System.out.println("===================");
            System.out.println(" ONE PIERCE BANK");
            System.out.println("===================");
            System.out.println("Bem-vindo ao One Pierce Bank!");
            System.out.println("1. Criar conta;");
            System.out.println("2. Acessar conta:");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
        }

    

    private void Mensagem(String nomeCliente) {
                System.out.println("===================");
                System.out.println("Olá, " + nomeCliente + ("! Bem-vindo ao One Pierce Bank."));
                System.out.printf("Saldo: R$ %.2f%n", saldo);
                System.out.println("===================");
                System.out.println("1. Depositar: ");
                System.out.println("2. Sacar: ");
                System.out.println("3. Transferir: ");
                System.out.println("4. Sair da conta😒 ");
                System.out.print("Escolha uma opção: ");
            }

    public static void opcao(String string) {
      
    }
}
