package models;

import enums.CamisetaEnum;

public class Camiseta {
    private int codigo;
    private CamisetaEnum modelo;
    private double preco;

    public Camiseta(int codigo, CamisetaEnum modelo, double preco) {
        this.codigo = codigo;
        this.modelo = modelo;
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public CamisetaEnum getModelo() {
        return modelo;
    }

    public void setModelo(CamisetaEnum modelo) {
        this.modelo = modelo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Camiseta{" +
                "codigo=" + codigo +
                ", modelo=" + modelo.getNome() +
                ", preco=" + preco +
                '}';
    }
}
