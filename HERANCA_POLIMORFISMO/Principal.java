package HERANCA_POLIMORFISMO;
//UTILIZA O MÉTODO MAIN POR ISSO REFERÊNCIA PRINCIPAL
public class Principal {

    public static void main(String[] args) {
        System.out.println("\nInformações do paciente\n");
        Pessoa paciente = new Paciente("1234","Unimed","Maria",29,"1234567");
        paciente.imprimirInfo();

        System.out.println("\nInformações do enfermeiro\n");

        Pessoa enfermeiro = new Enfermeiro(17,"UTI","12778945",
        "Luciana",29,"1072115542");
        enfermeiro.imprimirInfo();

        System.out.println("\nFim do relatório.\n");
    }
    
}

//POLIMORFISMO = QUANDO É POSSIVEL ATRIBUIR MULTIPLAS FORMAS PARA UMA MESMA ENTIDADE
//=>EXEMPLO: CLASSE PESSOA (ENTIDADE)
//=>ENFERMEIRO (FORMA ATRIBUIDA 1)
//=>PACIENTE (FORMA ATRIBUIDA 2)
