package ecossistema.plantas;

public class Arbusto extends Planta {
    public Arbusto(String nome, String tipo) {
        super(nome, tipo);
    }

    @Override
    public void crescer() {
        System.out.println(nome + " está crescendo como um arbusto.");
    }

    @Override
    public void reproduzir() {
        System.out.println(nome + " está se reproduzindo como um arbusto.");
    }
}
