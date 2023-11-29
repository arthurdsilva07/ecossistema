package ecossistema.animais;

public abstract class Ave extends Animal {
    public Ave(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public void mover() {
        System.out.println(nome + " está voando.");
    }

    @Override
    public abstract void comer(Animal presa);
}
