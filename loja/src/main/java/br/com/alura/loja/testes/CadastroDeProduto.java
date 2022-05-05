package br.com.alura.loja.testes;

import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class CadastroDeProduto {
    public static void main(String[] args) {
//        Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), Categoria.CELULARES);

        //classe que implementa interface EntityManager
        //criar com o nome do persistence-unit que consta no persistence.xml
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja");
        //interface que faz a ponte do java com o banco de dados
        EntityManager em = factory.createEntityManager();
        //disparar o insert no banco de dados local
        em.getTransaction().begin();
//        em.persist(celular);
        //commitar a transacao no banco de dados
        em.getTransaction().commit();
        em.close();
    }
}
