/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.intelidata.amicar.jpa;

import cl.intelidata.amicar.dao.Ejecutivos;
import cl.intelidata.amicar.dao.Locales;
import cl.intelidata.amicar.dao.Proceso;
import cl.intelidata.amicar.jpa.exceptions.IllegalOrphanException;
import cl.intelidata.amicar.jpa.exceptions.NonexistentEntityException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Maze
 */
public class EjecutivosJpaController implements Serializable {

	private EntityManagerFactory emf = null;

	public EjecutivosJpaController(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public void create(Ejecutivos ejecutivos) {
		if (ejecutivos.getProcesoList() == null) {
			ejecutivos.setProcesoList(new ArrayList<Proceso>());
		}
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			Locales localesidLocal1 = ejecutivos.getLocalesidLocal1();
			if (localesidLocal1 != null) {
				localesidLocal1 = em.getReference(localesidLocal1.getClass(), localesidLocal1.getIdLocal());
				ejecutivos.setLocalesidLocal1(localesidLocal1);
			}
			List<Proceso> attachedProcesoList = new ArrayList<Proceso>();
			for (Proceso procesoListProcesoToAttach : ejecutivos.getProcesoList()) {
				procesoListProcesoToAttach = em.getReference(procesoListProcesoToAttach.getClass(), procesoListProcesoToAttach.getIdProceso());
				attachedProcesoList.add(procesoListProcesoToAttach);
			}
			ejecutivos.setProcesoList(attachedProcesoList);
			em.persist(ejecutivos);
			if (localesidLocal1 != null) {
				localesidLocal1.getEjecutivosList().add(ejecutivos);
				localesidLocal1 = em.merge(localesidLocal1);
			}
			for (Proceso procesoListProceso : ejecutivos.getProcesoList()) {
				Ejecutivos oldEjecutivosidEjecutivoOfProcesoListProceso = procesoListProceso.getEjecutivosidEjecutivo();
				procesoListProceso.setEjecutivosidEjecutivo(ejecutivos);
				procesoListProceso = em.merge(procesoListProceso);
				if (oldEjecutivosidEjecutivoOfProcesoListProceso != null) {
					oldEjecutivosidEjecutivoOfProcesoListProceso.getProcesoList().remove(procesoListProceso);
					oldEjecutivosidEjecutivoOfProcesoListProceso = em.merge(oldEjecutivosidEjecutivoOfProcesoListProceso);
				}
			}
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public void edit(Ejecutivos ejecutivos) throws IllegalOrphanException, NonexistentEntityException, Exception {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			Ejecutivos persistentEjecutivos = em.find(Ejecutivos.class, ejecutivos.getIdEjecutivo());
			Locales localesidLocal1Old = persistentEjecutivos.getLocalesidLocal1();
			Locales localesidLocal1New = ejecutivos.getLocalesidLocal1();
			List<Proceso> procesoListOld = persistentEjecutivos.getProcesoList();
			List<Proceso> procesoListNew = ejecutivos.getProcesoList();
			List<String> illegalOrphanMessages = null;
			for (Proceso procesoListOldProceso : procesoListOld) {
				if (!procesoListNew.contains(procesoListOldProceso)) {
					if (illegalOrphanMessages == null) {
						illegalOrphanMessages = new ArrayList<String>();
					}
					illegalOrphanMessages.add("You must retain Proceso " + procesoListOldProceso + " since its ejecutivosidEjecutivo field is not nullable.");
				}
			}
			if (illegalOrphanMessages != null) {
				throw new IllegalOrphanException(illegalOrphanMessages);
			}
			if (localesidLocal1New != null) {
				localesidLocal1New = em.getReference(localesidLocal1New.getClass(), localesidLocal1New.getIdLocal());
				ejecutivos.setLocalesidLocal1(localesidLocal1New);
			}
			List<Proceso> attachedProcesoListNew = new ArrayList<Proceso>();
			for (Proceso procesoListNewProcesoToAttach : procesoListNew) {
				procesoListNewProcesoToAttach = em.getReference(procesoListNewProcesoToAttach.getClass(), procesoListNewProcesoToAttach.getIdProceso());
				attachedProcesoListNew.add(procesoListNewProcesoToAttach);
			}
			procesoListNew = attachedProcesoListNew;
			ejecutivos.setProcesoList(procesoListNew);
			ejecutivos = em.merge(ejecutivos);
			if (localesidLocal1Old != null && !localesidLocal1Old.equals(localesidLocal1New)) {
				localesidLocal1Old.getEjecutivosList().remove(ejecutivos);
				localesidLocal1Old = em.merge(localesidLocal1Old);
			}
			if (localesidLocal1New != null && !localesidLocal1New.equals(localesidLocal1Old)) {
				localesidLocal1New.getEjecutivosList().add(ejecutivos);
				localesidLocal1New = em.merge(localesidLocal1New);
			}
			for (Proceso procesoListNewProceso : procesoListNew) {
				if (!procesoListOld.contains(procesoListNewProceso)) {
					Ejecutivos oldEjecutivosidEjecutivoOfProcesoListNewProceso = procesoListNewProceso.getEjecutivosidEjecutivo();
					procesoListNewProceso.setEjecutivosidEjecutivo(ejecutivos);
					procesoListNewProceso = em.merge(procesoListNewProceso);
					if (oldEjecutivosidEjecutivoOfProcesoListNewProceso != null && !oldEjecutivosidEjecutivoOfProcesoListNewProceso.equals(ejecutivos)) {
						oldEjecutivosidEjecutivoOfProcesoListNewProceso.getProcesoList().remove(procesoListNewProceso);
						oldEjecutivosidEjecutivoOfProcesoListNewProceso = em.merge(oldEjecutivosidEjecutivoOfProcesoListNewProceso);
					}
				}
			}
			em.getTransaction().commit();
		} catch (Exception ex) {
			String msg = ex.getLocalizedMessage();
			if (msg == null || msg.length() == 0) {
				Integer id = ejecutivos.getIdEjecutivo();
				if (findEjecutivos(id) == null) {
					throw new NonexistentEntityException("The ejecutivos with id " + id + " no longer exists.");
				}
			}
			throw ex;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			Ejecutivos ejecutivos;
			try {
				ejecutivos = em.getReference(Ejecutivos.class, id);
				ejecutivos.getIdEjecutivo();
			} catch (EntityNotFoundException enfe) {
				throw new NonexistentEntityException("The ejecutivos with id " + id + " no longer exists.", enfe);
			}
			List<String> illegalOrphanMessages = null;
			List<Proceso> procesoListOrphanCheck = ejecutivos.getProcesoList();
			for (Proceso procesoListOrphanCheckProceso : procesoListOrphanCheck) {
				if (illegalOrphanMessages == null) {
					illegalOrphanMessages = new ArrayList<String>();
				}
				illegalOrphanMessages.add("This Ejecutivos (" + ejecutivos + ") cannot be destroyed since the Proceso " + procesoListOrphanCheckProceso + " in its procesoList field has a non-nullable ejecutivosidEjecutivo field.");
			}
			if (illegalOrphanMessages != null) {
				throw new IllegalOrphanException(illegalOrphanMessages);
			}
			Locales localesidLocal1 = ejecutivos.getLocalesidLocal1();
			if (localesidLocal1 != null) {
				localesidLocal1.getEjecutivosList().remove(ejecutivos);
				localesidLocal1 = em.merge(localesidLocal1);
			}
			em.remove(ejecutivos);
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public List<Ejecutivos> findEjecutivosEntities() {
		return findEjecutivosEntities(true, -1, -1);
	}

	public List<Ejecutivos> findEjecutivosEntities(int maxResults, int firstResult) {
		return findEjecutivosEntities(false, maxResults, firstResult);
	}

	private List<Ejecutivos> findEjecutivosEntities(boolean all, int maxResults, int firstResult) {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			cq.select(cq.from(Ejecutivos.class));
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

	public Ejecutivos findEjecutivos(Integer id) {
		EntityManager em = getEntityManager();
		try {
			return em.find(Ejecutivos.class, id);
		} finally {
			em.close();
		}
	}

	public int getEjecutivosCount() {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			Root<Ejecutivos> rt = cq.from(Ejecutivos.class);
			cq.select(em.getCriteriaBuilder().count(rt));
			Query q = em.createQuery(cq);
			return ((Long)q.getSingleResult()).intValue();
		} finally {
			em.close();
		}
	}

}
