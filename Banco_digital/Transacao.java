import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

public class Transacao {
  public String tipo;
  public double valor;
  public LocalDate data;
  private static final DateTimeFormatter Formatador = DateTimeFormatter
      .ofPattern("dd/MM/uuuu")
      .withResolverStyle(ResolverStyle.STRICT);;

  public Transacao(String tipo, double valor, String data) {
    this.tipo = tipo;
    this.valor = valor;
    this.data = LocalDate.parse(data, Formatador);

  }

  // Getters
  public String getTipo() {
    return tipo;
  }

  public double getValor() {
    return valor;
  }

  public String getData() {
    return data.format(Formatador);
  }

  //representaçao formatada da transação
  @Override
  public String toString() {
    return String.format("%s: R$%.2f em %s",
        tipo, valor, data.format(Formatador));
  }
}
