/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cofares.controle;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import net.cofares.controle.exceptions.NonexistentEntityException;
import net.cofares.controle.exceptions.PreexistingEntityException;
import net.cofares.trucdanssalle.Truc;

/**
 *
 * @author pascalfares
 */
public class TrucJpaController implements Serializable {

    public TrucJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Truc truc) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(truc);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTruc(truc.getIdTRUC()) != null) {
                throw new PreexistingEntityException("Truc " + truc + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Truc truc) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            truc = em.merge(truc);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = truc.getIdTRUC();
                if (findTruc(id) == null) {
                    throw new NonexistentEntityException("The truc with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Truc truc;
            try {
                truc = em.getReference(Truc.class, id);
                truc.getIdTRUC();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The truc with id " + id + " no longer exists.", enfe);
            }
            em.remove(truc);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Truc> findTrucEntities() {
        return findTrucEntities(true, -1, -1);
    }

    public List<Truc> findTrucEntities(int maxResults, int firstResult) {
        return findTrucEntities(false, maxResults, firstResult);
    }

    private List<Truc> findTrucEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Truc.class));
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

    public Truc findTruc(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Truc.class, id);
        } finally {
            em.close();
        }
    }

    public int getTrucCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Truc> rt = cq.from(Truc.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
