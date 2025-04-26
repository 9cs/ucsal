import java.util.Scanner;

// Faça um programa que receba 2 números inteiros e mostre na tela o seguinte menu:
// 1 – Soma
// 2 – Subtração
// 3 – Multiplicação
// 4 – Divisão
// 5 – Trocar valores
// 6 – Sair

// O usuário deverá escolher a opção desejada e, então deve ser mostrado o resultado da operação desejada.
// Caso o usuário escolha a opção 5, os valores devem ser recebidos novamente.
// Uma vez mostrado o resultado da operação escolhida, o menu deve ser mostrado novamente na tela.
// Esse ciclo se repetirá até que o usuário solicite a opção Sair (6).
// Para CADA operação deve ser construída uma função

public class calculadora {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        System.out.print("Digite o primeiro número: ");
        int num1 = sc.nextInt();

        System.out.print("Digite o segundo número: ");
        int num2 = sc.nextInt();

        do {
            System.out.println("\nMenu:");
            System.out.println("1 – Soma");
            System.out.println("2 – Subtração");
            System.out.println("3 – Multiplicação");
            System.out.println("4 – Divisão");
            System.out.println("5 – Trocar valores");
            System.out.println("6 – Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Resultado da soma: " + soma(num1, num2));
                    break;
                case 2:
                    System.out.println("Resultado da subtração: " + subtracao(num1, num2));
                    break;
                case 3:
                    System.out.println("Resultado da multiplicação: " + multiplicacao(num1, num2));
                    break;
                case 4:
                    if (num2 != 0) {
                        System.out.println("Resultado da divisão: " + divisao(num1, num2));
                    } else {
                        System.out.println("Não é possível dividir por zero!");
                    }
                    break;
                case 5:
                    System.out.print("Digite o novo primeiro número: ");
                    num1 = sc.nextInt();
                    System.out.print("Digite o novo segundo número: ");
                    num2 = sc.nextInt();
                    break;
                case 6:
                    System.out.println("Programa encerrado");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 6);
    }

    // Função de soma
    public static int soma(int a, int b) {
        return a+b;
    }

    // Função de subtração
    public static int subtracao(int a, int b) {
        return a-b;
    }

    // Função de multiplicação
    public static int multiplicacao(int a, int b) {
        return a*b;
    }

    // Função de divisão
    public static double divisao(int a, int b) {
        return (double) (a /b); // eh preciso por o cast do double para nao perder as casas decimais
    }
}