import java.util.Scanner;

// Faça um programa que receba o nome e a idade de 20 pessoas e armazene em dois vetores.
// Uma vez preenchidos os vetores, o programa deve calcular a média das idades e listar os nomes
// das pessoas que têm idade acima da média.


public class idadeMedia {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Quantas pessoas iremos contabilizar? ");
        int q = input.nextInt();
        String[] nomes = vetorNomes(input, q);
        int[] idades = vetorIdades(input, nomes, q);
        double media = calcularMedia(nomes, idades, q);
        verificarMedia(nomes, idades, media);
    }

    public static String[] vetorNomes(Scanner input, int q) {
        String[] nomes = new String[q];
        for (int i=0; i<q; i++) {
            System.out.print("Digite o nome da pessoa nº" + i + ": ");
            nomes[i] = input.next();
        }
        return nomes;
    }    

    public static int[] vetorIdades(Scanner input, String[] nomes, int q) {
        int[] idades = new int[q];
        for (int i=0; i<idades.length; i++) {
        System.out.print("Digite a idade de " + nomes[i] + ": ");
        idades[i] = input.nextInt();
        }
        return idades;
    }

    public static double calcularMedia(String[] nomes, int[] idades, int q) {
        double media;
        int soma = 0;
        for (int i=0; i<q; i++) {
            soma = soma+idades[i]; 
        }
        media = soma/q;
        return media;
    } 

    public static void verificarMedia(String[] nomes, int[] idades, double media) {
        for (int i=0; i<idades.length; i++) {
            if (idades[i]>media) {
                System.out.println(nomes[i] + " tem " + idades[i] + " anos, então está acima da média de " + media + " anos.");
            }
        } 
    }
}
