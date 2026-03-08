public class Livro{
    String titulo;
    String autor;
    int ano;

    Livro(
      String titulo, 
      String autor,
      int ano) {
      this.titulo = titulo;
      this.autor = autor;
      this.ano = ano;

}     String titulo() {
        return titulo;
    
      }

      public void exibirInfo () {
         System.out.println(
         "Título: " + titulo +
         "| Autor: " + autor +
        "| Ano: " + ano);
    }
      }




    

