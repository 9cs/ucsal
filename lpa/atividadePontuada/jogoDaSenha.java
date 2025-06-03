import java.util.Random;
import java.util.Scanner;

public class jogoDaSenha {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        boolean debugMode = true;

        int[] senha = new int[4];
        int[] tentativa = new int[4];

        gerarSenha(senha, rand);

        System.out.println("=== Jogo da Senha (Mastermind) ===");
        System.out.println("A senha possui 4 dígitos, cada um de 1 a 6.");
        System.out.println("Tente adivinhar a senha em até 10 tentativas!");

        if (debugMode) {
            mostrarSenhaDebug(senha);
        }

        boolean venceu = false;
        int tentativas = 0;

        while (tentativas < 10 && !venceu) {
            tentativas++;
            System.out.println("\nTentativa " + tentativas + ":");
            System.out.print("Digite 4 números de 1 a 6, separados por espaço: ");
            lerTentativa(tentativa, input);

            int corretos = contarCorretos(senha, tentativa);
            int deslocados = contarDeslocados(senha, tentativa);

            System.out.println("Dígitos corretos (posição certa): " + corretos);
            System.out.println("Dígitos corretos (posição errada): " + deslocados);

            if (corretos == 4) {
                venceu = true;
                System.out.println("\nParabéns! Você descobriu a senha em " + tentativas + " tentativas!");
            }
        }

        if (!venceu) {
            System.out.print("\nVocê perdeu! A senha correta era: ");
            mostrarSenha(senha);
        }

        input.close();
    }

    public static void gerarSenha(int[] senha, Random rand) {
        for (int i = 0; i < senha.length; i++) {
            senha[i] = rand.nextInt(6) + 1;
        }
    }

    public static void lerTentativa(int[] tentativa, Scanner input) {
        for (int i = 0; i < tentativa.length; i++) {
            int valor = 0;
            boolean valido = false;
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
                    input.next();
                }
            }
            tentativa[i] = valor;
        }
    }

    public static int contarCorretos(int[] senha, int[] tentativa) {
        int corretos = 0;
        for (int i = 0; i < senha.length; i++) {
            if (tentativa[i] == senha[i]) {
                corretos++;
            }
        }
        return corretos;
    }

    public static int contarDeslocados(int[] senha, int[] tentativa) {
        boolean[] senhaUsada = new boolean[senha.length];
        boolean[] tentativaUsada = new boolean[senha.length];

        for (int i = 0; i < senha.length; i++) {
            if (tentativa[i] == senha[i]) {
                senhaUsada[i] = true;
                tentativaUsada[i] = true;
            }
        }

        int deslocados = 0;
        for (int i = 0; i < tentativa.length; i++) {
            if (!tentativaUsada[i]) {
                for (int j = 0; j < senha.length; j++) {
                    if (!senhaUsada[j] && tentativa[i] == senha[j]) {
                        deslocados++;
                        senhaUsada[j] = true;
                    }
                }
            }
        }
        return deslocados;
    }

    public static void mostrarSenha(int[] senha) {
        for (int i = 0; i < senha.length; i++) {
            System.out.print(senha[i] + " ");
        }
        System.out.println();
    }
    
    public static void mostrarSenhaDebug(int[] senha) {
        System.out.print("[DEBUG] Senha correta: ");
        mostrarSenha(senha);
    }
}
