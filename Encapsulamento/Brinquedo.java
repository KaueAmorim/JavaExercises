public class Brinquedo {

    private String nome;
    private int alturaMinima;
    private float precoIngresso;

    public Brinquedo(String nome, int alturaMinima, float precoIngresso) {
        this.setNome(nome);
        this.setAlturaMinima(alturaMinima);
        this.setPrecoIngresso(precoIngresso);
    }

    public String getNome() {
        return this.nome;
    }

    public int getAlturaMinima() {
        return this.alturaMinima;
    }

    public float getPrecoIngresso() {
        return this.precoIngresso;
    }

    public void setNome(String nome) {
        if(!nome.isEmpty()) {
            this.nome = nome;
        }
    }

    public void setAlturaMinima(int alturaMinima) {
        if(alturaMinima > 0) {
            this.alturaMinima = alturaMinima;
        }
    }

    public void setPrecoIngresso(float precoIngresso) {
        if(precoIngresso > 0) {
            this.precoIngresso = precoIngresso;
        }
    }

    public boolean isPermitido(Visitante p){
        return p.getAltura() >= this.alturaMinima;
    }
}