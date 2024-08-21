package enums;


  //Aqui são as camisetas disponíveis ate o momento em nossa loja

public enum CamisetaEnum {
    FLAMENGO("Flamengo"),
    PALMEIRAS("Palmeiras"),
    SAO_PAULO("São Paulo"),
    VASCO("Vasco"),
    CORINTHIANS("Corinthians");

    private String nome;

    CamisetaEnum(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
