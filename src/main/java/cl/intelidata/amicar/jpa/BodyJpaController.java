/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.intelidata.amicar.jpa;

import cl.intelidata.amicar.dao.Body;
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
public class BodyJpaController implements Serializable {

	private EntityManagerFactory emf = null;

	public BodyJpaController(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public void create(Body body) throws PreexistingEntityException, Exception {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.persist(body);
			em.getTransaction().commit();
		} catch (Exception ex) {
			if (findBody(body.getIdBody()) != null) {
				throw new PreexistingEntityException("Body " + body + " already exists.", ex);
			}
			throw ex;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public void edit(Body body) throws NonexistentEntityException, Exception {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			body = em.merge(body);
			em.getTransaction().commit();
		} catch (Exception ex) {
			String msg = ex.getLocalizedMessage();
			if (msg == null || msg.length() == 0) {
				Integer id = body.getIdBody();
				if (findBody(id) == null) {
					throw new NonexistentEntityException("The body with id " + id + " no longer exists.");
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
			Body body;
			try {
				body = em.getReference(Body.class, id);
				body.getIdBody();
			} catch (EntityNotFoundException enfe) {
				throw new NonexistentEntityException("The body with id " + id + " no longer exists.", enfe);
			}
			em.remove(body);
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public List<Body> findBodyEntities() {
		return findBodyEntities(true, -1, -1);
	}

	public List<Body> findBodyEntities(int maxResults, int firstResult) {
		return findBodyEntities(false, maxResults, firstResult);
	}

	private List<Body> findBodyEntities(boolean all, int maxResults, int firstResult) {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			cq.select(cq.from(Body.class));
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

	public Body findBody(Integer id) {
		EntityManager em = getEntityManager();
		try {
			return em.find(Body.class, id);
		} finally {
			em.close();
		}
	}

	public int getBodyCount() {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			Root<Body> rt = cq.from(Body.class);
			cq.select(em.getCriteriaBuilder().count(rt));
			Query q = em.createQuery(cq);
			return ((Long)q.getSingleResult()).intValue();
		} finally {
			em.close();
		}
	}

}
