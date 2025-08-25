import java.util.Scanner;

// Faça um programa que conte o número de 1’s que aparecem em um string.
// Exemplo:  ́ “0011001” -> 3

public class contadorDeUns {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite uma sequência de 0s e 1s: ");
        String entrada = sc.nextLine();

        int contador = 0;

        for (int i = 0; i < entrada.length(); i++) {
            if (entrada.charAt(i) == '1') {
                contador++;
            }
        }

        System.out.println("Número de 1's na string: " + contador);
    }
}
