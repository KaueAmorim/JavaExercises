public class FuncionarioMensalista extends Funcionario {
    
    private double salarioBase;
    private double horasExtras;

    public FuncionarioMensalista(String nome, String matricula, double salarioBase, int horasExtras){
        super(nome, matricula);
        this.setSalarioBase(salarioBase);
        this.setHorasExtras(horasExtras);
    }

    public double getSalarioBase(){
        return this.salarioBase;
    }

    public void setSalarioBase(double salarioBase){
        if(salarioBase > 0){
            this.salarioBase = salarioBase;
        }
    }

    public double getHorasExtras(){
        return this.horasExtras;
    }

    public void setHorasExtras(double horasExtras){
        if(horasExtras >= 0){
            this.horasExtras = horasExtras;
        }
    }

    public void imprimirDados(){
        System.out.println("*** Dados do Funcionário Mensalista ***");
        System.out.println("Nome: " + getNome());
        System.out.println("Matrícula: " + getMatricula());
        System.out.println("Salário base mensal: " + getSalarioBase());
        System.out.println("Horas extras: " + getHorasExtras());
        System.out.println("Salário do mês " + calcularSalario());
    }

    public double calcularSalario(){
        return (salarioBase + (horasExtras * (salarioBase/160)));
    }
}