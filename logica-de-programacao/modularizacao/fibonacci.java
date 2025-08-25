import java.util.Scanner;

// Faça uma função que receba por parâmetro um valor n e devolva o n-ésimo termo da
// sequência de Fibonacci. Em seguida faça um programa que use a função. Sequência de
// Fibonacci: 1, 1, 2, 3, 5, 8, 13, 21...

public class fibonacci {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite qual termo da sequência de Fibonacci deseja: ");
        int n = sc.nextInt();

        int termo = mfibonacci(n);

        System.out.println("O " + n + "º termo da sequência de Fibonacci é: " + termo);
    }

    public static int mfibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        int anterior = 1;
        int atual = 1;
        int proximo = 0;

        for (int i = 3; i <= n; i++) {
            proximo = anterior + atual;
            anterior = atual;
            atual = proximo;
        }

        return atual;
    }
}
