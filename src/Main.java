import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ConsultaCep consultaCep = new ConsultaCep();
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite um CEP para busca: ");
        var buscaCEP = leitura.nextLine();

        try{
            Endereco novoEndereco = consultaCep.buscaEndereco(buscaCEP);
            System.out.println(novoEndereco);
            GeradorDeArquivo geradorDeArquivo = new GeradorDeArquivo();
            geradorDeArquivo.geraJson(novoEndereco);
        } catch (RuntimeException | IOException e) {
            throw new RuntimeException(e.getMessage());

        }
    }
}