public class Triangulo implements FiguraGeometrica {

    private double base;
    private double altura;

    public Triangulo(double base, double altura) {
        this.setBase(base);
        this.setAltura(altura);
    }

    public double getBase() {
        return this.base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return this.altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double calcularArea() {
        return base * altura;
    }

    public void desenhar(){ 
        int alturaInt = (int) Math.round(altura);
        
        // Desenha o triângulo
        for (int i = 1; i <= alturaInt; i++) {
            // Adiciona espaços para centralizar
            for (int j = 0; j < alturaInt - i; j++) {
                System.out.print(" ");
            }
            // Desenha os asteriscos
            for (int k = 0; k < (2 * i - 1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }
}