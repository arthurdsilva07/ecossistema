import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

class EcossistemaFloresta {
    public static void main(String[] args) {
        Floresta floresta = new Floresta();
        floresta.simularCicloDiurno(20); // Simule o ciclo diurno por 20 dias
    }
}

class SerVivo {
    protected String nome;
    protected int idade;
    protected boolean vivo;

    public SerVivo(String nome) {
        this.nome = nome;
        this.idade = 0;
        this.vivo = true;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public boolean estaVivo() {
        return vivo;
    }

    public void envelhecer() {
        idade++;
        if (idade > 10) {
            vivo = false;
        }
    }

    public void mover() {
        // Não faz nada para plantas
    }
}

class Planta extends SerVivo {
    public Planta(String nome) {
        super(nome);
    }

    public void crescer() {
        System.out.println(getNome() + " está crescendo.");
    }
}

class Animal extends SerVivo {
    private char sexo;

    public Animal(String nome, char sexo) {
        super(nome);
        this.sexo = sexo;
    }

    public char getSexo() {
        return sexo;
    }

    public void comer() {
        System.out.println(getNome() + " está se alimentando.");
    }

    public void reproduzir(Animal parceiro) {
        if (getIdade() > 1 && parceiro.getIdade() > 1 && this.getSexo() != parceiro.getSexo() && this.getClass() == parceiro.getClass()) {
            System.out.println(getNome() + " e " + parceiro.getNome() + " estão se reproduzindo.");
        }
    }
}

class Mamifero extends Animal {
    public Mamifero(String nome, char sexo) {
        super(nome, sexo);
    }
}

class Lobo extends Mamifero {
    public Lobo(String nome, char sexo) {
        super(nome, sexo);
    }
}

class Coelho extends Mamifero {
    public Coelho(String nome, char sexo) {
        super(nome, sexo);
    }
}

class Urso extends Mamifero {
    public Urso(String nome, char sexo) {
        super(nome, sexo);
    }
}

class Veado extends Mamifero {
        public Veado(String nome, char sexo) {
            super(nome, sexo);
        }
    }

class Aves extends Animal {
        public Aves(String nome, char sexo) {
            super(nome, sexo);
        }
    }

class Pato extends Aves {
        public Pato(String nome, char sexo) {
            super(nome, sexo);
        }
    }

class Aguia extends Aves {
        public Aguia(String nome, char sexo) {
            super(nome, sexo);
        }
    }

class Arvore extends Planta {
        public Arvore(String nome) {
            super(nome);
        }

        @Override
        public void mover() {
            // Não faz nada, já que plantas não se movem
        }
    }

class Arbusto extends Planta {
        public Arbusto(String nome) {
            super(nome);
        }

        @Override
        public void mover() {
            // Não faz nada, já que plantas não se movem
        }
    }

class Clima {
        private String descricao;

        public Clima(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }

class Floresta {
        private ArrayList<SerVivo> seresVivos;
        private Clima clima;

        public Floresta() {
            seresVivos = new ArrayList<>();
            seresVivos.add(new Lobo("Lobo Macho", 'M'));
            seresVivos.add(new Lobo("Loba Fêmea", 'F'));
            seresVivos.add(new Coelho("Coelho Macho", 'M'));
            seresVivos.add(new Coelho("Coelha Fêmea", 'F'));
            seresVivos.add(new Urso("Urso Macho", 'M'));
            seresVivos.add(new Urso("Urso Fêmea", 'F'));
            seresVivos.add(new Veado("Veado Macho", 'M'));
            seresVivos.add(new Veado("Veado Fêmea", 'F'));
            seresVivos.add(new Pato("Pato Macho", 'M'));
            seresVivos.add(new Pato("Pato Fêmea", 'F'));
            seresVivos.add(new Aguia("Águia Macho", 'M'));
            seresVivos.add(new Aguia("Águia Fêmea", 'F'));
            seresVivos.add(new Arvore("Carvalho"));
            seresVivos.add(new Arbusto("Espinheiro"));
            clima = new Clima("Ensolarado");
        }

        public void simularCicloDiurno(int dias) {
            for (int dia = 1; dia <= dias; dia++) {
                System.out.println("Dia " + dia + " - Clima: " + clima.getDescricao());

                for (SerVivo serVivo : new ArrayList<>(seresVivos)) {
                    serVivo.mover();
                    serVivo.envelhecer();

                    if (serVivo instanceof Animal) {
                        Animal animal = (Animal) serVivo;
                        animal.comer();
                        if (!animal.estaVivo()) {
                            System.out.println(animal.getNome() + " morreu.");
                            seresVivos.remove(animal);
                        } else if (animal.getIdade() > 1) {
                            for (SerVivo parceiro : new ArrayList<>(seresVivos)) {
                                if (parceiro instanceof Animal && parceiro.estaVivo()) {
                                    Animal outroAnimal = (Animal) parceiro;
                                    animal.reproduzir(outroAnimal);
                                }
                            }
                        }
                    }

                    if (serVivo instanceof Planta) {
                        Planta planta = (Planta) serVivo;
                        planta.crescer();
                    }

                    System.out.println();
                }

                atualizarClima(); // Simulação de mudanças climáticas
                simularDesastresNaturais(); // Simulação de desastres naturais
            }
        }

        private void atualizarClima() {
            Random random = new Random();
            int chanceChuva = random.nextInt(100);
            if (chanceChuva < 20) {
                clima = new Clima("Chuvoso");
            } else {
                clima = new Clima("Ensolarado");
            }
        }

        private void simularDesastresNaturais() {
            Random random = new Random();
            int chanceDesastre = random.nextInt(100);
            if (chanceDesastre < 10) {
                System.out.println("Um incêndio devastador ocorreu na floresta!");
                simularMorteDeAnimais(30); // 30% dos animais morrem no incêndio
            } else if (chanceDesastre < 20) {
                System.out.println("Um terremoto abalou a floresta!");
                simularMorteDeAnimais(20); // 20% dos animais morrem no terremoto
            }
        }

        private void simularMorteDeAnimais(int porcentagemMorte) {
            Random random = new Random();
            Iterator<SerVivo> iterator = seresVivos.iterator();

            while (iterator.hasNext()) {
                SerVivo serVivo = iterator.next();
                if (serVivo instanceof Animal) {
                    if (random.nextInt(100) < porcentagemMorte) {
                        System.out.println(serVivo.getNome() + " morreu devido ao desastre.");
                        iterator.remove();
                    }
                }
            }
        }
}
                                            
        
    
        
        

        