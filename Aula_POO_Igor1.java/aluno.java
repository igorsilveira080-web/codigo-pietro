public class aluno {
    String nome;
    int matricula;
    double nota1;
    double nota2;

    aluno(
            String nome,
            int matricula,
            double nota1,
            double nota2) {
        this.nome = nome;
        this.matricula = matricula;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    double calcularMedia() {
        double mediaAluno = (nota1 + nota2) / 2;
        return mediaAluno;
    }

    String verificarSituacao(double mediaAprovacao) {
        double mediaAluno = calcularMedia();
        String resultado = mediaAluno >= mediaAprovacao ? "Aprovado" : "Reprovado";

        return resultado;
    }

    void exibirResultado(double mediaAprovacao) {
        double mediaAluno = calcularMedia();
        String situacao = verificarSituacao(mediaAprovacao);
        System.out.println("---------Resultado do Aluno--------------------");
        System.out.println("Aluno: " + nome);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Nota 1: " + nota1);
        System.out.println("Nota 2: " + nota2);
        System.out.println("Média: " + mediaAluno);
        System.out.println("Situação: " + situacao);
        System.out.println("------------------------------------------------");
    }
}