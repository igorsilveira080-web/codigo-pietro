//Classe pai 

//passa a ser a classe base com saldo 
public class Conta {
  public String NumeroConta;
  public double saldo;

  public double getSaldo() {
    return this.saldo;
  }

  public String getNumeroConta() {
    return this.NumeroConta;
  }

  // Operaçoes
  public boolean depositar(double valor) {

    if (valor <= 0) {
      return false;

    }
    this.saldo += valor;
    return true;

  }

  public boolean sacar(double valor) {
    if (valor <= 0 || valor > this.saldo) {
      return false;
    }
    this.saldo -= valor;
    return true;
  }

  public String descricao() {
    return "Conta";
  }

}
