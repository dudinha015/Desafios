/******************************************************************************
Desafio03-  Cadastro de notas com classificação
O programa deve permitir o cadastro de várias notas (entre 0 e 10). A cada nota inserida, o sistema deve classificar como:

Excelente (>= 9)
Bom (>= 7)
Regular (>= 5)
Insuficiente (< 5)
*Quando o usuário digitar -1,
* o programa termina e exibe a média geral e a contagem de cada classificação.
 *******************************************************************************/
 import java.util.Scanner;

public class Desafio03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double somaNotas = 0;
        int contagemNotas = 0;
        int excelente = 0;
        int bom = 0;
        int regular = 0;
        int insuficiente = 0;

        while (true) {
            
            System.out.print("Digite uma nota (0 a 10) ou -1 para sair: ");
            double nota = scanner.nextDouble();

            
            if (nota == -1) {
                break;
            }

          //Processamento
            if (nota >= 0 && nota <= 10) {
               
                somaNotas += nota;
                contagemNotas++;

               
                if (nota >= 9) {
                    excelente++;
                } else if (nota >= 7) {
                    bom++;
                } else if (nota >= 5) {
                    regular++;
                } else {
                    insuficiente++;
                }
            } else {
                System.out.println("Nota inválida! Digite uma nota entre 0 e 10.");
            }
        }

        //Saída de dados
        if (contagemNotas > 0) {
            double media = somaNotas / contagemNotas;
            System.out.println("\nMédia das notas: " + media);
            System.out.println("Classificações:");
            System.out.println("Excelente: " + excelente);
            System.out.println("Bom: " + bom);
            System.out.println("Regular: " + regular);
            System.out.println("Insuficiente: " + insuficiente);
        } else {
            System.out.println("Nenhuma nota válida foi inserida.");
        }

        
    }
}