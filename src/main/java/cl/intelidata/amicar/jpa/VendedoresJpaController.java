/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.intelidata.amicar.jpa;

import cl.intelidata.amicar.dao.Locales;
import cl.intelidata.amicar.dao.Proceso;
import cl.intelidata.amicar.dao.Vendedores;
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
public class VendedoresJpaController implements Serializable {

	private EntityManagerFactory emf = null;

	public VendedoresJpaController(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public void create(Vendedores vendedores) {
		if (vendedores.getProcesoList() == null) {
			vendedores.setProcesoList(new ArrayList<Proceso>());
		}
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			Locales localesidLocal = vendedores.getLocalesidLocal();
			if (localesidLocal != null) {
				localesidLocal = em.getReference(localesidLocal.getClass(), localesidLocal.getIdLocal());
				vendedores.setLocalesidLocal(localesidLocal);
			}
			List<Proceso> attachedProcesoList = new ArrayList<Proceso>();
			for (Proceso procesoListProcesoToAttach : vendedores.getProcesoList()) {
				procesoListProcesoToAttach = em.getReference(procesoListProcesoToAttach.getClass(), procesoListProcesoToAttach.getIdProceso());
				attachedProcesoList.add(procesoListProcesoToAttach);
			}
			vendedores.setProcesoList(attachedProcesoList);
			em.persist(vendedores);
			if (localesidLocal != null) {
				localesidLocal.getVendedoresList().add(vendedores);
				localesidLocal = em.merge(localesidLocal);
			}
			for (Proceso procesoListProceso : vendedores.getProcesoList()) {
				Vendedores oldVendedoresidVendedorOfProcesoListProceso = procesoListProceso.getVendedoresidVendedor();
				procesoListProceso.setVendedoresidVendedor(vendedores);
				procesoListProceso = em.merge(procesoListProceso);
				if (oldVendedoresidVendedorOfProcesoListProceso != null) {
					oldVendedoresidVendedorOfProcesoListProceso.getProcesoList().remove(procesoListProceso);
					oldVendedoresidVendedorOfProcesoListProceso = em.merge(oldVendedoresidVendedorOfProcesoListProceso);
				}
			}
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public void edit(Vendedores vendedores) throws IllegalOrphanException, NonexistentEntityException, Exception {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			Vendedores persistentVendedores = em.find(Vendedores.class, vendedores.getIdVendedor());
			Locales localesidLocalOld = persistentVendedores.getLocalesidLocal();
			Locales localesidLocalNew = vendedores.getLocalesidLocal();
			List<Proceso> procesoListOld = persistentVendedores.getProcesoList();
			List<Proceso> procesoListNew = vendedores.getProcesoList();
			List<String> illegalOrphanMessages = null;
			for (Proceso procesoListOldProceso : procesoListOld) {
				if (!procesoListNew.contains(procesoListOldProceso)) {
					if (illegalOrphanMessages == null) {
						illegalOrphanMessages = new ArrayList<String>();
					}
					illegalOrphanMessages.add("You must retain Proceso " + procesoListOldProceso + " since its vendedoresidVendedor field is not nullable.");
				}
			}
			if (illegalOrphanMessages != null) {
				throw new IllegalOrphanException(illegalOrphanMessages);
			}
			if (localesidLocalNew != null) {
				localesidLocalNew = em.getReference(localesidLocalNew.getClass(), localesidLocalNew.getIdLocal());
				vendedores.setLocalesidLocal(localesidLocalNew);
			}
			List<Proceso> attachedProcesoListNew = new ArrayList<Proceso>();
			for (Proceso procesoListNewProcesoToAttach : procesoListNew) {
				procesoListNewProcesoToAttach = em.getReference(procesoListNewProcesoToAttach.getClass(), procesoListNewProcesoToAttach.getIdProceso());
				attachedProcesoListNew.add(procesoListNewProcesoToAttach);
			}
			procesoListNew = attachedProcesoListNew;
			vendedores.setProcesoList(procesoListNew);
			vendedores = em.merge(vendedores);
			if (localesidLocalOld != null && !localesidLocalOld.equals(localesidLocalNew)) {
				localesidLocalOld.getVendedoresList().remove(vendedores);
				localesidLocalOld = em.merge(localesidLocalOld);
			}
			if (localesidLocalNew != null && !localesidLocalNew.equals(localesidLocalOld)) {
				localesidLocalNew.getVendedoresList().add(vendedores);
				localesidLocalNew = em.merge(localesidLocalNew);
			}
			for (Proceso procesoListNewProceso : procesoListNew) {
				if (!procesoListOld.contains(procesoListNewProceso)) {
					Vendedores oldVendedoresidVendedorOfProcesoListNewProceso = procesoListNewProceso.getVendedoresidVendedor();
					procesoListNewProceso.setVendedoresidVendedor(vendedores);
					procesoListNewProceso = em.merge(procesoListNewProceso);
					if (oldVendedoresidVendedorOfProcesoListNewProceso != null && !oldVendedoresidVendedorOfProcesoListNewProceso.equals(vendedores)) {
						oldVendedoresidVendedorOfProcesoListNewProceso.getProcesoList().remove(procesoListNewProceso);
						oldVendedoresidVendedorOfProcesoListNewProceso = em.merge(oldVendedoresidVendedorOfProcesoListNewProceso);
					}
				}
			}
			em.getTransaction().commit();
		} catch (Exception ex) {
			String msg = ex.getLocalizedMessage();
			if (msg == null || msg.length() == 0) {
				Integer id = vendedores.getIdVendedor();
				if (findVendedores(id) == null) {
					throw new NonexistentEntityException("The vendedores with id " + id + " no longer exists.");
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
			Vendedores vendedores;
			try {
				vendedores = em.getReference(Vendedores.class, id);
				vendedores.getIdVendedor();
			} catch (EntityNotFoundException enfe) {
				throw new NonexistentEntityException("The vendedores with id " + id + " no longer exists.", enfe);
			}
			List<String> illegalOrphanMessages = null;
			List<Proceso> procesoListOrphanCheck = vendedores.getProcesoList();
			for (Proceso procesoListOrphanCheckProceso : procesoListOrphanCheck) {
				if (illegalOrphanMessages == null) {
					illegalOrphanMessages = new ArrayList<String>();
				}
				illegalOrphanMessages.add("This Vendedores (" + vendedores + ") cannot be destroyed since the Proceso " + procesoListOrphanCheckProceso + " in its procesoList field has a non-nullable vendedoresidVendedor field.");
			}
			if (illegalOrphanMessages != null) {
				throw new IllegalOrphanException(illegalOrphanMessages);
			}
			Locales localesidLocal = vendedores.getLocalesidLocal();
			if (localesidLocal != null) {
				localesidLocal.getVendedoresList().remove(vendedores);
				localesidLocal = em.merge(localesidLocal);
			}
			em.remove(vendedores);
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public List<Vendedores> findVendedoresEntities() {
		return findVendedoresEntities(true, -1, -1);
	}

	public List<Vendedores> findVendedoresEntities(int maxResults, int firstResult) {
		return findVendedoresEntities(false, maxResults, firstResult);
	}

	private List<Vendedores> findVendedoresEntities(boolean all, int maxResults, int firstResult) {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			cq.select(cq.from(Vendedores.class));
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

	public Vendedores findVendedores(Integer id) {
		EntityManager em = getEntityManager();
		try {
			return em.find(Vendedores.class, id);
		} finally {
			em.close();
		}
	}

	public int getVendedoresCount() {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			Root<Vendedores> rt = cq.from(Vendedores.class);
			cq.select(em.getCriteriaBuilder().count(rt));
			Query q = em.createQuery(cq);
			return ((Long)q.getSingleResult()).intValue();
		} finally {
			em.close();
		}
	}

}
