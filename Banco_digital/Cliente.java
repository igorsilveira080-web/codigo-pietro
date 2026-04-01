
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class Cliente {
    private static final int IDADE_MINIMA = 16;
    private static final int ANO_MINIMO = 1900;
    public String Nome;
    private String Senha;
    private double saldo;
    private String Cpf;
    private boolean bloqueada;
    private int tentativasFalhas;
    private String numConta;
    private  LocalDate dataNascimento;
    private static final DateTimeFormatter formatador = DateTimeFormatter
    .ofPattern("dd/MM/uuuu")
    .withResolverStyle(ResolverStyle.STRICT);

    // Getters

    public String getNome() {
        return Nome;
    }

    public String getSenha() {
        return Senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getCpf() {
        return Cpf;
    }

    public boolean isBloqueada() {
        return bloqueada;
    }

    public int getTentativasFalhas() {
        return tentativasFalhas;
    }

    public String getDataNascimento() {
        return dataNascimento.format(formatador);
    }

    public String getNumConta() {
        return numConta;
    }

    // Setters
    // Validar Tudo aqui!!
    public boolean setNome(String nome) {
        if (nome == null || nome.trim().split("\\s+").length < 2) {
            return false;

        }
        this.Nome = nome.trim();
        return true;
    }

    public boolean setSenha(String senha) {
        if (senha == null || senha.trim().length() < 6) {
            return false;
        }
        this.Senha = senha.trim();
        return true;
    }

    public boolean setSaldo(double saldo) {
        
        if (saldo < 0) {
            return false;
        }
        this.saldo = saldo;
        return true;
    }

    public boolean  setCpf(String cpf) {
        String cpfLimpo;
        if (cpf == null) 
            return false;
        //Verifica se digitou 11 digitos 
        if (cpf.length() != 11 && cpf.length() != 14) 
            return false;
        
         cpfLimpo = cpf.replaceAll("[^0-9]", "");
         
        if (cpfLimpo.length() != 11) 
            return false;

        if (cpf.length() == 14) 
            return true;
        
       
        if (!ValidaCPF.isCPF(cpfLimpo)) 
            return false;
            
        
        this.Cpf = cpfLimpo;
        return true;
    }
    


    public boolean isBloqueada(boolean bloqueada) {
        this.bloqueada = bloqueada;
        return true;
    }

    public void setTentativasFalhas(int tentativasFalhas) {
        this.tentativasFalhas = tentativasFalhas;
    }

    public void setNumConta(String numConta) {
        this.numConta = numConta;
    }

    public boolean setDataNascimento(String data) {
        if (data == null)
            return false;

        try {
            LocalDate dataNascimento = LocalDate.parse(data, formatador);
            LocalDate hoje = LocalDate.now();

            if (dataNascimento.getYear() < ANO_MINIMO) {
                return false;
            }
            LocalDate datanascimento = hoje.minusYears(IDADE_MINIMA);
            if (dataNascimento.isAfter(datanascimento)) {
                return false;
            }

            this.dataNascimento = dataNascimento;
            return true;

        } catch (DateTimeParseException e) {
            return false;
        }

    }
}
