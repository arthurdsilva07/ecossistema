package ecossistema.animais;

public abstract class Animal {
    protected String nome;
    protected int idade;

    public Animal(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void mover() {
        System.out.println(nome + " está se movendo.");
    }

    public abstract void acaoEspecial();

    public void comer(Animal animal) {
        System.out.println(nome + " está comendo " + animal.nome + ".");
    }
}
