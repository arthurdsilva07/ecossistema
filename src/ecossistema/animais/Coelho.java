package ecossistema.animais;

public class Coelho extends Mamifero {
    public Coelho(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public void mover() {
        System.out.println(nome + " está pulando.");
    }

    @Override
    public void comer(Animal presa) {
        System.out.println(nome + " está comendo grama.");
    }

    @Override
    public void acaoEspecial() {
        fugir();
    }

    private void fugir() {
        System.out.println(nome + " está fugindo para escapar do predador.");
    }
}
