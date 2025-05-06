import java.util.Scanner;

public class fibonacci {
    public static void main(String[] args) {
        receberfibonacci();
    }

    public static void mostrar(int[] v) {
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println();
    }

    public static void receberfibonacci() {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite um número maior que 0: ");
        int n = input.nextInt();
        int[] v = new int[n];
        if (n>0){
            if (v.length > 0) {
            v[0] = 1;
            }
            if (v.length > 1) {
            v[1] = 1;
            }
            for (int i = 2; i < v.length; i++) {
            v[i] = v[i - 1] + v[i - 2];
            }
            mostrar(v);
        }else{
            System.out.print("Digite um número maior que 0: ");
            fibonacci();
        }
        input.close();
    }
}
