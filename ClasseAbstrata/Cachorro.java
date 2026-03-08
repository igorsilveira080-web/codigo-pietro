package ClasseAbstrata;

public class Cachorro  extends Animal_Abstrata{
    // Construtor 
    public Cachorro(String nome) {
        super(nome);
       //Super é usado para usar o Construtor da Classe Herdada
    }

    public void fazerSom(){
        System.out.println("Au, Au");
    }

  
    
}