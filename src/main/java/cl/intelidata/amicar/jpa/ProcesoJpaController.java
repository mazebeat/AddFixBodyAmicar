/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.intelidata.amicar.jpa;

import cl.intelidata.amicar.dao.Clientes;
import cl.intelidata.amicar.dao.Ejecutivos;
import cl.intelidata.amicar.dao.Proceso;
import cl.intelidata.amicar.dao.Vendedores;
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
public class ProcesoJpaController implements Serializable {

	private EntityManagerFactory emf = null;

	public ProcesoJpaController(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public void create(Proceso proceso) {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			Vendedores vendedoresidVendedor = proceso.getVendedoresidVendedor();
			if (vendedoresidVendedor != null) {
				vendedoresidVendedor = em.getReference(vendedoresidVendedor.getClass(), vendedoresidVendedor.getIdVendedor());
				proceso.setVendedoresidVendedor(vendedoresidVendedor);
			}
			Ejecutivos ejecutivosidEjecutivo = proceso.getEjecutivosidEjecutivo();
			if (ejecutivosidEjecutivo != null) {
				ejecutivosidEjecutivo = em.getReference(ejecutivosidEjecutivo.getClass(), ejecutivosidEjecutivo.getIdEjecutivo());
				proceso.setEjecutivosidEjecutivo(ejecutivosidEjecutivo);
			}
			Clientes clientesidCliente = proceso.getClientesidCliente();
			if (clientesidCliente != null) {
				clientesidCliente = em.getReference(clientesidCliente.getClass(), clientesidCliente.getIdCliente());
				proceso.setClientesidCliente(clientesidCliente);
			}
			em.persist(proceso);
			if (vendedoresidVendedor != null) {
				vendedoresidVendedor.getProcesoList().add(proceso);
				vendedoresidVendedor = em.merge(vendedoresidVendedor);
			}
			if (ejecutivosidEjecutivo != null) {
				ejecutivosidEjecutivo.getProcesoList().add(proceso);
				ejecutivosidEjecutivo = em.merge(ejecutivosidEjecutivo);
			}
			if (clientesidCliente != null) {
				clientesidCliente.getProcesoList().add(proceso);
				clientesidCliente = em.merge(clientesidCliente);
			}
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public void edit(Proceso proceso) throws NonexistentEntityException, Exception {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			Proceso persistentProceso = em.find(Proceso.class, proceso.getIdProceso());
			Vendedores vendedoresidVendedorOld = persistentProceso.getVendedoresidVendedor();
			Vendedores vendedoresidVendedorNew = proceso.getVendedoresidVendedor();
			Ejecutivos ejecutivosidEjecutivoOld = persistentProceso.getEjecutivosidEjecutivo();
			Ejecutivos ejecutivosidEjecutivoNew = proceso.getEjecutivosidEjecutivo();
			Clientes clientesidClienteOld = persistentProceso.getClientesidCliente();
			Clientes clientesidClienteNew = proceso.getClientesidCliente();
			if (vendedoresidVendedorNew != null) {
				vendedoresidVendedorNew = em.getReference(vendedoresidVendedorNew.getClass(), vendedoresidVendedorNew.getIdVendedor());
				proceso.setVendedoresidVendedor(vendedoresidVendedorNew);
			}
			if (ejecutivosidEjecutivoNew != null) {
				ejecutivosidEjecutivoNew = em.getReference(ejecutivosidEjecutivoNew.getClass(), ejecutivosidEjecutivoNew.getIdEjecutivo());
				proceso.setEjecutivosidEjecutivo(ejecutivosidEjecutivoNew);
			}
			if (clientesidClienteNew != null) {
				clientesidClienteNew = em.getReference(clientesidClienteNew.getClass(), clientesidClienteNew.getIdCliente());
				proceso.setClientesidCliente(clientesidClienteNew);
			}
			proceso = em.merge(proceso);
			if (vendedoresidVendedorOld != null && !vendedoresidVendedorOld.equals(vendedoresidVendedorNew)) {
				vendedoresidVendedorOld.getProcesoList().remove(proceso);
				vendedoresidVendedorOld = em.merge(vendedoresidVendedorOld);
			}
			if (vendedoresidVendedorNew != null && !vendedoresidVendedorNew.equals(vendedoresidVendedorOld)) {
				vendedoresidVendedorNew.getProcesoList().add(proceso);
				vendedoresidVendedorNew = em.merge(vendedoresidVendedorNew);
			}
			if (ejecutivosidEjecutivoOld != null && !ejecutivosidEjecutivoOld.equals(ejecutivosidEjecutivoNew)) {
				ejecutivosidEjecutivoOld.getProcesoList().remove(proceso);
				ejecutivosidEjecutivoOld = em.merge(ejecutivosidEjecutivoOld);
			}
			if (ejecutivosidEjecutivoNew != null && !ejecutivosidEjecutivoNew.equals(ejecutivosidEjecutivoOld)) {
				ejecutivosidEjecutivoNew.getProcesoList().add(proceso);
				ejecutivosidEjecutivoNew = em.merge(ejecutivosidEjecutivoNew);
			}
			if (clientesidClienteOld != null && !clientesidClienteOld.equals(clientesidClienteNew)) {
				clientesidClienteOld.getProcesoList().remove(proceso);
				clientesidClienteOld = em.merge(clientesidClienteOld);
			}
			if (clientesidClienteNew != null && !clientesidClienteNew.equals(clientesidClienteOld)) {
				clientesidClienteNew.getProcesoList().add(proceso);
				clientesidClienteNew = em.merge(clientesidClienteNew);
			}
			em.getTransaction().commit();
		} catch (Exception ex) {
			String msg = ex.getLocalizedMessage();
			if (msg == null || msg.length() == 0) {
				Integer id = proceso.getIdProceso();
				if (findProceso(id) == null) {
					throw new NonexistentEntityException("The proceso with id " + id + " no longer exists.");
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
			Proceso proceso;
			try {
				proceso = em.getReference(Proceso.class, id);
				proceso.getIdProceso();
			} catch (EntityNotFoundException enfe) {
				throw new NonexistentEntityException("The proceso with id " + id + " no longer exists.", enfe);
			}
			Vendedores vendedoresidVendedor = proceso.getVendedoresidVendedor();
			if (vendedoresidVendedor != null) {
				vendedoresidVendedor.getProcesoList().remove(proceso);
				vendedoresidVendedor = em.merge(vendedoresidVendedor);
			}
			Ejecutivos ejecutivosidEjecutivo = proceso.getEjecutivosidEjecutivo();
			if (ejecutivosidEjecutivo != null) {
				ejecutivosidEjecutivo.getProcesoList().remove(proceso);
				ejecutivosidEjecutivo = em.merge(ejecutivosidEjecutivo);
			}
			Clientes clientesidCliente = proceso.getClientesidCliente();
			if (clientesidCliente != null) {
				clientesidCliente.getProcesoList().remove(proceso);
				clientesidCliente = em.merge(clientesidCliente);
			}
			em.remove(proceso);
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public List<Proceso> findProcesoEntities() {
		return findProcesoEntities(true, -1, -1);
	}

	public List<Proceso> findProcesoEntities(int maxResults, int firstResult) {
		return findProcesoEntities(false, maxResults, firstResult);
	}

	private List<Proceso> findProcesoEntities(boolean all, int maxResults, int firstResult) {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			cq.select(cq.from(Proceso.class));
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

	public Proceso findProceso(Integer id) {
		EntityManager em = getEntityManager();
		try {
			return em.find(Proceso.class, id);
		} finally {
			em.close();
		}
	}

	public int getProcesoCount() {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			Root<Proceso> rt = cq.from(Proceso.class);
			cq.select(em.getCriteriaBuilder().count(rt));
			Query q = em.createQuery(cq);
			return ((Long)q.getSingleResult()).intValue();
		} finally {
			em.close();
		}
	}

}
