import java.util.Scanner;

// Faça um programa que receba uma palavra e a imprima de trás-para-frente.

public class inversorDePalavras {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite uma palavra: ");
        String palavra = sc.nextLine();

        System.out.print("Palavra invertida: ");
        for (int i = palavra.length() - 1; i >= 0; i--) {
            System.out.print(palavra.charAt(i));
        }
    }
}
