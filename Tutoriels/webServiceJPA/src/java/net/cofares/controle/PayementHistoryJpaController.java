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
import net.cofares.PayementHistory;
import net.cofares.Payementlog;
import net.cofares.controle.exceptions.NonexistentEntityException;

/**
 *
 * @author pascalfares
 */
public class PayementHistoryJpaController implements Serializable {

    public PayementHistoryJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PayementHistory payementHistory) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Payementlog payId = payementHistory.getPayId();
            if (payId != null) {
                payId = em.getReference(payId.getClass(), payId.getPayId());
                payementHistory.setPayId(payId);
            }
            em.persist(payementHistory);
            if (payId != null) {
                payId.getPayementHistoryList().add(payementHistory);
                payId = em.merge(payId);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PayementHistory payementHistory) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PayementHistory persistentPayementHistory = em.find(PayementHistory.class, payementHistory.getCommit());
            Payementlog payIdOld = persistentPayementHistory.getPayId();
            Payementlog payIdNew = payementHistory.getPayId();
            if (payIdNew != null) {
                payIdNew = em.getReference(payIdNew.getClass(), payIdNew.getPayId());
                payementHistory.setPayId(payIdNew);
            }
            payementHistory = em.merge(payementHistory);
            if (payIdOld != null && !payIdOld.equals(payIdNew)) {
                payIdOld.getPayementHistoryList().remove(payementHistory);
                payIdOld = em.merge(payIdOld);
            }
            if (payIdNew != null && !payIdNew.equals(payIdOld)) {
                payIdNew.getPayementHistoryList().add(payementHistory);
                payIdNew = em.merge(payIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = payementHistory.getCommit();
                if (findPayementHistory(id) == null) {
                    throw new NonexistentEntityException("The payementHistory with id " + id + " no longer exists.");
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
            PayementHistory payementHistory;
            try {
                payementHistory = em.getReference(PayementHistory.class, id);
                payementHistory.getCommit();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The payementHistory with id " + id + " no longer exists.", enfe);
            }
            Payementlog payId = payementHistory.getPayId();
            if (payId != null) {
                payId.getPayementHistoryList().remove(payementHistory);
                payId = em.merge(payId);
            }
            em.remove(payementHistory);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PayementHistory> findPayementHistoryEntities() {
        return findPayementHistoryEntities(true, -1, -1);
    }

    public List<PayementHistory> findPayementHistoryEntities(int maxResults, int firstResult) {
        return findPayementHistoryEntities(false, maxResults, firstResult);
    }

    private List<PayementHistory> findPayementHistoryEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PayementHistory.class));
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

    public PayementHistory findPayementHistory(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PayementHistory.class, id);
        } finally {
            em.close();
        }
    }

    public int getPayementHistoryCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PayementHistory> rt = cq.from(PayementHistory.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
