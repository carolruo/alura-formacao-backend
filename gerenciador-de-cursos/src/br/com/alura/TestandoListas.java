package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;
//Conhecendo  alguns metodos de array e Collections.sort()
public class TestandoListas {
    public static void main(String[] args) {
        String aula1 = "Conhecendo mais de listas";
        String aula2 = "Modelando a classe Aula";
        String aula3 = "Trabalhando com Cursos de Sets";

        ArrayList<String> aulas = new ArrayList<>();
        aulas.add(aula1);
        aulas.add(aula2);
        aulas.add(aula3);

        aulas.remove(0);

        for (String aula: aulas) {
            System.out.println(aula);
        }

        System.out.println("Primeira aula: " + aulas.get(0));

        for (int i = 0; i < aulas.size(); i++) {
            System.out.println("aula: " + aulas.get(i));
        }

        aulas.forEach(aula -> {
            System.out.println("percorrendo: " + aula);
        });

        aulas.add("Aumentando o conhecimento");
        System.out.println(aulas);
        Collections.sort(aulas);
        System.out.println(aulas);
    }
}
