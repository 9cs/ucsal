import java.util.Random;
import java.util.Scanner;

// Faça uma função que receba um vetor
// com 50 números inteiros e um número.
// Ao final a função deve devolver quantas
// vezes o número recebido aparece no
// vetor.

public class contadorVetor {
    public static void main(String[] args) {
        System.out.print("Digite um número para verificar no vetor: ");
        print(preencher());
    }

    public static int[] preencher() {
        int i;
        int[] v = new int[50];
        Random randint = new Random();
        for(i=0; i<v.length; i++) {
        v[i] = randint.nextInt(10);
        }
    return v;
    }

    public static void print(int[] v) {
        int c = 0;
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.close();
        System.out.print("Vetor: ");
        for(int i=0; i<v.length; i++) {
            if (v[i]==n) {
                c++;
            }
            System.out.print(v[i] + " ");
        } System.out.println("\nO número " + n + " aparece "  + c + " vezes no vetor!");
    }
}
