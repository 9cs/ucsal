import java.util.Scanner;

// Faça um programa que receba um nome e mostre na vertical em escada.
// Exemplo: nome = “agora”
//                  a
//                  ag
//                  ago
//                  agor
//                  agora

public class stringVerticalEscada {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite uma palavra: ");
        String palavra = sc.nextLine();

        System.out.println("Palavra na vertical:");
        String prev = ""; 
        for (int i = 0; i < palavra.length(); i++) {
            prev = prev+palavra.charAt(i);
            System.out.println(prev);
        }
    }
}