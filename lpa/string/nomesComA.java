import java.util.Scanner;

// Faça um programa que receba um nome e imprima o nome somente se a primeira letra do
// nome for ‘a’ (maiúscula ou minúscula).

public class nomesComA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um nome: ");
        String nome = sc.nextLine();

        if (!nome.isEmpty()) {
            char primeiraLetra = nome.toLowerCase().charAt(0);

            if (primeiraLetra == 'a') {
                System.out.println("Nome: " + nome);
            } else {
                System.out.println("O nome não começa com a letra 'a'.");
            }
        }
    }
}
