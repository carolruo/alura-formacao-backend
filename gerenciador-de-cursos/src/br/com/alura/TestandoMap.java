package br.com.alura;

import java.security.KeyStore;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestandoMap {

    public static void main(String[] args) {

        Map<Integer, String> pessoas = new HashMap<>();
//key, value
        pessoas.put(21, "Leonardo Cordeiro");
        pessoas.put(27, "Fabio Pimentel");
        pessoas.put(19, "Silvio Mattos");
        pessoas.put(23, "Romulo Henrique");

        pessoas.keySet().forEach(idade -> {
            System.out.println(pessoas.get(idade));
            System.out.println(idade);
        });

        System.out.println("-----------------------------");

        Map<String, Integer> nomesParaIdade = new HashMap<>();
        nomesParaIdade.put("Paulo", 31);
        nomesParaIdade.put("Adriano", 25);
        nomesParaIdade.put("Alberto", 33);
        nomesParaIdade.put("Guilherme", 26);

        //acessando as keys:
        Set<String> chaves = nomesParaIdade.keySet(); //criar um conjunto para guardar as chaves para serem iteradas
        for (String nome : chaves) {                  //iterar sobre o conjunto de chaves
            System.out.println(nome);
        }

        //acessando os valores de cada key
        Collection<Integer> valores = nomesParaIdade.values();//criar um collection guardar os valores das keys
        for (Integer idade : valores) {                       //iterar sobre o collection para mostrar os valores
            System.out.println(idade);
        }

        Set<Map.Entry<String, Integer>> associacoes = nomesParaIdade.entrySet();//cada associação é representado através da classe Entry
        for (Map.Entry<String, Integer> associacao : associacoes) {
            System.out.println(associacao.getKey() + " - " + associacao.getValue());
        }
    }
}
