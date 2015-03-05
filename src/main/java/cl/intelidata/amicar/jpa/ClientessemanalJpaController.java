/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.intelidata.amicar.jpa;

import cl.intelidata.amicar.dao.Clientessemanal;
import cl.intelidata.amicar.jpa.exceptions.NonexistentEntityException;

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
public class ClientessemanalJpaController implements Serializable {

	private EntityManagerFactory emf = null;

	public ClientessemanalJpaController(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public void create(Clientessemanal clientessemanal) {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.persist(clientessemanal);
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public void edit(Clientessemanal clientessemanal) throws NonexistentEntityException, Exception {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			clientessemanal = em.merge(clientessemanal);
			em.getTransaction().commit();
		} catch (Exception ex) {
			String msg = ex.getLocalizedMessage();
			if (msg == null || msg.length() == 0) {
				Integer id = clientessemanal.getIdCliente();
				if (findClientessemanal(id) == null) {
					throw new NonexistentEntityException("The clientessemanal with id " + id + " no longer exists.");
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
			Clientessemanal clientessemanal;
			try {
				clientessemanal = em.getReference(Clientessemanal.class, id);
				clientessemanal.getIdCliente();
			} catch (EntityNotFoundException enfe) {
				throw new NonexistentEntityException("The clientessemanal with id " + id + " no longer exists.", enfe);
			}
			em.remove(clientessemanal);
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public List<Clientessemanal> findClientessemanalEntities() {
		return findClientessemanalEntities(true, -1, -1);
	}

	public List<Clientessemanal> findClientessemanalEntities(int maxResults, int firstResult) {
		return findClientessemanalEntities(false, maxResults, firstResult);
	}

	private List<Clientessemanal> findClientessemanalEntities(boolean all, int maxResults, int firstResult) {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			cq.select(cq.from(Clientessemanal.class));
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

	public Clientessemanal findClientessemanal(Integer id) {
		EntityManager em = getEntityManager();
		try {
			return em.find(Clientessemanal.class, id);
		} finally {
			em.close();
		}
	}

	public int getClientessemanalCount() {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			Root<Clientessemanal> rt = cq.from(Clientessemanal.class);
			cq.select(em.getCriteriaBuilder().count(rt));
			Query q = em.createQuery(cq);
			return ((Long)q.getSingleResult()).intValue();
		} finally {
			em.close();
		}
	}

}
