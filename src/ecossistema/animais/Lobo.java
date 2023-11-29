package ecossistema.animais;

public class Lobo extends Mamifero {
    public Lobo(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public void mover() {
        System.out.println(nome + " está se movendo.");
    }

    @Override
    public void comer(Animal presa) {
        System.out.println(nome + " está caçando " + presa.nome + ".");
    }

    @Override
    public void acaoEspecial() {
        System.out.println(nome + " está uivando para marcar seu território.");
    }
    
}
