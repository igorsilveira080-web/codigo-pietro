


public class ContaCorrente extends Conta {

    // O construtor continua sendo obrigatório para repassar os dados para a mãe
    public ContaCorrente(String titular, double saldoInicial) {
        super(titular, saldoInicial);
    }

  
    @Override
    public void exibirSaldo() {
        System.out.print("[CONTA CORRENTE] ");
        super.exibirSaldo();
   
    
   
   
}
}
    

    

