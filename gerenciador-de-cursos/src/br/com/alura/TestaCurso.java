package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestaCurso {
    public static void main(String[] args) {
        Curso javaColecoes = new Curso("Dominando as colecoes Java", "Paulo Silveira");

        javaColecoes.adiciona(new Aula("bla bla2", 15));
        javaColecoes.adiciona(new Aula("ab bla2", 16));

        System.out.println(javaColecoes.getAulas());

        List<Aula> aulasOrdemAlfa = new ArrayList<>(javaColecoes.getAulas());

        Collections.sort(aulasOrdemAlfa);
        System.out.println(aulasOrdemAlfa);

        System.out.println("Tempo total do curso: " + javaColecoes.getTempoTotal());



        //Mostrando que referencia o mesmo objeto:
//        List<Aula> aulas = javaColecoes.getAulas();
//        aulas.add(new Aula("Trabalhando com ArrayList", 21));
//        System.out.println(aulas == javaColecoes.getAulas());
    }
}
