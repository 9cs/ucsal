import java.util.Random;
import java.util.Scanner;

public class jogoDaSenhaCOMENTADO {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Para ler a entrada do usuário
        Random rand = new Random(); // Para gerar números aleatórios

        boolean debugMode = true; // Se true, mostra a senha no início (útil para testes)

        int[] senha = new int[4];      // Vetor que armazena a senha secreta
        int[] tentativa = new int[4];  // Vetor que armazena a tentativa do usuário

        gerarSenha(senha, rand); // Gera a senha aleatória

        System.out.println("=== Jogo da Senha (Mastermind) ===");
        System.out.println("A senha possui 4 dígitos, cada um de 1 a 6.");
        System.out.println("Tente adivinhar a senha em até 10 tentativas!");

        if (debugMode) {
            mostrarSenhaDebug(senha); // Mostra a senha se debugMode for true
        }

        boolean venceu = false; // Indica se o usuário venceu
        int tentativas = 0;     // Conta o número de tentativas

        // Loop principal do jogo: até 10 tentativas ou até acertar a senha
        while (tentativas < 10 && !venceu) {
            tentativas++;
            System.out.println("\nTentativa " + tentativas + ":");
            System.out.print("Digite 4 números de 1 a 6, separados por espaço: ");
            lerTentativa(tentativa, input); // Lê a tentativa do usuário

            int corretos = contarCorretos(senha, tentativa);     // Dígitos certos na posição certa
            int deslocados = contarDeslocados(senha, tentativa); // Dígitos certos na posição errada

            System.out.println("Dígitos corretos (posição certa): " + corretos);
            System.out.println("Dígitos corretos (posição errada): " + deslocados);

            if (corretos == 4) {
                venceu = true;
                System.out.println("\nParabéns! Você descobriu a senha em " + tentativas + " tentativas!");
            }
        }

        // Se não venceu, mostra a senha correta
        if (!venceu) {
            System.out.print("\nVocê perdeu! A senha correta era: ");
            mostrarSenha(senha);
        }

        input.close(); // Fecha o Scanner
    }

    // Gera uma senha aleatória de 4 dígitos (1 a 6)
    public static void gerarSenha(int[] senha, Random rand) {
        for (int i = 0; i < senha.length; i++) {
            senha[i] = rand.nextInt(6) + 1; // números de 1 a 6 (excluindo o zero)
        }
    }

    // Lê a tentativa do usuário, garantindo que cada número está entre 1 e 6
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
                    input.next(); // Descarta a entrada inválida
