package vetores;

import java.util.Random;
import java.util.Scanner;

public class jogoDaSenha {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        boolean debugMode = false;
        int nivel = 1;
        boolean jogando = true;

        System.out.println("=== Jogo da Senha ===");

        while (jogando) {
            boolean completouNivel = jogarNivel(input, rand, nivel, debugMode);

            if (completouNivel) {
                System.out.print("Parabéns! Você completou o nível" + nivel);
                nivel++;
            } else {
                jogando = false;
            }
        }
        System.out.println("Obrigado por jogar!");
    }

    public static void exibirInformacoesNivel(int nivel, int alcance) {
        System.out.println("\n--- Nível " + nivel + " (valores de 1 a " + alcance + ") --- ");
        System.out.println("Repita sequências crescentes até completar 10 rodadas.");
    }

    public static int gerarProximoNumeroSequencia(Random rand, int alcance) {
        return rand.nextInt(alcance) + 1;
    }

    public static void exibirSequenciaDebug(int[] sequencia, int tamanho) {
        System.out.print("Sequência: ");
        for (int j = 0; j < tamanho; j++) {
            System.out.print(sequencia[j] + " ");
        }
        System.out.println();
    }

    public static int[] lerTentativaUsuario(Scanner input, int tamanho) {
        int[] tentativa = new int[tamanho];
        System.out.println(
                "Digite a sequência completa, separados por espaço:"
        );
        for (int j = 0; j < tamanho; j++) {
            while (!input.hasNextInt()) {
                System.out.print("Entrada inválida. Digite um inteiro: ");
                input.next();
            }
            tentativa[j] = input.nextInt();
        }
        return tentativa;
    }

    public static boolean verificarTentativa(int[] sequenciaOriginal, int[] tentativaUsuario, int tamanho) {
        boolean acertou = true;
        int i = 0;
        while (i < tamanho && acertou) {
            if (tentativaUsuario[i] != sequenciaOriginal[i]) {
                acertou = false;
            }
            i++;
        }
        return acertou;
    }

    public static boolean jogarNivel(Scanner input, Random rand, int nivel, boolean debugMode) {
        int alcance = nivel * 3;
        exibirInformacoesNivel(nivel, alcance);

        int[] sequencia = new int[10]; // Máximo de 10 números na sequência
        int rodada = 1;
        int tamanhoAtualDaSequencia = 0;
        boolean nivelEmAndamento = true;

        while (rodada <= 10 && nivelEmAndamento) {
            sequencia[tamanhoAtualDaSequencia] = gerarProximoNumeroSequencia(rand, alcance);
            tamanhoAtualDaSequencia++;

            if (debugMode) {
                exibirSequenciaDebug(sequencia, tamanhoAtualDaSequencia);
            }

            int[] tentativa = lerTentativaUsuario(input, tamanhoAtualDaSequencia);
            boolean acertouRodada = verificarTentativa(sequencia, tentativa, tamanhoAtualDaSequencia);

            if (acertouRodada) {
                System.out.println("Correto! Próxima rodada.");
                rodada++;
            } else {
                System.out.println("Errado! Fim de jogo.");
                System.out.printf("Você alcançou a rodada %d do nível %d.%n", rodada, nivel);
                nivelEmAndamento = false;
            }
        }
        return nivelEmAndamento;
    }
}
