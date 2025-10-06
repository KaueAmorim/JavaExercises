public class AtracaoEspecial {

    private String nome;
    private int capacidadeMax; 
    private int presentes;

    public AtracaoEspecial(String nome, int capacidadeMax, int presentes){
        this.setNome(nome);
        this.setCapacidadeMax(capacidadeMax);
        this.setPresentes(presentes);
    }

    public String getNome(){
        return this.nome;
    }

    public int getCapacidadeMax(){
        return this.capacidadeMax;
    }

    public int getPresentes(){
        return this.presentes;
    }

    public void setNome(String nome){
        if(!nome.isEmpty()) {
            this.nome = nome;
        }
    }

    public void setCapacidadeMax(int capacidadeMax){
        if(capacidadeMax > 0){
            this.capacidadeMax = capacidadeMax;
        }
    }

    public void setPresentes(int presentes){
        if(presentes > 0){
            this.presentes = presentes;
        }
    }

    public boolean capacidadeValida(){
        return presentes <= capacidadeMax;
    }
}