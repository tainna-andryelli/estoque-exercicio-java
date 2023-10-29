public class Eletrodomestico extends Produto {
    private double valorAdicionalIPI;

    public Eletrodomestico(String nome, String descricao, double preco){
        super(nome, descricao, preco);
    }

    public double getValorAdicionalIPI() {
        return valorAdicionalIPI;
    }
    public void setValorAdicionalIPI(double valorAdicionalIPI) {
        this.valorAdicionalIPI = valorAdicionalIPI;
    }

    @Override
    public String toString() {
        return super.toString()+"\nValor adicional IPI: "+valorAdicionalIPI;
    }
}
