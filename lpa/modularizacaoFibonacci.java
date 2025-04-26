import java.util.Scanner;

public class modularizacaoFibonacci {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite qual termo da sequência de Fibonacci deseja: ");
        int n = sc.nextInt();

        int termo = fibonacci(n);

        System.out.println("O " + n + "º termo da sequência de Fibonacci é: " + termo);
    }

    public static int fibonacci(int n) {
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
