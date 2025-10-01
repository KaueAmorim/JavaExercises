public class Quadrado implements FiguraGeometrica {

    private double lado;

    public Quadrado(double lado) {
        this.setLado(lado);
    }

    public double getLado() {
        return this.lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    public double calcularArea() {
        return lado * lado;
    }

    public void desenhar(){ 
        int tamanho = (int) Math.round(lado);
        
        // Desenha o quadrado com asteriscos
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }
}