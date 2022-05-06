package lambdas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class OrdenarListaOrdemAlfabetica {

    public static void main(String[] args) {

        List<String> listaPalavras = new ArrayList<>();

        listaPalavras.add("ferro");
        listaPalavras.add("fogo");
        listaPalavras.add("flamengo");

        listaPalavras.sort(Comparator.naturalOrder()); //(String s1, String s2) -> s1.compareTo(s2)

        listaPalavras.forEach(System.out::println); //s -> System.out.println(s)

        new Thread(() -> System.out.println("Executando uma Runnable")).start();

    }


}
