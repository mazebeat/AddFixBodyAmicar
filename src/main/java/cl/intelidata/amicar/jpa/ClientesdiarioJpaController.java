/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.intelidata.amicar.jpa;

import cl.intelidata.amicar.dao.Clientesdiario;
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
public class ClientesdiarioJpaController implements Serializable {

	private EntityManagerFactory emf = null;

	public ClientesdiarioJpaController(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public void create(Clientesdiario clientesdiario) {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.persist(clientesdiario);
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public void edit(Clientesdiario clientesdiario) throws NonexistentEntityException, Exception {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			clientesdiario = em.merge(clientesdiario);
			em.getTransaction().commit();
		} catch (Exception ex) {
			String msg = ex.getLocalizedMessage();
			if (msg == null || msg.length() == 0) {
				Integer id = clientesdiario.getIdCliente();
				if (findClientesdiario(id) == null) {
					throw new NonexistentEntityException("The clientesdiario with id " + id + " no longer exists.");
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
			Clientesdiario clientesdiario;
			try {
				clientesdiario = em.getReference(Clientesdiario.class, id);
				clientesdiario.getIdCliente();
			} catch (EntityNotFoundException enfe) {
				throw new NonexistentEntityException("The clientesdiario with id " + id + " no longer exists.", enfe);
			}
			em.remove(clientesdiario);
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public List<Clientesdiario> findClientesdiarioEntities() {
		return findClientesdiarioEntities(true, -1, -1);
	}

	public List<Clientesdiario> findClientesdiarioEntities(int maxResults, int firstResult) {
		return findClientesdiarioEntities(false, maxResults, firstResult);
	}

	private List<Clientesdiario> findClientesdiarioEntities(boolean all, int maxResults, int firstResult) {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			cq.select(cq.from(Clientesdiario.class));
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

	public Clientesdiario findClientesdiario(Integer id) {
		EntityManager em = getEntityManager();
		try {
			return em.find(Clientesdiario.class, id);
		} finally {
			em.close();
		}
	}

	public int getClientesdiarioCount() {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			Root<Clientesdiario> rt = cq.from(Clientesdiario.class);
			cq.select(em.getCriteriaBuilder().count(rt));
			Query q = em.createQuery(cq);
			return ((Long)q.getSingleResult()).intValue();
		} finally {
			em.close();
		}
	}

}
