package ecossistema.plantas;

public abstract class Planta {
    protected String nome;
    protected String tipo;

    public Planta(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public abstract void crescer();

    public abstract void reproduzir();
}
