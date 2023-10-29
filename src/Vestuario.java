public class Vestuario extends Produto {
    private int quantEstoque;

    public Vestuario(String nome, String descricao, double preco){
        super(nome, descricao, preco);
    }

    public int getQuantEstoque() {
        return quantEstoque;
    }
    public void setQuantEstoque(int quantEstoque) {
        this.quantEstoque = quantEstoque;
    }

    @Override
    public String toString() {
        return super.toString()+"\nQuantidade em Estoque: "+quantEstoque;
    }
}
