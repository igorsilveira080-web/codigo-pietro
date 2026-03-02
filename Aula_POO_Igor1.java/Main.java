public class Main {

    public static void main(String[] args) {
        double mediaAprovacao = 6.0;


        aluno aluno1 = new aluno("João Pedro", 1010, 7.5, 8.0);
        aluno aluno2 = new aluno("Polyana", 2020, 6.0, 5.5);
        aluno aluno3 = new aluno("Leonardo", 3030, 4.0, 3.5);


        aluno1.exibirResultado(mediaAprovacao);
        aluno2.exibirResultado(mediaAprovacao);
        aluno3.exibirResultado(mediaAprovacao);

    }
}