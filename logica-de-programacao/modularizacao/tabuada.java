import java.util.Scanner;

// Escreva um programa em Java que pergunta ao usuário se quer ver a tabuada. Cada vez que
// o usuário respondersim(‘s’) o programa principal deve ler um valor inteiro (maior que 1 e menor
// que 11) e passar como parâmetro para um módulo. O módulo deve calcular e exibir a tabuada
// de multiplicação do valor lido (até 10). O programa deve ter uma função que mostra na tela a
// tabuada do valor recebido por parâmetro.

public class tabuada {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char resposta;

        do {
            System.out.print("Deseja ver a tabuada? (s para sim): ");
            resposta = sc.next().charAt(0);

            if (resposta == 's' || resposta == 'S') {
                System.out.print("Digite um número entre 2 e 10: ");
                int numero = sc.nextInt();

                if (numero > 1 && numero < 11) {
                    mostrarTabuada(numero);
                } else {
                    System.out.println("Número inválido! Digite um número entre 2 e 10.");
                }
            }

        } while (resposta == 's' || resposta == 'S');

        System.out.println("Programa encerrado.");
    }

    public static void mostrarTabuada(int numero) {
        System.out.println("Tabuada do " + numero + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(numero + "x" + i + " = " + (numero * i));
        }
    }
}