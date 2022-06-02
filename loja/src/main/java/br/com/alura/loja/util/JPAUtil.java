package br.com.alura.loja.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//essa classe tem o objetivo de isolar a criacao do entity manager e do entity manager factory
public class JPAUtil {

    //garantir que a factory é criada apenas uma vez, nao precisa criar de novo
    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("loja");

    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }
}
