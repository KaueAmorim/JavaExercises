public class Visitante {
    
    private String nome;
    private int altura;
    private float saldo;

    public Visitante(String nome, int altura, float saldo) {
        this.setNome(nome);
        this.setAltura(altura);
        this.setSaldo(saldo);
    }

    public String getNome() {
        return this.nome;
    }

    public int getAltura() {
        return this.altura;
    }

    public float getSaldo() {
        return this.saldo;
    }

    public void setNome(String nome) {
        if(!nome.isEmpty()) {
            this.nome = nome;
        }
    }

    public void setAltura(int altura) {
        if(altura > 0) {
            this.altura = altura;
        }
    }

    public void setSaldo(float saldo) {
        if(saldo >= 0) {
            this.saldo = saldo;
        }
    }

    public void compraIngresso(Brinquedo b) {
        this.saldo -= b.getPrecoIngresso();
    }
}