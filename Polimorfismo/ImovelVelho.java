public class ImovelVelho extends Imovel {

    private static final float TAXA_IMOVEL_VELHO = 0.7f;
    
    public ImovelVelho(Endereco e, float preco) {
        super(e, preco);
    }

    @Override
    public float calcularValorImovel() {
        return this.getPreco() * TAXA_IMOVEL_VELHO;
    }
}