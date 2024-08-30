package repository;

import models.Camiseta;
import enums.CamisetaEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CamisetaRepositoryImpl implements CamisetaRepository {
    private List<Camiseta> camisetas = new ArrayList<>();

    @Override
    public void cadastrar(Camiseta camiseta) {
        camisetas.add(camiseta);
    }

    @Override
    public List<Camiseta> listar() {
        return camisetas;
    }

    @Override
    public Optional<Camiseta> consultarPorCodigo(int codigo) {
        return camisetas.stream()
                .filter(camiseta -> camiseta.getCodigo() == codigo)
                .findFirst();
    }

    @Override
    public void alterar(Camiseta camiseta) {
        Optional<Camiseta> camisetaExistente = consultarPorCodigo(camiseta.getCodigo());
        camisetaExistente.ifPresent(c -> {
            c.setModelo(camiseta.getModelo());
        });
    }



    @Override
    public boolean excluir(int codigo) {
        return camisetas.removeIf(camiseta -> camiseta.getCodigo() == codigo);
    }

    @Override
    public void buscarCamisetasAbaixoDePreco(double precoMaximo) {
        camisetas.stream()
                .filter(camiseta -> camiseta.getPreco() <= precoMaximo)
                .forEach(camiseta -> {
                    System.out.println("Código: " + camiseta.getCodigo());
                    System.out.println("Modelo: " + camiseta.getModelo().getNome());
                    System.out.println("Preço: R$ " + String.format("%.2f", camiseta.getPreco()));
                    System.out.println("------------------------------");
                });
    }

    @Override
    public List<Camiseta> buscarCamisetasPorModelo(CamisetaEnum modelo) {
        return camisetas.stream()
                .filter(camiseta -> camiseta.getModelo() == modelo)
                .collect(Collectors.toList());
    }

    @Override
    public List<Camiseta> compararComPromocao(List<Camiseta> camisetasEmPromocao) {
        return camisetas.stream()
                .filter(camisetasEmPromocao::contains)
                .collect(Collectors.toList());
    }
}
