public class Controlador {
    private static final CentralBancaria central = new CentralBancaria();

    public static void criarConta() {
        Telas.cabecalhoCadastro();
        Cliente cliente = new Cliente();

        // Nome
        String nomeInformado;
        do {
            Telas.limparTela();
            nomeInformado = Telas.lerTexto("Digite o nome completo: ");
            if (!cliente.setNome(nomeInformado)) {
                Telas.mensagem("Nome inválido!", true);
            }
        } while (!cliente.setNome(nomeInformado));

        // CPF
        String cpfInformado;
        do {
            Telas.limparTela();
            cpfInformado = Telas.lerTexto("Digite o CPF: ");
            if (!cliente.setCpf(cpfInformado)) {
                Telas.mensagem("CPF inválido.", true);
            }
        } while (!cliente.setCpf(cpfInformado));

        // Data de Nascimento
        String data;
        do {
            Telas.limparTela();
            data = Telas.lerTexto("Data de nascimento (dd/mm/aaaa)");
            if (!cliente.setDataNascimento(data)) {
                Telas.mensagem("Data de nascimento inválida.", true);
            }
        } while (!cliente.setDataNascimento(data));

        // Envia à CentralBancaria
        System.out.println("Enviando dados para a central...");
        String resultado = central.cadastrar(
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getDataNascimento());

        if (resultado.startsWith("ERRO")) {
            Telas.mensagem(resultado, true);
            return;
        }

        String numeroConta = resultado;

        // Solicitar Senha
        Telas.limparTela();
        System.out.println("Conta criada com sucesso!");
        System.out.println("Número da conta: " + numeroConta);
        Telas.separador();

        String senha, confirma;
        do {
            senha = Telas.lerTexto("Crie sua senha (4 dígitos numéricos)");
            confirma = Telas.lerTexto("Confirme sua senha");
            if (!senha.equals(confirma)) {
                Telas.mensagem("Senhas não conferem. Tente novamente.", true);
            } else if (!senha.matches("\\d{4}")) {
                Telas.mensagem("Senha inválida. Use exatamente 4 dígitos numéricos.", true);
            }
        } while (!senha.equals(confirma) || !senha.matches("\\d{4}"));

        central.cadastrarSenha(numeroConta, senha);
        Telas.mensagem("Cadastro concluído! Número da conta: " + numeroConta, false);
    }

    public static void acessarConta() {
        Telas.cabecalhoLogin();

        String numeroConta = Telas.lerTexto("Número da conta");
        int tentativas = 0;
        while (tentativas < 3) {
            String senha = Telas.lerTexto("Senha");
            Cliente cliente = new Cliente();
            String status = central.login(numeroConta, senha, cliente);

            switch (status) {
                case "OK":
                    Telas.mensagem("Login bem-sucedido! Bem-vindo, " + cliente.getNome() + "!", false);
                    return;

                case "Conta INEXISTENTE":
                    Telas.mensagem("Número de conta não encontrado. Tente novamente.", true);
                    return;

                case "BLOQUEADA":
                    Telas.mensagem("Conta bloqueada devido a múltiplas tentativas de login falhadas.", true);
                    return;

                case "SENHA INCORRETA":
                    tentativas++;
                    if (tentativas < 3) {
                        Telas.mensagem("Senha incorreta. Tente novamente." + tentativas + "/3", false);
                    }
                    break;
                default:
                    Telas.mensagem("Erro de comunicação. Tente novamente mais tarde.", true);
                    return;

            }
        }
    }

    public static void menuConta() {
        String opcao = Telas.lerTexto("Menu da Conta:");
        switch (opcao) {
            case "1" -> Telas.mensagem("Saque da conta em breve", false);

            case "2" -> Telas.mensagem("Deposito da conta em breve", false);
            case "3" -> Telas.mensagem("Saindo...", false);
            default -> Telas.mensagem("Opção inválida.", true);
        }
    }

}
