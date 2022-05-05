package br.com.alura.loja.testes;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CadastroDeProdutoMelhorado {
    public static void main(String[] args) {
        //precisa ter uma categoria cadastrada no banco de dados pra associar a um produto:
        cadastrarProduto();

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);

        produtoDao.buscaPrecoPorId(2l);

        BigDecimal preco = produtoDao.buscarPrecoPorNome("Samsung Galaxy");
        System.out.println("BUSCA PRECO POR NOME: " + preco);

        List<Produto> todos = produtoDao.buscarTodos();
        todos.forEach(prod -> System.out.println(prod.toString()));

        System.out.println("----------------");
        List<Produto> todosCat = produtoDao.buscarPorNomeDaCategoria("CELULARES");
        todosCat.forEach(prod -> System.out.println(prod.getNome()));

    }

    private static void cadastrarProduto() {
        Categoria celulares = new Categoria("CELULARES");
        Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares);

        Categoria livros = new Categoria("LIVROS");
        Produto livro = new Produto("1984", "Livro de George Orwell", new BigDecimal("100"), livros);

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        //disparar o insert no banco de dados local
        em.getTransaction().begin();
        categoriaDao.cadastrar(celulares); //salvando categoria no banco de dados
        produtoDao.cadastrar(celular); //salvando produto associado a categoria ao banco de dados

        celular.setNome("Samsung Galaxy");
        em.clear();
        celular = em.merge(celular);
        celular.setDescricao("Celular última geração");
        em.flush();
//        em.remove(celular);

        categoriaDao.cadastrar(livros);
        produtoDao.cadastrar(livro);

        //commitar toda a transacao no banco de dados
        em.getTransaction().commit();
        em.close();
    }
}
