import java.util.Scanner;

public class multiplicarMatrizes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrizA = obterDimensoesMatriz(scanner, "A");
        int[][] matrizB = obterDimensoesMatriz(scanner, "B");

        if (verificarMultiplicacao(matrizA, matrizB)) {
            preencherMatriz(scanner, matrizA, "A");
            preencherMatriz(scanner, matrizB, "B");

            int[][] matrizC = multiplicacaoMatrizes(matrizA, matrizB);

            exibirMatriz(matrizC, "C (resultado da multiplicação)");
        } else {
            System.out.println("Não é possível multiplicar as matrizes com essas dimensões.");
            System.out.println("Para multiplicar A x B, o número de colunas de A deve ser igual ao número de linhas de B.");
        }
    }

    public static int[][] obterDimensoesMatriz(Scanner scanner, String nomeMatriz) {
        int linhas = 0;
        int colunas = 0;

        while (linhas <= 0 || linhas > 20) {
            System.out.print("Digite o número de linhas da matriz " + nomeMatriz + " (máximo 20): ");
            linhas = scanner.nextInt();

            if (linhas <= 0 || linhas > 20) {
                System.out.println("Número de linhas inválido. Deve ser entre 1 e 20.");
            }
        }

        while (colunas <= 0 || colunas > 20) {
            System.out.print("Digite o número de colunas da matriz " + nomeMatriz + " (máximo 20): ");
            colunas = scanner.nextInt();

            if (colunas <= 0 || colunas > 20) {
                System.out.println("Número de colunas inválido. Deve ser entre 1 e 20.");
            }
        }

        return new int[linhas][colunas];
    }

    public static boolean verificarMultiplicacao(int[][] matrizA, int[][] matrizB) {
        return matrizA[0].length == matrizB.length;
    }

    public static void preencherMatriz(Scanner scanner, int[][] matriz, String nomeMatriz) {
        System.out.println("\nPreencha a matriz " + nomeMatriz + ":");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print("Digite o valor para a posição [" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }
    }

    public static int[][] multiplicacaoMatrizes(int[][] matrizA, int[][] matrizB) {
        int linhasA = matrizA.length;
        int colunasA = matrizA[0].length;
        int colunasB = matrizB[0].length;

        int[][] resultado = new int[linhasA][colunasB];

        for (int i = 0; i < linhasA; i++) {
            for (int j = 0; j < colunasB; j++) {
                for (int k = 0; k < colunasA; k++) {
                    resultado[i][j] += matrizA[i][k] * matrizB[k][j];
                }
            }
        }

        return resultado;
    }

    public static void exibirMatriz(int[][] matriz, String nomeMatriz) {
        System.out.println("\nMatriz " + nomeMatriz + ":");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
