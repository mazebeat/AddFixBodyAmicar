/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.intelidata.amicar.jpa;

import cl.intelidata.amicar.dao.Ejecutivos;
import cl.intelidata.amicar.dao.Locales;
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
public class LocalesJpaController implements Serializable {

	private EntityManagerFactory emf = null;

	public LocalesJpaController(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public void create(Locales locales) {
		if (locales.getVendedoresList() == null) {
			locales.setVendedoresList(new ArrayList<Vendedores>());
		}
		if (locales.getEjecutivosList() == null) {
			locales.setEjecutivosList(new ArrayList<Ejecutivos>());
		}
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			List<Vendedores> attachedVendedoresList = new ArrayList<Vendedores>();
			for (Vendedores vendedoresListVendedoresToAttach : locales.getVendedoresList()) {
				vendedoresListVendedoresToAttach = em.getReference(vendedoresListVendedoresToAttach.getClass(), vendedoresListVendedoresToAttach.getIdVendedor());
				attachedVendedoresList.add(vendedoresListVendedoresToAttach);
			}
			locales.setVendedoresList(attachedVendedoresList);
			List<Ejecutivos> attachedEjecutivosList = new ArrayList<Ejecutivos>();
			for (Ejecutivos ejecutivosListEjecutivosToAttach : locales.getEjecutivosList()) {
				ejecutivosListEjecutivosToAttach = em.getReference(ejecutivosListEjecutivosToAttach.getClass(), ejecutivosListEjecutivosToAttach.getIdEjecutivo());
				attachedEjecutivosList.add(ejecutivosListEjecutivosToAttach);
			}
			locales.setEjecutivosList(attachedEjecutivosList);
			em.persist(locales);
			for (Vendedores vendedoresListVendedores : locales.getVendedoresList()) {
				Locales oldLocalesidLocalOfVendedoresListVendedores = vendedoresListVendedores.getLocalesidLocal();
				vendedoresListVendedores.setLocalesidLocal(locales);
				vendedoresListVendedores = em.merge(vendedoresListVendedores);
				if (oldLocalesidLocalOfVendedoresListVendedores != null) {
					oldLocalesidLocalOfVendedoresListVendedores.getVendedoresList().remove(vendedoresListVendedores);
					oldLocalesidLocalOfVendedoresListVendedores = em.merge(oldLocalesidLocalOfVendedoresListVendedores);
				}
			}
			for (Ejecutivos ejecutivosListEjecutivos : locales.getEjecutivosList()) {
				Locales oldLocalesidLocal1OfEjecutivosListEjecutivos = ejecutivosListEjecutivos.getLocalesidLocal1();
				ejecutivosListEjecutivos.setLocalesidLocal1(locales);
				ejecutivosListEjecutivos = em.merge(ejecutivosListEjecutivos);
				if (oldLocalesidLocal1OfEjecutivosListEjecutivos != null) {
					oldLocalesidLocal1OfEjecutivosListEjecutivos.getEjecutivosList().remove(ejecutivosListEjecutivos);
					oldLocalesidLocal1OfEjecutivosListEjecutivos = em.merge(oldLocalesidLocal1OfEjecutivosListEjecutivos);
				}
			}
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public void edit(Locales locales) throws IllegalOrphanException, NonexistentEntityException, Exception {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			Locales persistentLocales = em.find(Locales.class, locales.getIdLocal());
			List<Vendedores> vendedoresListOld = persistentLocales.getVendedoresList();
			List<Vendedores> vendedoresListNew = locales.getVendedoresList();
			List<Ejecutivos> ejecutivosListOld = persistentLocales.getEjecutivosList();
			List<Ejecutivos> ejecutivosListNew = locales.getEjecutivosList();
			List<String> illegalOrphanMessages = null;
			for (Vendedores vendedoresListOldVendedores : vendedoresListOld) {
				if (!vendedoresListNew.contains(vendedoresListOldVendedores)) {
					if (illegalOrphanMessages == null) {
						illegalOrphanMessages = new ArrayList<String>();
					}
					illegalOrphanMessages.add("You must retain Vendedores " + vendedoresListOldVendedores + " since its localesidLocal field is not nullable.");
				}
			}
			for (Ejecutivos ejecutivosListOldEjecutivos : ejecutivosListOld) {
				if (!ejecutivosListNew.contains(ejecutivosListOldEjecutivos)) {
					if (illegalOrphanMessages == null) {
						illegalOrphanMessages = new ArrayList<String>();
					}
					illegalOrphanMessages.add("You must retain Ejecutivos " + ejecutivosListOldEjecutivos + " since its localesidLocal1 field is not nullable.");
				}
			}
			if (illegalOrphanMessages != null) {
				throw new IllegalOrphanException(illegalOrphanMessages);
			}
			List<Vendedores> attachedVendedoresListNew = new ArrayList<Vendedores>();
			for (Vendedores vendedoresListNewVendedoresToAttach : vendedoresListNew) {
				vendedoresListNewVendedoresToAttach = em.getReference(vendedoresListNewVendedoresToAttach.getClass(), vendedoresListNewVendedoresToAttach.getIdVendedor());
				attachedVendedoresListNew.add(vendedoresListNewVendedoresToAttach);
			}
			vendedoresListNew = attachedVendedoresListNew;
			locales.setVendedoresList(vendedoresListNew);
			List<Ejecutivos> attachedEjecutivosListNew = new ArrayList<Ejecutivos>();
			for (Ejecutivos ejecutivosListNewEjecutivosToAttach : ejecutivosListNew) {
				ejecutivosListNewEjecutivosToAttach = em.getReference(ejecutivosListNewEjecutivosToAttach.getClass(), ejecutivosListNewEjecutivosToAttach.getIdEjecutivo());
				attachedEjecutivosListNew.add(ejecutivosListNewEjecutivosToAttach);
			}
			ejecutivosListNew = attachedEjecutivosListNew;
			locales.setEjecutivosList(ejecutivosListNew);
			locales = em.merge(locales);
			for (Vendedores vendedoresListNewVendedores : vendedoresListNew) {
				if (!vendedoresListOld.contains(vendedoresListNewVendedores)) {
					Locales oldLocalesidLocalOfVendedoresListNewVendedores = vendedoresListNewVendedores.getLocalesidLocal();
					vendedoresListNewVendedores.setLocalesidLocal(locales);
					vendedoresListNewVendedores = em.merge(vendedoresListNewVendedores);
					if (oldLocalesidLocalOfVendedoresListNewVendedores != null && !oldLocalesidLocalOfVendedoresListNewVendedores.equals(locales)) {
						oldLocalesidLocalOfVendedoresListNewVendedores.getVendedoresList().remove(vendedoresListNewVendedores);
						oldLocalesidLocalOfVendedoresListNewVendedores = em.merge(oldLocalesidLocalOfVendedoresListNewVendedores);
					}
				}
			}
			for (Ejecutivos ejecutivosListNewEjecutivos : ejecutivosListNew) {
				if (!ejecutivosListOld.contains(ejecutivosListNewEjecutivos)) {
					Locales oldLocalesidLocal1OfEjecutivosListNewEjecutivos = ejecutivosListNewEjecutivos.getLocalesidLocal1();
					ejecutivosListNewEjecutivos.setLocalesidLocal1(locales);
					ejecutivosListNewEjecutivos = em.merge(ejecutivosListNewEjecutivos);
					if (oldLocalesidLocal1OfEjecutivosListNewEjecutivos != null && !oldLocalesidLocal1OfEjecutivosListNewEjecutivos.equals(locales)) {
						oldLocalesidLocal1OfEjecutivosListNewEjecutivos.getEjecutivosList().remove(ejecutivosListNewEjecutivos);
						oldLocalesidLocal1OfEjecutivosListNewEjecutivos = em.merge(oldLocalesidLocal1OfEjecutivosListNewEjecutivos);
					}
				}
			}
			em.getTransaction().commit();
		} catch (Exception ex) {
			String msg = ex.getLocalizedMessage();
			if (msg == null || msg.length() == 0) {
				Integer id = locales.getIdLocal();
				if (findLocales(id) == null) {
					throw new NonexistentEntityException("The locales with id " + id + " no longer exists.");
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
			Locales locales;
			try {
				locales = em.getReference(Locales.class, id);
				locales.getIdLocal();
			} catch (EntityNotFoundException enfe) {
				throw new NonexistentEntityException("The locales with id " + id + " no longer exists.", enfe);
			}
			List<String> illegalOrphanMessages = null;
			List<Vendedores> vendedoresListOrphanCheck = locales.getVendedoresList();
			for (Vendedores vendedoresListOrphanCheckVendedores : vendedoresListOrphanCheck) {
				if (illegalOrphanMessages == null) {
					illegalOrphanMessages = new ArrayList<String>();
				}
				illegalOrphanMessages.add("This Locales (" + locales + ") cannot be destroyed since the Vendedores " + vendedoresListOrphanCheckVendedores + " in its vendedoresList field has a non-nullable localesidLocal field.");
			}
			List<Ejecutivos> ejecutivosListOrphanCheck = locales.getEjecutivosList();
			for (Ejecutivos ejecutivosListOrphanCheckEjecutivos : ejecutivosListOrphanCheck) {
				if (illegalOrphanMessages == null) {
					illegalOrphanMessages = new ArrayList<String>();
				}
				illegalOrphanMessages.add("This Locales (" + locales + ") cannot be destroyed since the Ejecutivos " + ejecutivosListOrphanCheckEjecutivos + " in its ejecutivosList field has a non-nullable localesidLocal1 field.");
			}
			if (illegalOrphanMessages != null) {
				throw new IllegalOrphanException(illegalOrphanMessages);
			}
			em.remove(locales);
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public List<Locales> findLocalesEntities() {
		return findLocalesEntities(true, -1, -1);
	}

	public List<Locales> findLocalesEntities(int maxResults, int firstResult) {
		return findLocalesEntities(false, maxResults, firstResult);
	}

	private List<Locales> findLocalesEntities(boolean all, int maxResults, int firstResult) {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			cq.select(cq.from(Locales.class));
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

	public Locales findLocales(Integer id) {
		EntityManager em = getEntityManager();
		try {
			return em.find(Locales.class, id);
		} finally {
			em.close();
		}
	}

	public int getLocalesCount() {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			Root<Locales> rt = cq.from(Locales.class);
			cq.select(em.getCriteriaBuilder().count(rt));
			Query q = em.createQuery(cq);
			return ((Long)q.getSingleResult()).intValue();
		} finally {
			em.close();
		}
	}

}
