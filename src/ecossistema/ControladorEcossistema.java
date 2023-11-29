package ecossistema;

import ecossistema.animais.*;
import ecossistema.ambiente.*;

import java.util.Random;

public class ControladorEcossistema {
    public void iniciarSimulacao() {
        Animal lobo = new Lobo("Lobo Cinzento", 5);
        Animal coelho = new Coelho("Coelho Branco", 2);
        Animal aguia = new Aguia("Águia Real", 8);
        Animal cobra = new Cobra("Cobra Venenosa", 4);

        int dias = 2; // Número de dias da simulação
        Random random = new Random();

        Ambiente ambiente = new Sol(); // Comece com um ambiente padrão

        System.out.println("Simulação do ecossistema iniciada.");

        for (int dia = 1; dia <= dias; dia++) {
            System.out.println("Dia " + dia);

            // Simule eventos naturais aleatórios
            int eventoAleatorio = random.nextInt(3); // 0, 1 ou 2
            switch (eventoAleatorio) {
                case 0:
                    ambiente = new Sol();
                    break;
                case 1:
                    ambiente = new Chuva();
                    break;
                case 2:
                    ambiente = new Tempestade();
                    break;
            }

            // Ações dos animais
            lobo.mover();
            coelho.mover();

            // Comportamento dos animais pode variar
            lobo.comer(coelho);
            lobo.acaoEspecial(); // Ação especial do Lobo

            coelho.acaoEspecial(); // Ação especial do Coelho

            aguia.mover();
            cobra.mover();

            if (random.nextBoolean()) {
                aguia.comer(cobra);
            } else {
                cobra.acaoEspecial(); // Ação especial da Cobra
            }

            aguia.acaoEspecial(); // Ação especial da Águia

            System.out.println("Eventos naturais: " + ambiente.getClass().getSimpleName());
        }

        System.out.println("Simulação do ecossistema concluída após " + dias + " dias.");
    }

    public static void main(String[] args) {
        ControladorEcossistema simulacao = new ControladorEcossistema();
        simulacao.iniciarSimulacao();
    }
}
