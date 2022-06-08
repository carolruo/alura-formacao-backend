package br.com.alura.loja.modelo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "produtos")
//Criando uma consulta dentro da entidade ao inves da classe Dao:
@NamedQuery(name = "Produto.produtosPorCategoria", query = "SELECT p FROM Produto p WHERE p.categoria.id.nome = :nome")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //Indicar herança e escolher a estrategia de armazenamento de tabelas
public class Produto {

    //indicar que o atributo abaixo é a chave primaria
    @Id
    //indicar que a primary key será gerada no banco, portanto aqui pode ficar nula
    // STRATEGY depende do banco de dados, o h2 usa IDENTITY
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private LocalDate dataCadastro = LocalDate.now();
    //cardinalidade de tabelas: de Categoria para Produto (Muitos produtos estao vinculados a 1 categoria)
    @ManyToOne
    private Categoria categoria;

    public Produto() {
    }

    public Produto(String nome, String descricao, BigDecimal preco, Categoria categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", dataCadastro=" + dataCadastro +
                ", " + categoria +
                '}';
    }
}
