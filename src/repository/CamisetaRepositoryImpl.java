package repository;

import models.Camiseta;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        consultarPorCodigo(camiseta.getCodigo()).ifPresent(c -> {
            c = camiseta;
        });
    }

    @Override
    public boolean excluir(int codigo) {
        return camisetas.removeIf(camiseta -> camiseta.getCodigo() == codigo);
    }
}
