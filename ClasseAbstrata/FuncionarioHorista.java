public class FuncionarioHorista extends Funcionario {
    
    private double valorHora;
    private int horasTrabalhadas;

    public FuncionarioHorista(String nome, String matricula, double valorHora, int horasTrabalhadas){
        super(nome, matricula);
        this.setValorHora(valorHora);
        this.setHorasTrabalhadas(horasTrabalhadas);
    }

    public double getValorHora(){
        return this.valorHora;
    }

    public void setValorHora(double valorHora){
        if(valorHora > 0){
            this.valorHora = valorHora;
        }
    }

    public int getHorasTrabalhadas(){
        return this.horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas){
        if(horasTrabalhadas >= 0){
            this.horasTrabalhadas = horasTrabalhadas;
        }
    }

    public void imprimirDados(){
        System.out.println("*** Dados do Funcionário Horista ***");
        System.out.println("Nome: " + getNome());
        System.out.println("Matrícula: " + getMatricula());
        System.out.println("Valor da hora: " + getValorHora());
        System.out.println("Horas trabalhadas: " + getHorasTrabalhadas());
        System.out.println("Salário do mês " + calcularSalario());
    }

    public double calcularSalario(){
        return (valorHora * horasTrabalhadas);
    }
}