package repository;

import models.Camiseta;
import enums.CamisetaEnum; // Certifique-se de importar o enum corretamente

import java.util.List;
import java.util.Optional;

public interface CamisetaRepository {
    void cadastrar(Camiseta camiseta);
    List<Camiseta> listar();
    Optional<Camiseta> consultarPorCodigo(int codigo);
    void alterar(Camiseta camiseta);
    boolean excluir(int codigo);

    void buscarCamisetasAbaixoDePreco(double precoMaximo);
    List<Camiseta> buscarCamisetasPorModelo(CamisetaEnum modelo);
    List<Camiseta> compararComPromocao(List<Camiseta> camisetasEmPromocao);
}
