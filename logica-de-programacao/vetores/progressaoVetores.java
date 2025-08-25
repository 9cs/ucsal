import java.util.Scanner;

// Faça um programa que receba o primeiro termo e a razão de uma PA e preencha um vetor de
// 20 posições com os termos da PA.

public class progressaoVetores {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Qual o primeiro termo (T1) da Progressão Aritmética? ");
        int t1 = input.nextInt();
        System.out.print("Qual a razão da Progressão Aritmética? ");
        int r = input.nextInt();
        System.out.print("Quantos termos da Progressão Aritmética iremos calcular? ");
        int q = input.nextInt();
        progressaoAritmetica(t1, r, q);
    }

    public static int[] progressaoAritmetica(int t1, int r, int q) {
        int[] v = new int[q];
        // an = a1 + (n-1) * r
        for (int i=0; i<v.length; i++) {
            v[i] = t1+(i-1)*r;
            System.out.print((t1+(i-1)*r) + " ");
        }
    return v;
    }
}
