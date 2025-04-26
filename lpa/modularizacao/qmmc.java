import java.util.Scanner;

// Faça um programa que receba dois números e descubra seu MMC. A identificação do MMC
// deve ser feita dentro de uma função que retorne tal valor. A leitura e a escrita dos dados, além
// da ativação do módulo MMC, devem ficar na função principal.

public class qmmc {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite um numero: ");
        int num1 = input.nextInt();
        System.out.print("Digite um numero: ");
        int num2 = input.nextInt();

        int mmc = mmc(num1, num2);
        System.out.println("O MMC de " + num1 + " e " + num2 + " é: " + mmc);
    }

    public static int mmc(int num1, int num2) {
        return (num1 * num2) / mdc(num1, num2);
    }

    // Método para calcular o MDC usando o algoritmo de Euclides
    public static int mdc(int num1, int num2) {
        while (num2 != 0) {
            int resto = (num1 % num2);
            num1 = num2;
            num2 = resto;
        }
        return num1;
    }
}
