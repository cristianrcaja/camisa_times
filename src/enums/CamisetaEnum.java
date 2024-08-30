package enums;

// Aqui são as camisetas disponíveis até o momento em nossa loja
public enum CamisetaEnum {
    FLAMENGO("Flamengo"),
    PALMEIRAS("Palmeiras"),
    SAO_PAULO("São Paulo"),
    VASCO("Vasco"),
    CORINTHIANS("Corinthians"),
    BÁSICA("Básica"),
    ESTAMPADA("Estampada"),
    PERSONALIZADA("Personalizada"),
    RETRÔ("Retrô"),
    CLASSICA("Clássica"),
    POLO("Polo");

    private String nome;

    CamisetaEnum(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
