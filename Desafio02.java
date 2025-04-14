/******************************************************************************
Desafio02- Jogo de adivinhação com dificuldade
 Crie um jogo de adivinhação onde o jogador escolhe a dificuldade
 (fácil: 1 a 10, médio: 1 a 50, difícil: 1 a 100). O programa gera um número aleatório(pesquisar)
 e o jogador tem 5 tentativas para acertar. A cada erro, o programa dá dicas: "maior" ou "menor".
 *******************************************************************************/
 import java.util.Scanner;
 import java.util.Random;
 
 public class Desafio02
 {
 
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         Random random = new Random();
 
         int maxNumero = 10;
         int numeroSecreto, tentativa;
         int tentativasRestantes = 5;
 
   
         System.out.println("Escolha a dificuldade:");
         System.out.println("1 - Fácil (1 a 10)");
         System.out.println("2 - Médio (1 a 50)");
         System.out.println("3 - Difícil (1 a 100)");
         System.out.print("Digite sua escolha: ");
         int escolha = scanner.nextInt();
 
   
         switch (escolha) {
             case 1:
                 maxNumero = 10;
                 break;
             case 2:
                 maxNumero = 50;
                 break;
             case 3:
                 maxNumero = 100;
                 break;
             default:
                 System.out.println("Escolha inválida. O jogo será iniciado no modo Fácil.");
         }
 
         numeroSecreto = random.nextInt(maxNumero) + 1;
 
         System.out.println("\nTente adivinhar o número entre 1 e " + maxNumero + ". Você tem 5 tentativas!");
 
       
         while (tentativasRestantes > 0) {
             System.out.print("\nDigite seu palpite: ");
             tentativa = scanner.nextInt();
 
             if (tentativa == numeroSecreto) {
                 System.out.println("🎉 Parabéns! Você acertou o número!");
                 break;
             } else {
                 tentativasRestantes--;
                 if (tentativa < numeroSecreto) {
                     System.out.println("O número secreto é MAIOR!");
                 } else {
                     System.out.println("o número secreto é MENOR!");
                 }
 
                 if (tentativasRestantes > 0) {
                     System.out.println("Tentativas restantes: " + tentativasRestantes);
                 } else {
                     System.out.println("\n Fim de jogo! O número era: " + numeroSecreto);
                 }
             }
         }
 
         
     }
 }