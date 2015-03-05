/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.intelidata.amicar.jpa;

import cl.intelidata.amicar.dao.Log;
import cl.intelidata.amicar.jpa.exceptions.NonexistentEntityException;
import cl.intelidata.amicar.jpa.exceptions.PreexistingEntityException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

/**
 * @author Maze
 */
public class LogJpaController implements Serializable {

	private EntityManagerFactory emf = null;

	public LogJpaController(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public void create(Log log) throws PreexistingEntityException, Exception {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.persist(log);
			em.getTransaction().commit();
		} catch (Exception ex) {
			if (findLog(log.getIdlog()) != null) {
				throw new PreexistingEntityException("Log " + log + " already exists.", ex);
			}
			throw ex;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public void edit(Log log) throws NonexistentEntityException, Exception {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			log = em.merge(log);
			em.getTransaction().commit();
		} catch (Exception ex) {
			String msg = ex.getLocalizedMessage();
			if (msg == null || msg.length() == 0) {
				Integer id = log.getIdlog();
				if (findLog(id) == null) {
					throw new NonexistentEntityException("The log with id " + id + " no longer exists.");
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
			Log log;
			try {
				log = em.getReference(Log.class, id);
				log.getIdlog();
			} catch (EntityNotFoundException enfe) {
				throw new NonexistentEntityException("The log with id " + id + " no longer exists.", enfe);
			}
			em.remove(log);
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public List<Log> findLogEntities() {
		return findLogEntities(true, -1, -1);
	}

	public List<Log> findLogEntities(int maxResults, int firstResult) {
		return findLogEntities(false, maxResults, firstResult);
	}

	private List<Log> findLogEntities(boolean all, int maxResults, int firstResult) {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			cq.select(cq.from(Log.class));
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

	public Log findLog(Integer id) {
		EntityManager em = getEntityManager();
		try {
			return em.find(Log.class, id);
		} finally {
			em.close();
		}
	}

	public int getLogCount() {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			Root<Log> rt = cq.from(Log.class);
			cq.select(em.getCriteriaBuilder().count(rt));
			Query q = em.createQuery(cq);
			return ((Long)q.getSingleResult()).intValue();
		} finally {
			em.close();
		}
	}

}