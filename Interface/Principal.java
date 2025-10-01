public class Principal {
    public static void main(String[] args) {
        
        Quadrado obj1 = new Quadrado(5);
        Triangulo obj2 = new Triangulo(12, 13);

        System.out.println("A área do quadrado é: " + obj1.calcularArea());

        System.out.println();
        obj1.desenhar();

        System.out.println("A área do triângulo é: " + obj2.calcularArea());

        System.out.println();
        obj2.desenhar();
    }
}