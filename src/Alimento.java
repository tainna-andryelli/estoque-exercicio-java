public class Alimento extends Produto {
    private int dia, mes, ano;

    public Alimento(String nome, String descricao, Double preco){
        super(nome, descricao, preco);
    }

    public int getDia() {
        return dia;
    }
    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }
    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }

    public String dataDeValidade(int dia, int mes, int ano){
        return "\nData de Validade: "+dia+"/"+mes+"/"+ano;
    }

    @Override
    public String toString() {
        return super.toString()+dataDeValidade(dia, mes, ano);
    }
}
