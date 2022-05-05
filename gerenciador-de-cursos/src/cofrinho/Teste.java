package cofrinho;

public class Teste {
    public static void main(String[] args) {
        Cofrinho cofre = new Cofrinho();
        cofre.adicionar(new Moeda(1.0, "real"));
        cofre.adicionar(new Moeda(1.0, "real"));
        cofre.adicionar(new Moeda(1.0, "real"));
        cofre.adicionar(new Moeda(3.3, "dolar"));

        cofre.contarMoedasValor(1.0);
    }
}
