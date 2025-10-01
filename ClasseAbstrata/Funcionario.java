public abstract class Funcionario extends Pessoa {
    
    protected String matricula;

    public Funcionario(String nome, String matricula){
        super(nome);
        this.setMatricula(matricula);
    }

    public String getMatricula(){
        return this.matricula;
    }

    public void setMatricula(String matricula){
        if(!matricula.isEmpty()){
            this.matricula = matricula;
        }
    }

    public abstract double calcularSalario();
}