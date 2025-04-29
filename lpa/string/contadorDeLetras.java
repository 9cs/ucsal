import java.util.Scanner;

//  Faça um programa que receba uma string e uma letra e informe quantas vezes a letra recebida
// aparece na string.

public class contadorDeLetras {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite uma string: ");
        String texto = sc.nextLine();

        System.out.print("Digite a letra que deseja contar: ");
        char letra = sc.next().charAt(0);

        int contador = 0;

        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == letra) {
                contador++;
            }
        }

        System.out.println("A letra '" + letra + "' aparece " + contador + " vez(es) na string.");
    }
}
