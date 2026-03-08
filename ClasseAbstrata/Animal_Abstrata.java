package ClasseAbstrata;

public abstract class Animal_Abstrata {
    String nome; 

    public Animal_Abstrata(String nome) {
        this.nome = nome; 
    }
    //metodo que pode variar
    public abstract void fazerSom(); 
    
    
    //Comportamento concreto!
    public void dormir(){
        System.out.println(nome + " está dormindo");

    }
    }

    //A Classe Abstrata ela e so um modelo que pode ser usada atravez da herança

