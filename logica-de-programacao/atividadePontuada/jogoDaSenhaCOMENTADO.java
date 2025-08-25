import java.util.Random;
import java.util.Scanner;

/**
 * Classe principal do jogo "Jogo da Senha" (estilo Mastermind).
 * O jogador tenta adivinhar uma senha de 4 dígitos entre 1 e 6.
 * Ele tem até 10 tentativas para acertar.
 */

public class jogoDaSenha {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        boolean debugMode = true; // Modo debug: se true, a senha será exibida para facilitar os testes

        int[] senha = new int[4];       // Vetor que armazena a senha secreta
        int[] tentativa = new int[4];   // Vetor que armazena a tentativa do jogador

        gerarSenha(senha, rand); // Gera uma senha aleatória

        // Introdução do jogo
        System.out.println("=== Jogo da Senha (Mastermind) ===");
        System.out.println("A senha possui 4 dígitos, cada um de 1 a 6.");
        System.out.println("Tente adivinhar a senha em até 10 tentativas!");

        // Mostra a senha se o modo debug estiver ativado
        if (debugMode) {
            mostrarSenhaDebug(senha);
        }

        boolean venceu = false; // Flag para verificar se o jogador acertou a senha
        int tentativas = 0;     // Contador de tentativas

        // Loop principal do jogo (máximo de 10 tentativas)
        while (tentativas < 10 && !venceu) {
            tentativas++;
            System.out.println("\nTentativa " + tentativas + ":");
            System.out.print("Digite 4 números de 1 a 6, separados por espaço: ");
            lerTentativa(tentativa, input); // Lê a tentativa do jogador

            int corretos = contarCorretos(senha, tentativa);     // Conta os dígitos corretos nas posições corretas
            int deslocados = contarDeslocados(senha, tentativa); // Conta os dígitos corretos em posições erradas

            // Exibe o resultado da tentativa
            System.out.println("Dígitos corretos (posição certa): " + corretos);
            System.out.println("Dígitos corretos (posição errada): " + deslocados);

            // Verifica se o jogador venceu
            if (corretos == 4) {
                venceu = true;
                System.out.println("\nParabéns! Você descobriu a senha em " + tentativas + " tentativas!");
            }
        }

        // Se o jogador não vencer após 10 tentativas, mostra a senha correta
        if (!venceu) {
            System.out.print("\nVocê perdeu! A senha correta era: ");
            mostrarSenha(senha);
        }

        input.close(); // Fecha o scanner
    }

    /**
     * Gera uma senha aleatória com 4 números entre 1 e 6.
     */

    public static void gerarSenha(int[] senha, Random rand) {
        for (int i = 0; i < senha.length; i++) {
            senha[i] = rand.nextInt(6) + 1; // Gera números de 1 a 6
        }
    }

    /**
     * Lê a tentativa do jogador, garantindo que os números estejam entre 1 e 6.
     */

    public static void lerTentativa(int[] tentativa, Scanner input) {
        for (int i = 0; i < tentativa.length; i++) {
            int valor = 0;
            boolean valido = false;
            // Validação da entrada
            while (!valido) {
                if (input.hasNextInt()) {
                    valor = input.nextInt();
                    if (valor >= 1 && valor <= 6) {
                        valido = true;
                    } else {
                        System.out.print("Número fora do intervalo. Digite um número de 1 a 6: ");
                    }
                } else {
                    System.out.print("Entrada inválida. Digite um número de 1 a 6: ");
                    input.next(); // Descarta entrada inválida
                }
            }
            tentativa[i] = valor;
        }
    }

    /**
     * Conta quantos dígitos estão corretos e na posição correta.
     */

    public static int contarCorretos(int[] senha, int[] tentativa) {
        int corretos = 0;
        for (int i = 0; i < senha.length; i++) {
            if (tentativa[i] == senha[i]) {
                corretos++;
            }
        }
        return corretos;
    }

    /**
     * Conta quantos dígitos estão corretos, mas em posições diferentes.
     */

    public static int contarDeslocados(int[] senha, int[] tentativa) {
        boolean[] senhaUsada = new boolean[senha.length];
        boolean[] tentativaUsada = new boolean[senha.length];

        // Marca os dígitos que já foram contados como corretos
        for (int i = 0; i < senha.length; i++) {
            if (tentativa[i] == senha[i]) {
                senhaUsada[i] = true;
                tentativaUsada[i] = true;
            }
        }

        int deslocados = 0;
        // Verifica os dígitos corretos em posições erradas
        for (int i = 0; i < tentativa.length; i++) {
            if (!tentativaUsada[i]) {
                for (int j = 0; j < senha.length; j++) {
                    if (!senhaUsada[j] && tentativa[i] == senha[j]) {
                        deslocados++;
                        senhaUsada[j] = true;
                        break; // Garante que o dígito não seja contado duas vezes
                    }
                }
            }
        }
        return deslocados;
    }

    /**
     * Exibe a senha no console.
     */

    public static void mostrarSenha(int[] senha) {
        for (int i = 0; i < senha.length; i++) {
            System.out.print(senha[i] + " ");
        }
        System.out.println();
    }

    /**
     * Exibe a senha no console quando o modo debug está ativado.
     */

    public static void mostrarSenhaDebug(int[] senha) {
        System.out.print("[DEBUG] Senha correta: ");
        mostrarSenha(senha);
    }
}