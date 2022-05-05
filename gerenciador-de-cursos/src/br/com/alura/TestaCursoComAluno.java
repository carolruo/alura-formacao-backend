package br.com.alura;

public class TestaCursoComAluno {
    public static void main(String[] args) {
        Curso javaColecoes = new Curso("Dominando as colecoes Java", "Paulo Silveira");

        javaColecoes.adiciona(new Aula("ArrayLists", 15));
        javaColecoes.adiciona(new Aula("Criando a classe Aula", 16));
        javaColecoes.adiciona(new Aula("Modelando Collection", 26));

        Aluno a1 = new Aluno("Rodrigo", 346);
        Aluno a2 = new Aluno("Guilherme", 347);
        Aluno a3 = new Aluno("Mauricio", 345);

        javaColecoes.matricula(a1);
        javaColecoes.matricula(a2);
        javaColecoes.matricula(a3);

        System.out.println("Alunos matriculados: ");
        javaColecoes.getAlunos().forEach(luno -> System.out.println(luno));

        System.out.println(javaColecoes.estaMatriculado(a1));
        System.out.println(javaColecoes.buscaMatriculado(346));
    }
}
