import java.util.Scanner;

// 2. Faça um programa em Java que receba três valores inteiros referentes ao tamanho dos três
// lados de um triângulo. Para formar um triângulo cada lado deve ser menor do que a soma dos
// outros dois lados. Uma vez verificado que os valores estão corretos (ou seja, formam um
// triângulo) o programa deve classificá-lo em equilátero (todos os lados iguais), isósceles (dois
// lados iguais), escaleno (todos os lados diferentes).

public class trianguloCondicional {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o 1º lado do triangulo: ");
        int n1 = sc.nextInt();
        System.out.print("Digite o 2º lado do triangulo: ");
        int n2 = sc.nextInt();
        System.out.print("Digite o 3º lado do triangulo: ");
        int n3 = sc.nextInt();

        if ((n1+n2>n3) && (n2+n3>n1) && (n3+n1>n2)) {
            // É um triângulo válido
            if ((n1==n2) && (n2==n3)) {
                // Equilátero
                System.out.println("Triângulo Equilátero");
            } else {
                if ((n1==n2) || (n2==n3) || (n1==n3)) {
                    // Isósceles
                    System.out.println("Triângulo Isósceles");
                } else {
                    // Escaleno
                    System.out.println("Triângulo Escaleno");
                }
            }
        } else {
            // NÃO é um triângulo válido
            System.out.println("Os lados fornecidos não formam um triângulo válido.");
        }
    }
}
