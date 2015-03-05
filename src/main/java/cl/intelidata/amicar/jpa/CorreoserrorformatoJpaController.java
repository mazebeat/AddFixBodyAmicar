/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.intelidata.amicar.jpa;

import cl.intelidata.amicar.dao.Correoserrorformato;
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
public class CorreoserrorformatoJpaController implements Serializable {

	private EntityManagerFactory emf = null;

	public CorreoserrorformatoJpaController(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public void create(Correoserrorformato correoserrorformato) {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.persist(correoserrorformato);
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public void edit(Correoserrorformato correoserrorformato) throws NonexistentEntityException, Exception {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			correoserrorformato = em.merge(correoserrorformato);
			em.getTransaction().commit();
		} catch (Exception ex) {
			String msg = ex.getLocalizedMessage();
			if (msg == null || msg.length() == 0) {
				Integer id = correoserrorformato.getIdCliente();
				if (findCorreoserrorformato(id) == null) {
					throw new NonexistentEntityException("The correoserrorformato with id " + id + " no longer exists.");
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
			Correoserrorformato correoserrorformato;
			try {
				correoserrorformato = em.getReference(Correoserrorformato.class, id);
				correoserrorformato.getIdCliente();
			} catch (EntityNotFoundException enfe) {
				throw new NonexistentEntityException("The correoserrorformato with id " + id + " no longer exists.", enfe);
			}
			em.remove(correoserrorformato);
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public List<Correoserrorformato> findCorreoserrorformatoEntities() {
		return findCorreoserrorformatoEntities(true, -1, -1);
	}

	public List<Correoserrorformato> findCorreoserrorformatoEntities(int maxResults, int firstResult) {
		return findCorreoserrorformatoEntities(false, maxResults, firstResult);
	}

	private List<Correoserrorformato> findCorreoserrorformatoEntities(boolean all, int maxResults, int firstResult) {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			cq.select(cq.from(Correoserrorformato.class));
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

	public Correoserrorformato findCorreoserrorformato(Integer id) {
		EntityManager em = getEntityManager();
		try {
			return em.find(Correoserrorformato.class, id);
		} finally {
			em.close();
		}
	}

	public int getCorreoserrorformatoCount() {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			Root<Correoserrorformato> rt = cq.from(Correoserrorformato.class);
			cq.select(em.getCriteriaBuilder().count(rt));
			Query q = em.createQuery(cq);
			return ((Long)q.getSingleResult()).intValue();
		} finally {
			em.close();
		}
	}

}
