import  java.util.Scanner;

public class Principal {
    public static void main(String[] args){

        Imovel[] imoveis = new Imovel[200];

        Scanner scanner = new Scanner(System.in);
        String rua = scanner.nextLine();
        int numero = scanner.nextInt();
        scanner.nextLine(); // Consome a quebra de linha deixada pelo nextInt()
        String bairro = scanner.nextLine();
        String cidade = scanner.nextLine();
        String estado = scanner.nextLine();

        Endereco end = new Endereco(rua, numero, bairro, cidade, estado);

        for(int i = 0; i < 200; i++){
            if(i % 2 == 0){
                imoveis[i] = new ImovelNovo(end, (float) i);    
            }
            else{
                imoveis[i] = new ImovelVelho(end, (float) i);
            }
        }

        for(int i = 0; i < 200; i++){
            System.out.println("Imovel " + (i+1) + ": " + imoveis[i].calcularValorImovel());
        }
    }
}