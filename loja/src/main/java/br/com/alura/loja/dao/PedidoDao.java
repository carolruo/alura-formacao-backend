package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.vo.RelatorioDeVendasVo;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class PedidoDao {

    private EntityManager em;

    public PedidoDao(EntityManager em) {

        this.em = em;
    }

    public void cadastrar(Pedido pedido) {

        this.em.persist(pedido);
    }

    public BigDecimal valorTotalVendido() {
        String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p"; //consulta
        return em.createQuery(jpql, BigDecimal.class)
                .getSingleResult();
    }

    //SELECT new: criar instancia da classe de relatorio que nao é uma entidade
    public List<RelatorioDeVendasVo> relatorioDeVendas() {
        String jpql = "SELECT new br.com.alura.loja.vo.RelatorioDeVendasVo(produto.nome, SUM(prodPedido.quantidade), MAX(pedido.data)) "
                + "FROM Pedido pedido JOIN pedido.produtos prodPedido JOIN prodPedido.produto produto "
                + "GROUP BY produto.nome "
                + "ORDER BY prodPedido.quantidade DESC";
        return em.createQuery(jpql, RelatorioDeVendasVo.class)
        .getResultList();
    }
}
