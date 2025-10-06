public class Main {
    public static void main(String[] args) {

        Brinquedo b1 = new Brinquedo("Montanha Russa", 130, 10.0f);
        Brinquedo b2 = new Brinquedo("Roda Gigante", 80, 8.0f);

        Visitante v1 = new Visitante("Alice", 120, 20.0f);
        Visitante v2 = new Visitante("Bob", 100, 15.0f);

        AtracaoEspecial a1 = new AtracaoEspecial("Show de Mágica", 100, 50);
        AtracaoEspecial a2 = new AtracaoEspecial("Montanha Russa", 200, 100);

        if(b1.isPermitido(v1)){
            System.out.printf("A visitante %s pode usar o brinquedo %s\n", v1.getNome(), b1.getNome());
        }
        else{
            System.out.printf("A visitante %s não pode usar o brinquedo %s\n", v1.getNome(), b1.getNome());
        }

        a1.setPresentes(150);
        if(a1.capacidadeValida()){
            System.out.printf("A atração %s tem capacidade válida\n", a1.getNome());
        }
        else{
            System.out.printf("A atração %s não tem capacidade válida\n", a1.getNome());
        }

        System.out.printf("Saldo do visitante %s: %.2f\n", v2.getNome(), v2.getSaldo());
        v2.compraIngresso(b2);
        System.out.printf("Saldo do visitante %s: %.2f\n", v2.getNome(), v2.getSaldo());
    }
}