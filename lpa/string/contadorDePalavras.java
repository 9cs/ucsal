import java.util.Scanner;

// Faça um programa que receba uma frase digitada pelo usuário e informe quantas palavras
// tem. (As palavras são delimitadas por espaços em branco).

public class contadorDePalavras {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int palavras = 0;
        boolean dentroDePalavra = false;

        System.out.print("Digite uma frase: ");
        String frase = sc.nextLine();


        for (int i = 0; i < frase.length(); i++) {
            char c = frase.charAt(i);

            if (c != ' ' && !dentroDePalavra) {
                palavras++;
                dentroDePalavra = true;
            } else if (c == ' ') {
                dentroDePalavra = false;
            }
        }

        System.out.println("Número de palavras: " + palavras);
    }
}
