public class CalculadoraMedia {

    // Método que recebe três notas e retorna o resultado da média
    public static double calcularMedia(double nota1, double nota2, double nota3) {
        return (nota1 + nota2 + nota3) / 3.0;
    }

    public static void main(String[] args) {
        double n1 = 7.5;
        double n2 = 8.0;
        double n3 = 9.2;

        double resultado = calcularMedia(n1, n2, n3);

        System.out.println("=== CÁLCULO DE MÉDIA ===");
        System.out.println("Notas informadas: " + n1 + ", " + n2 + ", " + n3);
        System.out.printf("A média final é: %.2f\n", resultado);
    }
}
