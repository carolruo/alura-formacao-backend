package streams;

import java.util.*;
import java.util.stream.Collectors;

public class TesteCursos {
    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<>();

        cursos.add(new Curso("Java", 145));
        cursos.add(new Curso("Phyton", 100));
        cursos.add(new Curso("JavaScript", 113));
        cursos.add(new Curso("C", 95));

        cursos.sort(Comparator.comparing(Curso::getAlunos).reversed()); //reversed: pegar por ordem decrescente
        cursos.forEach(c -> System.out.println(c.getNome()));
        System.out.println("------------------------------------------");

        //toda collection agora tem um método que se chama stream que devolve um fluxo Stream de objetos
        //Tudo que é feito no Stream nao impacta a lista original
        //.parallelStream()
        cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .forEach(c -> System.out.println(c.getNome()));

        boolean a = cursos.stream()
                .allMatch(c -> c.getAlunos() > 0);

        System.out.println("todos os cursos tem mais q 0 alunos? " + a);

        System.out.println("------------------------------------------");

        cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .map(Curso::getAlunos)
                .forEach(System.out::println);

        System.out.println("------------------------------------------");

        int soma = cursos.stream()
                .filter(c -> c.getAlunos() >=100)
                .mapToInt(Curso::getAlunos)
                .sum(); //.average (vai retornar um OptionalDouble)
        System.out.println("Alunos total: " + soma);

        System.out.println("------------------------------------------");

        cursos.stream()
                .filter(c -> c.getAlunos() >= 120) //retorna Stream
                .findAny() //retorna um Optional
                .ifPresent(c -> System.out.println(c.getNome()));

        System.out.println("------------------------------------------");

        //voltar de Stream para uma Collection através do collect
        List<Curso> cursosSelecionados = cursos.stream()
                .filter(c -> c.getAlunos() >= 120)
                .collect(Collectors.toList());

        System.out.println("------------------------------------------");

        //Stream para Map<String, Integer> (especificar chave e valor!) e recebe biConsumer no foreach
        cursos.stream()
                .filter(c -> c.getAlunos() > 100)
                .collect(Collectors.toMap(Curso::getNome, Curso::getAlunos))
                .forEach((curso, alunos) -> System.out.println(curso + " tem " + alunos + " alunos."));

    }
}
