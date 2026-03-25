public class Controlador {

    public static void criarConta() {
        Telas.cabecalhoCadastro();
        Cliente cliente = new Cliente();

        // Nome
        String nome = Telas.lerTexto("Nome completo");
        if (!cliente.setNome(nome)) {
            Telas.mensagem("Nome inválido. Informe nome e sobrenome.", true);
            return;
        }

        // CPF
        String cpf = Telas.lerTexto("CPF (somente números ou com pontuação)");
        if (!cliente.setCpf(cpf)) {
            Telas.mensagem("CPF inválido.", true);
            return;
        }

        // Data de Nascimento
        String data = Telas.lerTexto("Data de nascimento (dd/mm/aaaa)");
        if (!cliente.setDataNascimento(data)) {
            Telas.mensagem("Data de nascimento inválida. Use o formato dd/mm/aaaa.", true);
            return;
        }

        // Senha
        String senha    = Telas.lerTexto("Crie sua senha (4 dígitos)");
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
            "(Envio à CentralBancaria será implementado na Aula 06)"
        , false);
    }

    public static void acessarConta() {
        Telas.cabecalhoLogin();

        String numeroConta = Telas.lerTexto("Número da conta");
        String senha       = Telas.lerTexto("Senha");

        // Login completo será implementado na Aula 06, com a CentralBancaria.
        Telas.mensagem("Login recebido para a conta " + numeroConta + " (em breve).", false);
    }
}

   

    

