public class Main {

    public static void main(String[] args) {
        int opcao;

        do {
            Telas.menuPrincipal();
            opcao = Telas.lerOpcao();

            switch (opcao) {
                case 1:
                    Controlador.criarConta();
                    break;
                case 2:
                    Controlador.acessarConta();
                    break;
                case 3:
                    Telas.mensagem("Encerrando. Até logo!", false);
                    break;
                case 4:
                 Controlador.menuConta();
                    break;
                
                default:
                    Telas.mensagem("Opção inválida. Tente novamente.", true);
            }

        } while (opcao != 3);
    }
}
