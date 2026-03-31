public class Controlador {

    public static void criarConta() {
        Telas.cabecalhoCadastro();
        Cliente cliente = new Cliente();

        // Nome
        String nomeInformado;
        do {
            nomeInformado = Telas.lerTexto("Digite o nome completo: ");
            if (!cliente.setNome(nomeInformado)) {
                Telas.mensagem("Nome inválido!", true);
            }
        } while (!cliente.getNome().equals(nomeInformado.trim()));

        // CPF
        String cpfInformado;
        do {
            Telas.limparTela();
            cpfInformado = Telas.lerTexto("Digite o CPF: ");
            if (!cliente.setCpf(cpfInformado)) {
                Telas.mensagem("CPF inválido!", true);
            }
        } while (!cliente.setCpf(cpfInformado));    

        // Data do elemento nascido
        String dataNascimento;
        do {
            Telas.limparTela();
            dataNascimento = Telas.lerTexto("Digite a data de nascimento (dd/mm/aaaa): ");
            if (!cliente.setDataNascimento(dataNascimento)) {
                Telas.mensagem("Data de nascimento inválida.", true);
            }
        } while (!cliente.setDataNascimento(dataNascimento));

        // Senha
        String senha = Telas.lerTexto("Crie sua senha (4 dígitos)");
        String confirma = Telas.lerTexto("Confirme sua senha");

        if (!senha.equals(confirma)) {
            Telas.mensagem("As senhas não conferem.", true);
            return;
        }

        if (!cliente.setSenha(senha)) {
            Telas.mensagem("Senha inválida. Use exatamente 4 dígitos numéricos.", true);
            return;
        }

        Telas.mensagem(
                "Dados validados com sucesso!\n" +
                        "Nome : " + cliente.getNome() + "\n" +
                        "CPF  : " + ValidaCPF.imprimeCPF(cliente.getCpf()) + "\n" +
                        "Nasc.: " + cliente.getDataNascimento() + "\n\n" +
                        "(Envio à CentralBancaria será implementado na Aula 06)",
                false);
    }

    public static void acessarConta() {
        Telas.cabecalhoLogin();

        String numeroConta = Telas.lerTexto("Número da conta");
        String senha = Telas.lerTexto("Senha");

        // Login completo será implementado na Aula 06, com a CentralBancaria.
        Telas.mensagem("Login recebido para a conta " + numeroConta + " (em breve).", false);
    }
}
