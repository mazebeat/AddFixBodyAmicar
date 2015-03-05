/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.intelidata.amicar.jpa;

import cl.intelidata.amicar.dao.Clientealgoritmo;
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
public class ClientealgoritmoJpaController implements Serializable {

	private EntityManagerFactory emf = null;

	public ClientealgoritmoJpaController(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public void create(Clientealgoritmo clientealgoritmo) throws PreexistingEntityException, Exception {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.persist(clientealgoritmo);
			em.getTransaction().commit();
		} catch (Exception ex) {
			if (findClientealgoritmo(clientealgoritmo.getIdClienteAlgoritmo()) != null) {
				throw new PreexistingEntityException("Clientealgoritmo " + clientealgoritmo + " already exists.", ex);
			}
			throw ex;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public void edit(Clientealgoritmo clientealgoritmo) throws NonexistentEntityException, Exception {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			clientealgoritmo = em.merge(clientealgoritmo);
			em.getTransaction().commit();
		} catch (Exception ex) {
			String msg = ex.getLocalizedMessage();
			if (msg == null || msg.length() == 0) {
				Integer id = clientealgoritmo.getIdClienteAlgoritmo();
				if (findClientealgoritmo(id) == null) {
					throw new NonexistentEntityException("The clientealgoritmo with id " + id + " no longer exists.");
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
			Clientealgoritmo clientealgoritmo;
			try {
				clientealgoritmo = em.getReference(Clientealgoritmo.class, id);
				clientealgoritmo.getIdClienteAlgoritmo();
			} catch (EntityNotFoundException enfe) {
				throw new NonexistentEntityException("The clientealgoritmo with id " + id + " no longer exists.", enfe);
			}
			em.remove(clientealgoritmo);
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public List<Clientealgoritmo> findClientealgoritmoEntities() {
		return findClientealgoritmoEntities(true, -1, -1);
	}

	public List<Clientealgoritmo> findClientealgoritmoEntities(int maxResults, int firstResult) {
		return findClientealgoritmoEntities(false, maxResults, firstResult);
	}

	private List<Clientealgoritmo> findClientealgoritmoEntities(boolean all, int maxResults, int firstResult) {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			cq.select(cq.from(Clientealgoritmo.class));
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

	public Clientealgoritmo findClientealgoritmo(Integer id) {
		EntityManager em = getEntityManager();
		try {
			return em.find(Clientealgoritmo.class, id);
		} finally {
			em.close();
		}
	}

	public int getClientealgoritmoCount() {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			Root<Clientealgoritmo> rt = cq.from(Clientealgoritmo.class);
			cq.select(em.getCriteriaBuilder().count(rt));
			Query q = em.createQuery(cq);
			return ((Long)q.getSingleResult()).intValue();
		} finally {
			em.close();
		}
	}

}
