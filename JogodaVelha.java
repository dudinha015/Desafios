import java.util.Scanner;

public class JogodaVelha {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        char[][] tabuleiro = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
        System.out.print("Digite o nome do Jogador 1 (X): ");
        String jogador1 = ler.nextLine();
        System.out.print("Digite o nome do Jogador 2 (O): ");
        String jogador2 = ler.nextLine();
        int jogadas = 0;
        char jogadorAtual = 'X';
        String nomeJogadorAtual = jogador1;
        while (true) {
            mostrarTabuleiro(tabuleiro);
            System.out.println(nomeJogadorAtual + " (" + jogadorAtual + "), digite a posição da linha (0, 1 ou 2):");
            int linha = ler.nextInt();
            System.out.println(nomeJogadorAtual + " (" + jogadorAtual + "), digite a posição da coluna (0, 1 ou 2):");
            int coluna = ler.nextInt();
            if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2) {
                System.out.println("Posição inválida. Tente novamente.");
                continue;
            }
            if (tabuleiro[linha][coluna] != ' ') {
                System.out.println("Posição já preenchida! Tente novamente.");
                continue;
            }
            tabuleiro[linha][coluna] = jogadorAtual;
            jogadas++;
            String vencedor = verificarVencedor(tabuleiro, jogadorAtual, jogador1, jogador2);
            if (!vencedor.equals("")) {
                mostrarTabuleiro(tabuleiro);
                System.out.println("Parabéns, " + vencedor + "! Você venceu o jogo.");
                break;
            }
            if (jogadas == 9) {
                mostrarTabuleiro(tabuleiro);
                System.out.println("Empate! Ninguém venceu.");
                break;
            }
            if (jogadorAtual == 'X') {
                jogadorAtual = 'O';
                nomeJogadorAtual = jogador2;
            } else {
                jogadorAtual = 'X';
                nomeJogadorAtual = jogador1;
            }
        }
    }
    public static void mostrarTabuleiro(char[][] tab) {
        System.out.println("\nTabuleiro:");
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + tab[i][0] + " | " + tab[i][1] + " | " + tab[i][2]);
            if (i < 2) {
                System.out.println("---+---+---");
            }
        }
        System.out.println();
    }
    public static String verificarVencedor(char[][] tab, char jogadorAtual, String jogador1, String jogador2) {
   
        for (int i = 0; i < 3; i++) {
            if (tab[i][0] == jogadorAtual && tab[i][1] == jogadorAtual && tab[i][2] == jogadorAtual) {
                return jogadorAtual == 'X' ? jogador1 : jogador2;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (tab[0][i] == jogadorAtual && tab[1][i] == jogadorAtual && tab[2][i] == jogadorAtual) {
                return jogadorAtual == 'X' ? jogador1 : jogador2;
            }
        }
        if (tab[0][0] == jogadorAtual && tab[1][1] == jogadorAtual && tab[2][2] == jogadorAtual) {
            return jogadorAtual == 'X' ? jogador1 : jogador2;
        }
        if (tab[0][2] == jogadorAtual && tab[1][1] == jogadorAtual && tab[2][0] == jogadorAtual) {
            return jogadorAtual == 'X' ? jogador1 : jogador2;
        }
        return "";
    }
}