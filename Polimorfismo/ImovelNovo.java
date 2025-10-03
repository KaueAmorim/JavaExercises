public class ImovelNovo extends Imovel {

    private static final float TAXA_IMOVEL_NOVO = 1.0f;

    public ImovelNovo(Endereco e, float preco) {
        super(e, preco);
    }

    @Override
    public float calcularValorImovel() {
        return this.getPreco() * TAXA_IMOVEL_NOVO;
    }
}