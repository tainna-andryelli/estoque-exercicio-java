import java.io.*;

public class Principal {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();
        estoque.preencheEstoque("arquivoProdutos.txt");
        //criando novo arquivo
        String nomeArquivo = "info.txt";
        Alimento[] alimento = new Alimento[estoque.getQuantAlimentos()];
        Eletrodomestico[] eletro = new Eletrodomestico[estoque.getQuantEletrodomesticos()];
        Vestuario[] vestuario = new Vestuario[estoque.getQuantVestuarios()];
        String[] nomeVestuario = new String[estoque.getQuantVestuarios()];
        int contAlimento = 0;
        int contEletro = 0;
        int contVestuario = 0;
        
        try{
            FileWriter fw = new FileWriter(nomeArquivo); 
            BufferedWriter escritor = new BufferedWriter(fw);
            String alimentoCaro = null;
            String eletroBarato = null;
            escritor.write("Produtos de Vestuario: ");

            for(int i=0; i<estoque.getProduto().length; i++){

                if(estoque.getProduto()[i] instanceof Alimento){
                    alimento[contAlimento] = (Alimento) estoque.getProduto()[i];
                    if(alimentoCaro == null || alimento[contAlimento].getPreco() > alimento[contAlimento-1].getPreco())
                        alimentoCaro = alimento[contAlimento].getNome();
                    contAlimento++;
                } else if(estoque.getProduto()[i] instanceof Eletrodomestico){
                    eletro[contEletro] = (Eletrodomestico) estoque.getProduto()[i];
                    if(eletroBarato == null || eletro[contEletro].getPreco() < eletro[contEletro-1].getPreco())
                        eletroBarato = eletro[contEletro].getNome();
                    contEletro++;
                } else {
                    vestuario[contVestuario] = (Vestuario) estoque.getProduto()[i];
                    nomeVestuario[contVestuario] = vestuario[contVestuario].getNome();
                    escritor.write(nomeVestuario[contVestuario]);
                    if(contVestuario < estoque.getQuantVestuarios()-1)
                        escritor.write(", ");
                    contVestuario++;
                }
                
            }
            escritor.write("\nQuantidade em estoque de vestuarios: "+estoque.getQuantVestuarios());
            escritor.write("\nAlimento mais caro: "+alimentoCaro);
            escritor.write("\nEletrodomestico mais barato: "+eletroBarato);
            escritor.close();

        } catch(IOException e){
            System.out.println("Erro ao escrever no arquivo.");
        }
    }
}
