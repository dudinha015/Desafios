/******************************************************************************
Desenvolver um sistema bancário básico que permita criar contas para múltiplos usuários, realizar depósitos,
saques e consultar saldos, utilizando apenas arrays e estruturas de controle fundamentais do Java.

*******************************************************************************/
import java.util.Scanner;

public class SistemaBancario {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        String[] nomes = new String[5];
        double[] saldos = new double[5];
        int[] contas = new int[5];
        int totalContas = 0;
        int opcao;

        while (true) {
           
            System.out.println("\n==== Sistema Bancário ====");
            System.out.println("1 - Criar uma nova conta");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Consultar saldo");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = ler.nextInt();
            ler.nextLine(); 

            if (opcao == 1) {
                if (totalContas < nomes.length) { 
                    System.out.print("\nQual é o seu nome? ");
                    String nome = ler.nextLine();
                    System.out.print("Qual é a sua idade? ");
                    int idade = ler.nextInt();
                    ler.nextLine();

                    if (idade < 16) {
                        System.out.println("Desculpe, você precisa ter pelo menos 16 anos para criar uma conta.");
                    } else {
                        int numeroDaConta = 1000 + totalContas;
                        nomes[totalContas] = nome;
                        contas[totalContas] = numeroDaConta;
                        saldos[totalContas] = 0.0;
                        totalContas++;
                        System.out.println("Conta criada com sucesso! Seu número de conta é: " + numeroDaConta);
                    }
                } else {
                    System.out.println("Não é possível criar mais contas. Limite atingido.");
                }
            }
            else if (opcao == 2) {
                System.out.print("\nDigite o número da sua conta: ");
                int contaDeposito = ler.nextInt();
                ler.nextLine();
                int indiceDeposito = encontrarContaDesejada(contas, contaDeposito);

                if (indiceDeposito != -1) {
                    System.out.print("Digite o valor do depósito: ");
                    double deposito = ler.nextDouble();

                    if (deposito > 0) {
                        saldos[indiceDeposito] += deposito;
                        System.out.println("Depósito de R$" + deposito + " realizado com sucesso!");
                    } else {
                        System.out.println("O valor de depósito deve ser positivo.");
                    }
                } else {
                    System.out.println("Conta não encontrada.");
                }
            }
            else if (opcao == 3) {
                System.out.print("\nDigite o número da sua conta: ");
                int contaSaque = ler.nextInt();
                ler.nextLine();
                int indiceSaque = encontrarContaDesejada(contas, contaSaque);

                if (indiceSaque != -1) {
                    System.out.print("Digite o valor para saque: ");
                    double saque = ler.nextDouble();

                    if (saque > 0 && saque <= saldos[indiceSaque]) {
                        saldos[indiceSaque] -= saque;
                        System.out.println("Saque de R$" + saque + " realizado com sucesso.");
                    } else if (saque > saldos[indiceSaque]) {
                        System.out.println("Saldo insuficiente para saque.");
                    } else {
                        System.out.println("Valor inválido para saque.");
                    }
                } else {
                    System.out.println("Conta não encontrada.");
                }
            }
            else if (opcao == 4) {
                System.out.print("\nDigite o número da sua conta: ");
                int contaConsulta = ler.nextInt();
                ler.nextLine();
                int indiceConsulta = encontrarContaDesejada(contas, contaConsulta);

                if (indiceConsulta != -1) {
                    System.out.println("Saldo atual da conta " + contaConsulta + ": R$" + saldos[indiceConsulta]);
                } else {
                    System.out.println("Conta não encontrada.");
                }
            }
            else if (opcao == 5) {
                System.out.println("Saindo do sistema. Até breve!");
                
                break;
            }
            else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static int encontrarContaDesejada(int[] contas, int numeroDaConta) {
        for (int i = 0; i < contas.length; i++) {
            if (contas[i] == numeroDaConta) {
                return i;
            }
        }
        return -1;
    }
}
