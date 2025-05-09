import java.util.Scanner;

// Faça uma função que receba um vetor
// com as médias dos alunos de uma
// turma, a quantidade de alunos da turma
// e devolva quantos alunos ficaram acima
// da média da turma.
// Obs: use a função do exercício 6 para
// calcular a média da turma.

public class alunosMediaCount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite a quantidade de alunos na turma: ");
        int q = input.nextInt();
        
        int[] v = preencherVetor(input, q);
        double media = calcularMedia(v, q);

        System.out.println(verificarMedia(media, v));
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

    public static int verificarMedia(double media, int[] v) {
        int c = 0;
        for (int i=0; i<v.length; i++) {
            if (v[i]>media) {
                c++;
            }
        } 
        System.out.println("Quantidade de alunos acima da média: " + c);
        return c;
    }
}
