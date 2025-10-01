public abstract class Pessoa {
    
    protected String nome;

    public Pessoa(String nome){
        this.setNome(nome);
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        if(!nome.isEmpty()){
            this.nome = nome;
        }
    }

    public abstract void imprimirDados();
}