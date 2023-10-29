import java.io.*;

public class Estoque {
    private Produto[] produto;
    private int quantAlimentos = 0;
    private int quantVestuarios = 0;
    private int quantEletrodomesticos = 0;

    public Produto[] getProduto() {
        return produto;
    }
    public void setProduto(Produto[] produto) {
        this.produto = produto;
    }

    public int getQuantAlimentos() {
        return quantAlimentos;
    }
     
    public int getQuantVestuarios() {
        return quantVestuarios;
    }

    public int getQuantEletrodomesticos() {
        return quantEletrodomesticos;
    }

    public void preencheEstoque(String filename){
        try{
            BufferedReader br = new BufferedReader(new FileReader(filename));
            br.readLine();//pula linha 1
            double numLinhas = br.lines().count();
            int quantLinhas = (int)numLinhas;
            System.out.println(quantLinhas);
            br.close();

            BufferedReader leitor = new BufferedReader(new FileReader(filename));
            leitor.readLine();
            String linha = leitor.readLine(); 
            produto = new Produto[quantLinhas];
            int cont = 0;

            while(linha != null){
                String[] celula = linha.split("\\s\\*\\s");

                if(linha.contains("Alimento")){
                    produto[cont] = new Alimento(celula[0], celula[1], Double.parseDouble(celula[2]));
                    quantAlimentos++;
                } else if(linha.contains("Eletrodomestico")){
                    produto[cont] = new Eletrodomestico(celula[0], celula[1], Double.parseDouble(celula[2]));
                    quantEletrodomesticos++;
                } else {
                    produto[cont] = new Vestuario(celula[0], celula[1], Double.parseDouble(celula[2]));
                    quantVestuarios++;
                }
                    
                linha = leitor.readLine();
                cont++;
            }

            leitor.close();
        } catch(FileNotFoundException e){
            System.out.println("Arquivo não encontrado.");
        } catch(IOException e){
            System.out.println("Erro na leitura do arquivo.");
        }
    }

}
