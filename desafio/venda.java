public class venda {


    Cliente cliente;
    Product[] produtos = new produto[10];
    int[] quantidades = new int[10];
    int totalItens = 0;

    public venda(Cliente cliente) {
        this.cliente = cliente;
    
}
 public void addProduto(Produto produto, int quantidade) {

        if (produto.estoque < quantidade) {
            System.out.println("Estoque insuficiente para: " + produto.nome);
            return;
        }






}