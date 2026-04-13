
import java.util.List;


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
            Telas.limparTela();
            System.out.println("Verificando credenciais...");
            Cliente cliente = new Cliente();
            String status = central.login(numeroConta, senha, cliente);

            switch (status) {
                case "OK":
                    menuConta(cliente);
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

    public static void menuConta(Cliente cliente) {
        int opcao;
        do { 

            Telas.menuConta(cliente.getNome(), cliente.getSaldo());
            opcao = Telas.lerOpcao();
            central.atualizarSaldo(cliente);

            switch (opcao) {
                case 1:
                    depositar(cliente);
                    break;

                case 2:
                    sacar(cliente);
                    break;

                case 3:
                    transferir(cliente);
                    break;

                case 4:
                    verExtrato (cliente);
                    break;

                case 5:
                    Telas.mensagem("Até logo, " + cliente.getNome() + "!", false);
                    break;

                default:
                    Telas.mensagem("Opção inválida. Tente novamente.", true);
            }
        } while (opcao != 5);
    }

    // Operações de conta

    private static void depositar(Cliente cliente) {
        Telas.limparTela();
        double valor = Telas.lerValor("Digite o valor a ser depositado: ");
        if (valor <= 0) {
            Telas.mensagem("Valor inválido. O depósito deve ser maior que zero.", true);
            return;
        }

        boolean ok = central.depositar(cliente, valor);
        if (ok) {
            Telas.mensagem(
                    String.format("Depósito de R$ %.2f realizado com sucesso!", valor), false);
        } else {
            Telas.mensagem("Erro ao processar o depósito. Tente novamente mais tarde.", true);
        }

    }

    private static void sacar(Cliente cliente) {
        Telas.limparTela();
        double valor = Telas.lerValor("Digite o valor a ser sacado: ");
        if (valor <= 0) {
            Telas.mensagem("Valor inválido. Tem que ser maior q isso pobre.", true);
            return;

        }
        if (valor > cliente.getSaldo()) {
            Telas.mensagem("Saldo insuficiente para realizar o saque.", true);
            return;
        }

        boolean ok = central.sacar(cliente, valor);
        if (ok) {
            Telas.mensagem(
                    String.format("Saque de R$ %.2f realizado com sucesso!\nSaldo atual: R$ %.2f",
                            valor, cliente.getSaldo()),
                    false);
        } else {
            Telas.mensagem("Erro ao processar o saque. Verifique seu saldo e tente novamente.", true);
        }

    }

    private static void transferir(Cliente cliente) {
        Telas.limparTela();
        String contaDestino = Telas.lerTexto("Digite o número da conta destino: ");
        double valor = Telas.lerValor("Digite o valor a ser transferido: ");
        if (valor <= 0) {
            Telas.mensagem("Valor inválido. Tem que ser maior q isso pobre.", true);
            return;
        }
        if (valor > cliente.getSaldo()) {
            Telas.mensagem("Saldo insuficiente para realizar a transferência.", true);
            return;
        }

        boolean ok = central.transferir(cliente, contaDestino, valor);
        if (ok) {
            Telas.mensagem(
                    String.format("Transferência de R$ %.2f realizada com sucesso, para a conta %s!\nSaldo atual: R$ %.2f",
                     valor, 
                     contaDestino,
                     cliente.getSaldo()),
                    false);
        } else {
            Telas.mensagem("Erro ao processar a transferência. Verifique o número da conta destino.", true);

        }
    }

      private static void verExtrato(Cliente cliente) {
        Telas.limparTela();
        List<String> linhas = central.getExtrato(cliente);
        StringBuilder extrato = new StringBuilder();
        extrato.append("=======EXTRATO DE MOVIMENTAÇÕES=======\n");

        for(String linha : linhas) {
            extrato.append(linha). append("\n");
        }

        extrato.append("===============================================");

        Telas.mensagem (
            extrato.toString(),
            false);
    } 

}