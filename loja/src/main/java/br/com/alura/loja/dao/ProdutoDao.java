package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Produto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProdutoDao {

    private EntityManager em;

    public ProdutoDao(EntityManager em) {

        this.em = em;
    }

    public void cadastrar(Produto produto) {

        this.em.persist(produto);
    }

    public void buscaPrecoPorId(Long id) {
       System.out.println("O preço do produto é: " + em.find(Produto.class, id).getPreco());
    }

    public BigDecimal buscarPrecoPorNome(String nome) {
        String jpql = "SELECT p.preco FROM Produto p WHERE p.nome = :nome";
        return em.createQuery(jpql, BigDecimal.class)
                .setParameter("nome", nome)
                .getSingleResult();
    }

    public Produto buscarProdutoPorId(Long id) {
        return em.find(Produto.class, id);
    }

    public List<Produto> buscarTodos() {
        String jpql = "SELECT p FROM Produto p"; //Produto AS p (o objeto inteiro)
        //O createQuery não dispara a query no banco de dados, apenas monta a query, para disparar, chamamos o getResultList
        return em.createQuery(jpql, Produto.class)
                .getResultList();
    }

    public List<Produto> buscarPorNome(String nome) {
        String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";
        return em.createQuery(jpql, Produto.class)
                .setParameter("nome", nome)
                .getResultList();
    }

    public List<Produto> buscarPorNomeDaCategoria(String nome) {
        String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = :nome";
        return em.createQuery(jpql, Produto.class)
                .setParameter("nome", nome)
                .getResultList();
    }

}
