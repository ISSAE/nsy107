/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cofares.controle;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import net.cofares.PayementHistory;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import net.cofares.Payementlog;
import net.cofares.controle.exceptions.IllegalOrphanException;
import net.cofares.controle.exceptions.NonexistentEntityException;
import net.cofares.controle.exceptions.PreexistingEntityException;

/**
 *
 * @author pascalfares
 */
public class PayementlogJpaController implements Serializable {

    public PayementlogJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Payementlog payementlog) throws PreexistingEntityException, Exception {
        if (payementlog.getPayementHistoryList() == null) {
            payementlog.setPayementHistoryList(new ArrayList<PayementHistory>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<PayementHistory> attachedPayementHistoryList = new ArrayList<PayementHistory>();
            for (PayementHistory payementHistoryListPayementHistoryToAttach : payementlog.getPayementHistoryList()) {
                payementHistoryListPayementHistoryToAttach = em.getReference(payementHistoryListPayementHistoryToAttach.getClass(), payementHistoryListPayementHistoryToAttach.getCommit());
                attachedPayementHistoryList.add(payementHistoryListPayementHistoryToAttach);
            }
            payementlog.setPayementHistoryList(attachedPayementHistoryList);
            em.persist(payementlog);
            for (PayementHistory payementHistoryListPayementHistory : payementlog.getPayementHistoryList()) {
                Payementlog oldPayIdOfPayementHistoryListPayementHistory = payementHistoryListPayementHistory.getPayId();
                payementHistoryListPayementHistory.setPayId(payementlog);
                payementHistoryListPayementHistory = em.merge(payementHistoryListPayementHistory);
                if (oldPayIdOfPayementHistoryListPayementHistory != null) {
                    oldPayIdOfPayementHistoryListPayementHistory.getPayementHistoryList().remove(payementHistoryListPayementHistory);
                    oldPayIdOfPayementHistoryListPayementHistory = em.merge(oldPayIdOfPayementHistoryListPayementHistory);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPayementlog(payementlog.getPayId()) != null) {
                throw new PreexistingEntityException("Payementlog " + payementlog + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Payementlog payementlog) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Payementlog persistentPayementlog = em.find(Payementlog.class, payementlog.getPayId());
            List<PayementHistory> payementHistoryListOld = persistentPayementlog.getPayementHistoryList();
            List<PayementHistory> payementHistoryListNew = payementlog.getPayementHistoryList();
            List<String> illegalOrphanMessages = null;
            for (PayementHistory payementHistoryListOldPayementHistory : payementHistoryListOld) {
                if (!payementHistoryListNew.contains(payementHistoryListOldPayementHistory)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain PayementHistory " + payementHistoryListOldPayementHistory + " since its payId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<PayementHistory> attachedPayementHistoryListNew = new ArrayList<PayementHistory>();
            for (PayementHistory payementHistoryListNewPayementHistoryToAttach : payementHistoryListNew) {
                payementHistoryListNewPayementHistoryToAttach = em.getReference(payementHistoryListNewPayementHistoryToAttach.getClass(), payementHistoryListNewPayementHistoryToAttach.getCommit());
                attachedPayementHistoryListNew.add(payementHistoryListNewPayementHistoryToAttach);
            }
            payementHistoryListNew = attachedPayementHistoryListNew;
            payementlog.setPayementHistoryList(payementHistoryListNew);
            payementlog = em.merge(payementlog);
            for (PayementHistory payementHistoryListNewPayementHistory : payementHistoryListNew) {
                if (!payementHistoryListOld.contains(payementHistoryListNewPayementHistory)) {
                    Payementlog oldPayIdOfPayementHistoryListNewPayementHistory = payementHistoryListNewPayementHistory.getPayId();
                    payementHistoryListNewPayementHistory.setPayId(payementlog);
                    payementHistoryListNewPayementHistory = em.merge(payementHistoryListNewPayementHistory);
                    if (oldPayIdOfPayementHistoryListNewPayementHistory != null && !oldPayIdOfPayementHistoryListNewPayementHistory.equals(payementlog)) {
                        oldPayIdOfPayementHistoryListNewPayementHistory.getPayementHistoryList().remove(payementHistoryListNewPayementHistory);
                        oldPayIdOfPayementHistoryListNewPayementHistory = em.merge(oldPayIdOfPayementHistoryListNewPayementHistory);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = payementlog.getPayId();
                if (findPayementlog(id) == null) {
                    throw new NonexistentEntityException("The payementlog with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Payementlog payementlog;
            try {
                payementlog = em.getReference(Payementlog.class, id);
                payementlog.getPayId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The payementlog with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<PayementHistory> payementHistoryListOrphanCheck = payementlog.getPayementHistoryList();
            for (PayementHistory payementHistoryListOrphanCheckPayementHistory : payementHistoryListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Payementlog (" + payementlog + ") cannot be destroyed since the PayementHistory " + payementHistoryListOrphanCheckPayementHistory + " in its payementHistoryList field has a non-nullable payId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(payementlog);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Payementlog> findPayementlogEntities() {
        return findPayementlogEntities(true, -1, -1);
    }

    public List<Payementlog> findPayementlogEntities(int maxResults, int firstResult) {
        return findPayementlogEntities(false, maxResults, firstResult);
    }

    private List<Payementlog> findPayementlogEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Payementlog.class));
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

    public Payementlog findPayementlog(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Payementlog.class, id);
        } finally {
            em.close();
        }
    }

    public int getPayementlogCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Payementlog> rt = cq.from(Payementlog.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
