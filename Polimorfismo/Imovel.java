public abstract class Imovel {

    protected Endereco e;
    protected float preco;

    public Imovel(Endereco e, float preco){
        this.setEndereco(e);
        this.setPreco(preco);
    }

    public Endereco getEndereco() {
        return e;
    }

    public void setEndereco(Endereco e) {
        this.e = e;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        if (preco > 0) {
            this.preco = preco;
        }
    }

    public abstract float calcularValorImovel();
}