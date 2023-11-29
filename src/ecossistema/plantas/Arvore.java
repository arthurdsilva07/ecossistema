package ecossistema.plantas;

public class Arvore extends Planta {
    public Arvore(String nome, String tipo) {
        super(nome, tipo);
    }

    @Override
    public void crescer() {
        System.out.println(nome + " está crescendo como uma árvore.");
    }

    @Override
    public void reproduzir() {
        System.out.println(nome + " está se reproduzindo como uma árvore.");
    }
}