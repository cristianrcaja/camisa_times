package tests;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("Escolha uma das opções abaixo:");
            System.out.println("0 - Sair");
            System.out.println("1 - Cadastrar nova camiseta");
            System.out.println("2 - Listar todas as camisetas");
            System.out.println("3 - Consultar camiseta por código");
            System.out.println("4 - Consultar por xxx");
            System.out.println("5 - Alterar uma camiseta");
            System.out.println("6 - Excluir uma camiseta");
            System.out.print("Sua escolha: ");
            int op = leitor.nextInt();

            switch (op) {
                case 0:
                    System.out.println("Programa encerrado. Até mais!");
                    System.exit(0);
                    break;
                case 1:
                    //  Implementar cadastro de camiseta
                    System.out.println("Cadastro de camiseta ainda não implementado.");
                    break;
                case 2:
                    //  Implementar listagem de camisetas
                    System.out.println("Listagem de camisetas ainda não implementada.");
                    break;
                case 3:
                    //  Implementar consulta de camiseta por código
                    System.out.println("Consulta por código ainda não implementada.");
                    break;
                case 4:
                    //  Implementar consulta por xxx
                    System.out.println("Consulta por xxx ainda não implementada.");
                    break;
                case 5:
                    //  Implementar alteração de camiseta
                    System.out.println("Alteração de camiseta ainda não implementada.");
                    break;
                case 6:
                    //  Implementar exclusão de camiseta
                    System.out.println("Exclusão de camiseta ainda não implementada.");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
