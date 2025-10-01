public class Principal {
    public static void main(String[] args){

        FuncionarioMensalista f1 = new FuncionarioMensalista("João", "20221234", 10000.0, 20);
        FuncionarioHorista f2 = new FuncionarioHorista("Pedro", "20204321", 32.5,  160);

        f1.imprimirDados();
        System.out.println();
        f2.imprimirDados();
    }
}