/******************************************************************************
Desafio01- Sistema de votação com contagem por candidato
Simule uma eleição com 3 candidatos. Os votos são inseridos até que o usuário digite 0.
O programa deve validar se o voto é válido (1, 2, 3)
e exibir ao final a quantidade de votos por candidato e o vencedor. Empates devem ser considerados.

*******************************************************************************/
 import java.util.Scanner;
 


public class Desafio01 {

    public static void main(String[] args) {
       
        int votosCandidato1 = 0;
        int votosCandidato2 = 0;
        int votosCandidato3 = 0;

        Scanner ler = new Scanner(System.in);

        while (true) {
           
            System.out.println("Digite o número do seu voto (1, 2, 3) ou 0 para encerrar a votação:");
            int voto = ler.nextInt();

           if (voto == 0) {
                break;
            }

           
            switch (voto) {
                case 1:
                    votosCandidato1++;
                    break;
                case 2:
                    votosCandidato2++;
                    break;
                case 3:
                    votosCandidato3++;
                    break;
                default:
                    System.out.println("Voto inválido! Digite um número entre 1 e 3.");
                    break;
            }
        }

       
        System.out.println("\nResultado da eleição:");
        System.out.println("Candidato 1: " + votosCandidato1 + " votos");
        System.out.println("Candidato 2: " + votosCandidato2 + " votos");
        System.out.println("Candidato 3: " + votosCandidato3 + " votos");

     
        int maxVotos = Math.max(Math.max(votosCandidato1, votosCandidato2), votosCandidato3);

        if ((votosCandidato1 == maxVotos && votosCandidato2 == maxVotos) ||
            (votosCandidato1 == maxVotos && votosCandidato3 == maxVotos) ||
            (votosCandidato2 == maxVotos && votosCandidato3 == maxVotos)) {
            System.out.println("Houve um empate!");
        } else if (votosCandidato1 == maxVotos) {
            System.out.println("O vencedor é o Candidato 1.");
        } else if (votosCandidato2 == maxVotos) {
            System.out.println("O vencedor é o Candidato 2.");
        } else if (votosCandidato3 == maxVotos) {
            System.out.println("O vencedor é o Candidato 3.");
        }

     
    }
}