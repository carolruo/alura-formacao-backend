package br.com.alura.loja.testes;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ClienteDao;
import br.com.alura.loja.dao.PedidoDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.*;
import br.com.alura.loja.util.JPAUtil;
import br.com.alura.loja.vo.RelatorioDeVendasVo;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CadastroDePedido {
    public static void main(String[] args) {
        popularBancoDeDados();
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        Produto produto = produtoDao.buscarProdutoPorId(1l);

        em.getTransaction().begin();

        ClienteDao clienteDao = new ClienteDao(em);
        Cliente cliente = clienteDao.buscarPorId(1l);

        Pedido pedido = new Pedido(cliente);
        pedido.addProduto(new ProdutoPedido(10, pedido, produto));

        PedidoDao pedidoDao = new PedidoDao(em);
        pedidoDao.cadastrar(pedido);

        em.getTransaction().commit();

        BigDecimal totalVendido = pedidoDao.valorTotalVendido();
        System.out.println("total vendido: " + totalVendido);

        List<RelatorioDeVendasVo> relatorio = pedidoDao.relatorioDeVendas();
        relatorio.forEach(System.out::println);


    }

    private static void popularBancoDeDados() {
        Categoria celulares = new Categoria("CELULARES");
        Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares);

        Categoria livros = new Categoria("LIVROS");
        Produto livro = new Produto("1984", "Livro de George Orwell", new BigDecimal("100"), livros);
        Cliente cliente = new Cliente("Carol", "123");

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);
        ClienteDao clienteDao = new ClienteDao(em);

        //disparar o insert no banco de dados local
        em.getTransaction().begin();
        categoriaDao.cadastrar(celulares); //salvando categoria no banco de dados
        produtoDao.cadastrar(celular); //salvando produto associado a categoria ao banco de dados
        clienteDao.cadastrar(cliente);

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
