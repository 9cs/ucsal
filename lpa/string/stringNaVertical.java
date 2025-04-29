import java.util.Scanner;

// Faça um programa que receba uma string e mostre-a na vertical.
// Exemplo: palavra = “agora” -> a
//                               g
//                               o
//                               r
//                               a

public class stringNaVertical {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite uma palavra: ");
        String palavra = sc.nextLine();

        System.out.println("Palavra na vertical:");
        for (int i = 0; i < palavra.length(); i++) {
            System.out.println(palavra.charAt(i));
        }
    }
}