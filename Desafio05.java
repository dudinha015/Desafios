/******************************************************************************
Desafio05- Simulador de empréstimo com juros compostos
Peça ao usuário um valor de empréstimo e em quantas parcelas deseja pagar.
Calcule o valor final com juros compostos de 2% ao mês. 
Mostre o valor final e o valor de cada parcela. Permita simular vários empréstimos.


 *******************************************************************************/
import java.util.Scanner;

public class Desafio05 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        double jurosMensal = 0.02; 
        
        
        while (true) {
           
            System.out.print("Digite o valor do empréstimo: R$ ");
            double valorEmprestimo = ler.nextDouble();

           
            System.out.print("Digite o número de parcelas: ");
            int parcelas = ler.nextInt();

            
            double valorFinal = valorEmprestimo * Math.pow(1 + jurosMensal, parcelas);

           
            double valorParcela = valorFinal / parcelas;

            
            System.out.println("\n--- Resultados ---");
            System.out.printf("Valor do empréstimo: R$ %.2f\n", valorEmprestimo);
            System.out.printf("Número de parcelas: %d\n", parcelas);
            System.out.printf("Valor final com juros compostos: R$ %.2f\n", valorFinal);
            System.out.printf("Valor de cada parcela: R$ %.2f\n", valorParcela);

            
            System.out.print("\nDeseja simular outro empréstimo? (s/n): ");
            char resposta = ler.next().charAt(0);

            if (resposta == 'n' || resposta == 'N') {
                break; 
            }
        }

        System.out.println("Programa encerrado, até breve!");
       
    }
}