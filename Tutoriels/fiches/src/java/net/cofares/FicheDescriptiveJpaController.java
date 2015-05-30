/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cofares;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import net.cofares.exceptions.NonexistentEntityException;

/**
 *
 * @author pascalfares
 */
public class FicheDescriptiveJpaController implements Serializable {

    public FicheDescriptiveJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(FicheDescriptive ficheDescriptive) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(ficheDescriptive);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(FicheDescriptive ficheDescriptive) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ficheDescriptive = em.merge(ficheDescriptive);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = ficheDescriptive.getIdFicheDescriptive();
                if (findFicheDescriptive(id) == null) {
                    throw new NonexistentEntityException("The ficheDescriptive with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            FicheDescriptive ficheDescriptive;
            try {
                ficheDescriptive = em.getReference(FicheDescriptive.class, id);
                ficheDescriptive.getIdFicheDescriptive();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ficheDescriptive with id " + id + " no longer exists.", enfe);
            }
            em.remove(ficheDescriptive);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<FicheDescriptive> findFicheDescriptiveEntities() {
        return findFicheDescriptiveEntities(true, -1, -1);
    }

    public List<FicheDescriptive> findFicheDescriptiveEntities(int maxResults, int firstResult) {
        return findFicheDescriptiveEntities(false, maxResults, firstResult);
    }

    private List<FicheDescriptive> findFicheDescriptiveEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(FicheDescriptive.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public FicheDescriptive findFicheDescriptive(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(FicheDescriptive.class, id);
        } finally {
            em.close();
        }
    }

    public int getFicheDescriptiveCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<FicheDescriptive> rt = cq.from(FicheDescriptive.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
