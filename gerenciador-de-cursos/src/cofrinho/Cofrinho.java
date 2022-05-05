package cofrinho;

import java.util.ArrayList;
import java.util.List;

public class Cofrinho {
    private List<Moeda> moedas = new ArrayList<Moeda>();

    public List<Moeda> getMoedas() {
        return moedas;
    }

    public void adicionar(Moeda moeda) {
        this.moedas.add(moeda);
    }

    public void contarMoedasValor(double valor) {
        int totalMoedas = 0;
        for (Moeda moeda : moedas) {
            if (moeda.getValor() == valor) {
                totalMoedas++;
            }
        }
        System.out.println("quantidade de moedas de " + valor + ": " + totalMoedas);
    }
}

