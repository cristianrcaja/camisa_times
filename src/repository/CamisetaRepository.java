package repository;

import models.Camiseta;

import java.util.List;
import java.util.Optional;

public interface CamisetaRepository {
    void cadastrar(Camiseta camiseta);
    List<Camiseta> listar();
    Optional<Camiseta> consultarPorCodigo(int codigo);
    void alterar(Camiseta camiseta);
    boolean excluir(int codigo);
}
