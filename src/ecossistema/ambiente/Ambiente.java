package ecossistema.ambiente;

public class Ambiente {
    private String clima;

    public Ambiente(String clima) {
        this.clima = clima;
    }

    public void ocorrerEventoClimatico() {
        System.out.println("Evento climático de " + clima + " ocorreu.");
    }
}
