package HERANCA_POLIMORFISMO;

public class Enfermeiro extends Pessoa{
    
    int horaTrabalho;
    String setor;
    String numeroCadastro;

    Enfermeiro(int horaTrabalho, String setor, String numeroCadastro,
        String nome, int idade, String documento){
        super(nome,idade,documento);
        this.horaTrabalho = horaTrabalho;
        this.setor = setor;
        this.numeroCadastro = numeroCadastro;
    }

    public void imprimirInfo(){
        super.imprimirInfo();
        System.out.println("Horas trabalhadas: " + this.horaTrabalho);
        System.out.println("Setor: " + this.setor);
        System.out.println("Número de cadastro: " + this.numeroCadastro);
    }
}
