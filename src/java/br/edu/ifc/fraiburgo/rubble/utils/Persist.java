package br.edu.ifc.fraiburgo.rubble.utils;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class Persist<T> {

    protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("RubbleWebServerPU");
    protected EntityManager em = emf.createEntityManager();

    public Object inserirObjeto(Object objeto) {
        em.getTransaction().begin();
        Object o = em.merge(objeto);
        em.flush();
        em.getTransaction().commit();
        return o;
    }

    public void removerObjeto(T objeto) {
        em.getTransaction().begin();
        em.remove(objeto);
        em.flush();
        em.getTransaction().commit();
        em.close();
    }

    public List<T> consultarObjetos(Class<T> classe) {
        List<T> t;
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery query = cb.createQuery();
        Root<T> from = query.from(classe);
        query.select(from);
        return em.createQuery(query).getResultList();
    }

    public T getObjetoById(Object id, Class classe) {
        T o;
        em.getTransaction().begin();
        o = (T) em.find(classe, id);
        em.flush();
        em.getTransaction().commit();
        em.close();
        return o;
    }

}