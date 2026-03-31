//Classe pai 

    //passa a ser a classe base com saldo 
public class Conta {
   public String donoConta;
    public double saldo;
    

    public Conta(String donoConta, double saldoInicial) {
        this.donoConta = donoConta;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        this.saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado.");
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            this.saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado.");
        } else {
            System.out.println("Saldo insuficiente!");
        }

   }
 
}
