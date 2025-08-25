import java.util.Scanner;

// Escreva um programa que substitui as ocorrências de um caractere ‘0’ em uma string por ˆ
// outro caractere ‘1’.

public class substituirZeroPorUm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite uma string contendo 0 e 1: ");
        String original = sc.nextLine();

        String modificada = original.replace('0', '1');

        System.out.println("String modificada: " + modificada);

    }
}
