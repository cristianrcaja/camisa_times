package tests;

import models.Camiseta;
import repository.CamisetaRepository;
import repository.CamisetaRepositoryImpl;
import enums.CamisetaEnum;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;
import java.util.Scanner;

public class Principal{
    private static int codigoSequencial = 1;

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        CamisetaRepository repository = new CamisetaRepositoryImpl();
        Random random = new Random();

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
                    System.out.println("Escolha o modelo da camiseta:");
                    for (CamisetaEnum modelo : CamisetaEnum.values()) {
                        System.out.println(modelo.ordinal() + " - " + modelo.getNome());
                    }
                    System.out.print("Digite o número do modelo escolhido: ");
                    int modeloEscolhido = leitor.nextInt();
                    CamisetaEnum modelo = CamisetaEnum.values()[modeloEscolhido];


                    double precoGerado = 200 + (100 * random.nextDouble());

                    BigDecimal preco = new BigDecimal(precoGerado).setScale(2, RoundingMode.HALF_UP);


                    int codigo = codigoSequencial++;
                    repository.cadastrar(new Camiseta(codigo, modelo, preco.doubleValue()));

                    System.out.println("\n--- Camiseta Cadastrada ---");
                    System.out.println("Código: " + codigo);
                    System.out.println("Modelo: " + modelo.getNome());
                    System.out.println("Preço: R$ " + String.format("%.2f", preco.doubleValue()));
                    break;
                case 2:
                    System.out.println("\n--- Lista de Camisetas ---");
                    repository.listar().forEach(camiseta -> {
                        System.out.println("Código: " + camiseta.getCodigo());
                        System.out.println("Modelo: " + camiseta.getModelo().getNome());
                        System.out.println("Preço: R$ " + String.format("%.2f", camiseta.getPreco()));
                        System.out.println("------------------------------");
                    });
                    System.out.println("\nDeseja voltar ao menu principal? (Digite 'S' para sim ou qualquer outra tecla para sair)");
                    String resposta = leitor.next();
                    if (!resposta.equalsIgnoreCase("S")) {
                        System.out.println("Programa encerrado. Até mais!");
                        System.exit(0);
                    }
                    break;
                case 3:
                    System.out.print("Digite o código da camiseta que deseja consultar: ");
                    int codConsulta = leitor.nextInt();
                    repository.consultarPorCodigo(codConsulta)
                            .ifPresentOrElse(
                                    camiseta -> {
                                        System.out.println("\n--- Detalhes da Camiseta ---");
                                        System.out.println("Código: " + camiseta.getCodigo());
                                        System.out.println("Modelo: " + camiseta.getModelo().getNome());
                                        System.out.println("Preço: R$ " + String.format("%.2f", camiseta.getPreco()));
                                    },
                                    () -> System.out.println("Camiseta com o código informado não foi encontrada."));
                    break;
                case 4:

                    System.out.println("Essa funcionalidade ainda não está disponível. Aguarde novidades!");
                    break;
                case 5:
                    // Implementar alteração
                    System.out.println("Funcionalidade de alteração ainda não implementada.");
                    break;
                case 6:
                    System.out.print("Digite o código da camiseta que deseja excluir: ");
                    int codExcluir = leitor.nextInt();
                    if (repository.excluir(codExcluir)) {
                        System.out.println("Camiseta excluída com sucesso!");
                    } else {
                        System.out.println("Camiseta com o código informado não foi encontrada.");
                    }
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
