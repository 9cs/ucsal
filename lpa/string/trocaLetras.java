import java.util.Scanner;

// Faça um programa que troque todas as ocorrências de uma letra L1 pela letra L2 em uma
// string. A string e as letras L1 e L2 devem ser fornecidas pelo usuário.

public class trocaLetras {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite uma string: ");
        String texto = sc.nextLine();

        System.out.print("Digite a letra que deseja substituir (L1): ");
        char l1 = sc.next().charAt(0);

        System.out.print("Digite a letra que substituirá (L2): ");
        char l2 = sc.next().charAt(0);

        String resultado = texto.replace(l1, l2);

        System.out.println("Resultado: " + resultado);

    }
}
