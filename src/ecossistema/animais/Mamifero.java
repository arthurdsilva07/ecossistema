package ecossistema.animais;

public abstract class Mamifero extends Animal {
    public Mamifero(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public abstract void mover();

    @Override
    public abstract void comer(Animal presa);
}
