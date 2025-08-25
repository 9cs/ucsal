import java.util.Scanner;

// Faça um programa que calcule a soma dos N primeiros números primos, sendo N definido
// pelo usuário na função main. O programa ainda deverá ter a função primo responsável por
// verificar se o número em questão é primo ou não.

public class primos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite a quantidade de números primos que deseja somar: ");
        int n = sc.nextInt();
        int contador = 0;
        int numero = 2;         // 1º numero primo
        int soma = 0;

        while (contador < n) {
            if (primo(numero)) {
                soma += numero;
                contador++;
            }
            numero++;
        }

        System.out.println("A soma dos " + n + " primeiros números primos é: " + soma);
    }

        public static boolean primo(int numero) {
            if (numero <= 1) {
                return false;
            }
            for (int i = 2; i <= numero / 2; i++) {
                if (numero % i == 0) {
                    return false;
                }
            }
            return true;
        }
}
