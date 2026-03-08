package ClasseAbstrata;

public class Main { 
    public static void main(String[] args) {
        //Objeto cachorro
        Cachorro c = new Cachorro("Ronaldo");
        Gato g = new Gato("Robson");
       
        //Vai dar Erro se:

        //Motivo do erro: A classe dele e Abstrata é nao pode ser Instanciada

        c.dormir();
        c.fazerSom();


        //Objeto gato
        
        g.dormir();
        g.fazerSom();

    }
    
}
