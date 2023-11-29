package ecossistema.animais;

public abstract class Reptil extends Animal {
    public Reptil(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public void mover() {
        System.out.println(nome + " está rastejando.");
    }

    @Override
    public abstract void comer(Animal presa);
}
