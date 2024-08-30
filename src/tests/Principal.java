package tests;

import models.Camiseta;
import repository.CamisetaRepository;
import repository.CamisetaRepositoryImpl;
import enums.CamisetaEnum;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Principal {
    private static int codigoSequencial = 1;

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        CamisetaRepositoryImpl repository = new CamisetaRepositoryImpl(); // Usando a implementação específica
        Random random = new Random();

        while (true) {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("Escolha uma das opções abaixo:");
            System.out.println("0 - Sair");
            System.out.println("1 - Cadastrar nova camiseta");
            System.out.println("2 - Listar todas as camisetas");
            System.out.println("3 - Consultar camiseta por código");
            System.out.println("4 - Buscar camisetas por preço máximo");
            System.out.println("5 - Buscar camisetas por modelo");
            System.out.println("6 - Comparar camisetas em promoção");
            System.out.println("7 - Alterar uma camiseta");
            System.out.println("8 - Excluir uma camiseta");
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
                    System.out.print("Digite o preço máximo: ");
                    double precoMaximo = leitor.nextDouble();
                    repository.buscarCamisetasAbaixoDePreco(precoMaximo);
                    break;
                case 5:
                    System.out.println("Escolha o modelo da camiseta:");
                    for (CamisetaEnum mod : CamisetaEnum.values()) {
                        System.out.println(mod.ordinal() + " - " + mod.getNome());
                    }
                    System.out.print("Digite o número do modelo escolhido: ");
                    int modEscolhido = leitor.nextInt();
                    CamisetaEnum mod = CamisetaEnum.values()[modEscolhido];
                    List<Camiseta> resultado = repository.buscarCamisetasPorModelo(mod);
                    resultado.forEach(camiseta -> {
                        System.out.println("Código: " + camiseta.getCodigo());
                        System.out.println("Modelo: " + camiseta.getModelo().getNome());
                        System.out.println("Preço: R$ " + String.format("%.2f", camiseta.getPreco()));
                        System.out.println("------------------------------");
                    });
                    break;
                case 6:
                    // Simulação de listas para a comparação
                    List<Camiseta> camisetasPromocao = List.of(
                            new Camiseta(999, CamisetaEnum.CLASSICA, 50.00),
                            new Camiseta(1000, CamisetaEnum.POLO, 60.00)
                    );

                    System.out.println("\n--- Comparando camisetas em promoção com as cadastradas ---");
                    List<Camiseta> comparacao = repository.compararComPromocao(camisetasPromocao);
                    comparacao.forEach(camiseta -> {
                        System.out.println("Código: " + camiseta.getCodigo());
                        System.out.println("Modelo: " + camiseta.getModelo().getNome());
                        System.out.println("Preço: R$ " + String.format("%.2f", camiseta.getPreco()));
                        System.out.println("------------------------------");
                    });
                    break;
                case 7:
                    System.out.print("Digite o código da camiseta que deseja alterar: ");
                    int codAlterar = leitor.nextInt();
                    repository.consultarPorCodigo(codAlterar).ifPresentOrElse(
                            camiseta -> {
                                System.out.println("Camiseta encontrada. Informe o novo modelo.");
                                System.out.println("Escolha o novo modelo da camiseta:");
                                for (CamisetaEnum modeloOpcao : CamisetaEnum.values()) {
                                    System.out.println(modeloOpcao.ordinal() + " - " + modeloOpcao.getNome());
                                }
                                System.out.print("Digite o número do novo modelo escolhido: ");
                                int modeloSelecionado = leitor.nextInt();
                                CamisetaEnum novoModelo = CamisetaEnum.values()[modeloSelecionado];

                                // Atualiza apenas o modelo da camiseta
                                camiseta.setModelo(novoModelo);

                                repository.alterar(camiseta);
                                System.out.println("Modelo da camiseta alterado com sucesso!");
                            },
                            () -> System.out.println("Camiseta com o código informado não foi encontrada.")
                    );
                    break;
                case 8:
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
