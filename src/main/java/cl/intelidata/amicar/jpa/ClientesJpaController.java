/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.intelidata.amicar.jpa;

import cl.intelidata.amicar.dao.Clientes;
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
public class ClientesJpaController implements Serializable {

	private EntityManagerFactory emf = null;

	public ClientesJpaController(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public void create(Clientes clientes) {
		if (clientes.getProcesoList() == null) {
			clientes.setProcesoList(new ArrayList<Proceso>());
		}
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			List<Proceso> attachedProcesoList = new ArrayList<Proceso>();
			for (Proceso procesoListProcesoToAttach : clientes.getProcesoList()) {
				procesoListProcesoToAttach = em.getReference(procesoListProcesoToAttach.getClass(), procesoListProcesoToAttach.getIdProceso());
				attachedProcesoList.add(procesoListProcesoToAttach);
			}
			clientes.setProcesoList(attachedProcesoList);
			em.persist(clientes);
			for (Proceso procesoListProceso : clientes.getProcesoList()) {
				Clientes oldClientesidClienteOfProcesoListProceso = procesoListProceso.getClientesidCliente();
				procesoListProceso.setClientesidCliente(clientes);
				procesoListProceso = em.merge(procesoListProceso);
				if (oldClientesidClienteOfProcesoListProceso != null) {
					oldClientesidClienteOfProcesoListProceso.getProcesoList().remove(procesoListProceso);
					oldClientesidClienteOfProcesoListProceso = em.merge(oldClientesidClienteOfProcesoListProceso);
				}
			}
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public void edit(Clientes clientes) throws IllegalOrphanException, NonexistentEntityException, Exception {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			Clientes persistentClientes = em.find(Clientes.class, clientes.getIdCliente());
			List<Proceso> procesoListOld = persistentClientes.getProcesoList();
			List<Proceso> procesoListNew = clientes.getProcesoList();
			List<String> illegalOrphanMessages = null;
			for (Proceso procesoListOldProceso : procesoListOld) {
				if (!procesoListNew.contains(procesoListOldProceso)) {
					if (illegalOrphanMessages == null) {
						illegalOrphanMessages = new ArrayList<String>();
					}
					illegalOrphanMessages.add("You must retain Proceso " + procesoListOldProceso + " since its clientesidCliente field is not nullable.");
				}
			}
			if (illegalOrphanMessages != null) {
				throw new IllegalOrphanException(illegalOrphanMessages);
			}
			List<Proceso> attachedProcesoListNew = new ArrayList<Proceso>();
			for (Proceso procesoListNewProcesoToAttach : procesoListNew) {
				procesoListNewProcesoToAttach = em.getReference(procesoListNewProcesoToAttach.getClass(), procesoListNewProcesoToAttach.getIdProceso());
				attachedProcesoListNew.add(procesoListNewProcesoToAttach);
			}
			procesoListNew = attachedProcesoListNew;
			clientes.setProcesoList(procesoListNew);
			clientes = em.merge(clientes);
			for (Proceso procesoListNewProceso : procesoListNew) {
				if (!procesoListOld.contains(procesoListNewProceso)) {
					Clientes oldClientesidClienteOfProcesoListNewProceso = procesoListNewProceso.getClientesidCliente();
					procesoListNewProceso.setClientesidCliente(clientes);
					procesoListNewProceso = em.merge(procesoListNewProceso);
					if (oldClientesidClienteOfProcesoListNewProceso != null && !oldClientesidClienteOfProcesoListNewProceso.equals(clientes)) {
						oldClientesidClienteOfProcesoListNewProceso.getProcesoList().remove(procesoListNewProceso);
						oldClientesidClienteOfProcesoListNewProceso = em.merge(oldClientesidClienteOfProcesoListNewProceso);
					}
				}
			}
			em.getTransaction().commit();
		} catch (Exception ex) {
			String msg = ex.getLocalizedMessage();
			if (msg == null || msg.length() == 0) {
				Integer id = clientes.getIdCliente();
				if (findClientes(id) == null) {
					throw new NonexistentEntityException("The clientes with id " + id + " no longer exists.");
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
			Clientes clientes;
			try {
				clientes = em.getReference(Clientes.class, id);
				clientes.getIdCliente();
			} catch (EntityNotFoundException enfe) {
				throw new NonexistentEntityException("The clientes with id " + id + " no longer exists.", enfe);
			}
			List<String> illegalOrphanMessages = null;
			List<Proceso> procesoListOrphanCheck = clientes.getProcesoList();
			for (Proceso procesoListOrphanCheckProceso : procesoListOrphanCheck) {
				if (illegalOrphanMessages == null) {
					illegalOrphanMessages = new ArrayList<String>();
				}
				illegalOrphanMessages.add("This Clientes (" + clientes + ") cannot be destroyed since the Proceso " + procesoListOrphanCheckProceso + " in its procesoList field has a non-nullable clientesidCliente field.");
			}
			if (illegalOrphanMessages != null) {
				throw new IllegalOrphanException(illegalOrphanMessages);
			}
			em.remove(clientes);
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public List<Clientes> findClientesEntities() {
		return findClientesEntities(true, -1, -1);
	}

	public List<Clientes> findClientesEntities(int maxResults, int firstResult) {
		return findClientesEntities(false, maxResults, firstResult);
	}

	private List<Clientes> findClientesEntities(boolean all, int maxResults, int firstResult) {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			cq.select(cq.from(Clientes.class));
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

	public Clientes findClientes(Integer id) {
		EntityManager em = getEntityManager();
		try {
			return em.find(Clientes.class, id);
		} finally {
			em.close();
		}
	}

	public int getClientesCount() {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			Root<Clientes> rt = cq.from(Clientes.class);
			cq.select(em.getCriteriaBuilder().count(rt));
			Query q = em.createQuery(cq);
			return ((Long)q.getSingleResult()).intValue();
		} finally {
			em.close();
		}
	}

	public Clientes findByRutAndMail(String rut, String mail) {
		EntityManager em = getEntityManager();
		Clientes foundEntity = null;

		try {
			em.getTransaction().begin();
			Query query = em.createNamedQuery("Clientes.findByRutAndEmailCliente");
			query.setParameter("rutCliente", rut);
			query.setParameter("emailCliente", mail);
			em.getTransaction().commit();
			List results = query.getResultList();
			if (!results.isEmpty()) {
				foundEntity = (Clientes)results.get(0);
			}
		} finally {
			em.close();
		}

		return foundEntity;
	}

}
