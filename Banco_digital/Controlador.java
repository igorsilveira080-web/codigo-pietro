import java.time.LocalDate;

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

        // Enviar a CentralBancaria
        Telas.mensagem("Enviando dados para a CentralBancaria...", false);
        String resultado = central.cadastrar(
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getDataNascimento());
        if (resultado.startsWith("ERRO"));
        {
            Telas.mensagem(resultado, true);
            return;
         

        }  
           String numeroConta = resultado;
      
        // Senha
        Telas.limparTela();
        System.out.println("Conta criada com sucesso! Número da conta: " );
        System.out.println("Numero da conta:" + numeroConta);
        Telas.separador();

        String senha; String confirma;

        do {senha = Telas.lerTexto("Crie sua senha (4 dígitos)");
            confirma = Telas.lerTexto("Confirme sua senha");
            if (!senha.equals(confirma)) {
                Telas.mensagem("As senhas não conferem. Tente novamente.", true);
            } else if (!senha.matches("\\d{4}")) {
                Telas.mensagem("Senha inválida. Use exatamente 4 dígitos numéricos.", true);
            }


        } while (!senha.equals(confirma) || !senha.matches("\\d{4}"));

        central.cadastrarSenha(numeroConta, senha);
        Telas.mensagem("Cadastro completo! Numero da conta: " + numeroConta, false);
    }

    public static void acessarConta() {
        // Login completo será implementado na Aula 06, com a CentralBancaria.
        Telas.cabecalhoLogin();
        Telas.mensagem("Login via CentralBancaria será implementado na Aula 06.", false);
    }

    // =========================================================
    // MENU LOCAL (demonstração de composição)
    // As operações usam conta.depositar/sacar diretamente e
    // registram cada movimentação no historico — isso é composição.
    // Na Aula 06 essas chamadas serão substituídas pela CentralBancaria.
    // =========================================================

    private static void menuConta(Cliente cliente) {
        int opcao;
        do {
            Telas.menuConta(cliente.getNome(), cliente.getSaldo());
            opcao = Telas.lerOpcao();
            switch (opcao) {
                case 1:
                    depositar(cliente);
                    break;
                case 2:
                    sacar(cliente);
                    break;
                case 3:
                    Telas.mensagem("Transferência disponível na Aula 06 (CentralBancaria).", false);
                    break;
                case 4:
                    verExtrato(cliente);
                    break;
                case 5:
                    /* sair */ break;
                default:
                    Telas.mensagem("Opção inválida. Tente novamente.", true);
            }
        } while (opcao != 5);
    }

    private static void depositar(Cliente cliente) {
        Telas.limparTela();
        double valor = Telas.lerValor("Valor para depósito");
        if (valor <= 0) {
            Telas.mensagem("Valor inválido para depósito.", true);
            return;
        }

        /*
         * A operação é feita na Conta (via composição cliente → conta).
         * Em seguida, registramos uma Transacao no Historico.
         * São dois objetos independentes colaborando — isso é composição.
         */
        cliente.getConta().depositar(valor);
        cliente.getHistorico().adicionar(
                new Transacao("DEPOSITO", valor, LocalDate.now()));

        Telas.mensagem(
                "Depósito realizado com sucesso!\n" +
                        "Novo saldo: R$ " + String.format("%.2f", cliente.getSaldo()),
                false);
    }

    private static void sacar(Cliente cliente) {
        Telas.limparTela();
        double valor = Telas.lerValor("Valor para saque");
        if (valor <= 0) {
            Telas.mensagem("Valor inválido para saque.", true);
            return;
        }
        if (valor > cliente.getSaldo()) {
            Telas.mensagem("Saldo insuficiente. Saldo atual: R$ " +
                    String.format("%.2f", cliente.getSaldo()), true);
            return;
        }

        cliente.getConta().sacar(valor);
        cliente.getHistorico().adicionar(
                new Transacao("SAQUE", valor, LocalDate.now()));

        Telas.mensagem(
                "Saque realizado com sucesso!\n" +
                        "Novo saldo: R$ " + String.format("%.2f", cliente.getSaldo()),
                false);
    }

    private static void verExtrato(Cliente cliente) {
        Telas.limparTela();
        System.out.println("\n======== Extrato ========");
        System.out.println("Conta: " + cliente.getNome());
        System.out.println("Tipo : " + cliente.getConta().descricao());
        Telas.separador();
        for (String linha : cliente.getHistorico().listar()) {
            System.out.println(linha);
        }
        Telas.separador();
        System.out.printf("Saldo atual: R$ %.2f%n", cliente.getSaldo());
        System.out.println("\nPressione qualquer tecla para continuar...");
        // Aguarda Enter (o Scanner está em Telas, aqui usamos lerTexto com label vazio)
        Telas.lerTexto("");
    }
}
