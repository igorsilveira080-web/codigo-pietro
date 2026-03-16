// Classe Abstrata: Define o modelo geral (O QUE um veículo faz)
abstract class Veiculo {
    String modelo;

    // Método abstrato: Não tem corpo {}. 
    // Obriga as classes filhas a explicarem COMO se movem.
    abstract void mover();

    // Método comum: Funcionalidade que todos os veículos compartilham
    void mostrarDetalhes() {
        System.out.println("Modelo: " + modelo);
    }
}

// Classe Carro: Especialização do Veículo
class Carro extends Veiculo {
    Carro(String m) { 
        this.modelo = m; 
    }

    // Implementação real do movimento do carro
    void mover() {
        System.out.println("O carro esta andando pelas ruas.");
    }
}

// Classe Aviao: Outra especialização do Veículo
class Aviao extends Veiculo {
    Aviao(String m) { 
        this.modelo = m; 
    }

    // Implementação real do movimento do avião
    void mover() {
        System.out.println("O aviao esta voando pelo ceu.");
    }
}

public class Main {
    public static void main(String[] args) {
        // Criando objetos das classes que funcionam
        Carro meuCarro = new Carro("Fusca");
        meuCarro.mostrarDetalhes();
        meuCarro.mover();

        System.out.println("-----------------------------");

        Aviao meuAviao = new Aviao("Boeing 747");
        meuAviao.mostrarDetalhes();
        meuAviao.mover();

        // ERRO PROPOSITAL PARA A APRESENTAÇÃO:
        // Veiculo v = new Veiculo(); 
        // Se descomentar a linha acima, o código não compila.
        // Erro: "Veiculo is abstract; cannot be instantiated"
    }
}
