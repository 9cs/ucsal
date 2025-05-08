import java.util.Scanner;

// Faça uma função que receba um vetor
// com as médias finais dos alunos de uma
// turma e a quantidade de alunos da
// turma, calcule e devolva a média da
// turma.

public class mediaTurma {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite a quantidade de alunos na turma: ");
        int q = input.nextInt();
        System.out.println(calcularMedia(preencherVetor(input, q), q));
    }

    public static int[] preencherVetor(Scanner input, int q) {
        int i;
        int[] v = new int[q];
        for(i=0; i<v.length; i++) {
            System.out.print("Digite a média final do aluno " + (i+1) + ": ");
            v[i] = input.nextInt();
        }
        return v;
    }

    public static double calcularMedia(int[] v, int q) {
        double media;
        int soma = 0;
        for (int i=0; i<v.length; i++) {
            soma = soma+v[i]; 
        }
        media = soma/q;
        return media;
    } 
}
