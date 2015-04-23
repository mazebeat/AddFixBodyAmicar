package cl.intelidata.amicar.componente;

import static cl.intelidata.amicar.conf.Configuracion.logger;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import cl.intelidata.amicar.conf.EntityHelper;
import cl.intelidata.amicar.db.Clientes;
import cl.intelidata.amicar.db.Clientesdiario;
import cl.intelidata.amicar.db.Proceso;
import cl.intelidata.amicar.util.Tools;

/**
 * @author Maze
 */
public class DB {

	/**
	 * @param args
	 */
	public static void example(String... args) {

		/**
		 * EXAMPLE
		 *
		 * EntityManager em = null;
		 *
		 * try { em = EntityHelper.getInstance().getEntityManager(); // Toda la
		 * consulta aca Clientes c = em.find(Clientes.class, 1);
		 * System.out.println(c.getFonoParticular());
		 *
		 * } catch (Exception e) { throw new Exception("Error en consulta ", e);
		 * } finally { //necesario para cada consulta si queda abierto consume
		 * una conexion a la bd if (em != null && em.isOpen()) { if
		 * (em.getTransaction().isActive()) { em.getTransaction().rollback(); }
		 * em.close(); } }
		 *
		 */
	}

	/**
	 * @param id
	 *
	 * @return
	 *
	 * @throws Exception
	 */
	public Clientes getCliente(Integer id) throws Exception {
		return this.client(id);
	}

	private Clientes client(Integer iClienteID) throws Exception {
		Clientes cliente = null;
		EntityManager em = null;

		try {
			em = EntityHelper.getInstance().getEntityManager();
			cliente = em.find(Clientes.class, iClienteID);
		} catch (Exception e) {
			logger.error("Error en consulta {}", e);
		} finally {
			if (em != null && em.isOpen()) {
				if (em.getTransaction().isActive()) {
					em.getTransaction().rollback();
				}
				em.close();
			}
		}

		return cliente;
	}

	/**
	 * @param rutCliente
	 * @param emailCliente
	 *
	 * @return
	 */
	public Clientesdiario buscarCliente(String rutCliente, String emailCliente) {
		return this.searchCliente(rutCliente, emailCliente);
	}

	private Clientesdiario searchCliente(String rut, String email) {
		Clientesdiario cliente = null;
		EntityManager em = null;
		List<Clientesdiario> clientes = new ArrayList<Clientesdiario>();

		try {
			em = EntityHelper.getInstance().getEntityManager();

			Query query = em.createQuery("SELECT c FROM Clientesdiario c WHERE c.rutCliente = :rutCliente AND c.emailCliente = :emailCliente");
			query.setParameter("rutCliente", rut);
			query.setParameter("emailCliente", email);
			clientes = query.getResultList();

			if (clientes.size() <= 0) {
				logger.error("NO SE HA ENCONTRADO CLIENTE CON LOS DATOS {} - {} ", rut, email);
			} else {
				for (Clientesdiario c : clientes) {
					cliente = c;
					logger.info("SE HA ENCONTRADO CLIENTE: {}", cliente);
				}
			}
		} catch (Exception e) {
			logger.error("Error en consulta {}", e);
		} finally {
			if (em != null && em.isOpen()) {
				if (em.getTransaction().isActive()) {
					em.getTransaction().rollback();
				}
				em.close();
			}
		}

		return cliente;
	}

	/**
	 * @param id
	 *
	 * @return
	 *
	 * @throws Exception
	 */
	public Proceso getProceso(Integer id) throws Exception {
		return this.process(id);
	}

	private Proceso process(Integer iProcesoID) throws Exception {
		Proceso proceso = null;
		EntityManager em = null;

		try {
			em = EntityHelper.getInstance().getEntityManager();
			proceso = em.find(Proceso.class, iProcesoID);

		} catch (Exception e) {
			logger.error("Error en consulta {}", e);
		} finally {
			if (em != null && em.isOpen()) {
				if (em.getTransaction().isActive()) {
					em.getTransaction().rollback();
				}
				em.close();
			}
		}

		return proceso;
	}

	/**
	 * @param proceso
	 * @param queFecha
	 *
	 * @throws Exception
	 */
	public void actualizarProceso(Proceso proceso, char queFecha) throws Exception {
		this.updateProcess(proceso, queFecha);
	}

	private void updateProcess(Proceso process, char what) throws Exception {
		EntityManager em = null;

		try {
			em = EntityHelper.getInstance().getEntityManager();
			em.getTransaction().begin();
			switch (what) {
				case 'c':
					process.setFechaClickLink(Tools.nowDate());
					break;
				case 'r':
					process.setFechaAperturaMail(Tools.nowDate());
					break;
			}
			em.merge(process);
			em.getTransaction().commit();
		} catch (Exception e) {
			logger.error("Error en consulta {}", e);
		} finally {
			if (em != null && em.isOpen()) {
				if (em.getTransaction().isActive()) {
					em.getTransaction().rollback();
				}
				em.close();
			}
		}
	}

	/**
	 * @param cliente
	 *
	 * @throws Exception
	 */
	public void actualizarCliente(Clientes cliente) throws Exception {
		this.updateClient(cliente);
	}

	private void updateClient(Clientes client) throws Exception {
		EntityManager em = null;

		try {
			em = EntityHelper.getInstance().getEntityManager();
			em.getTransaction().begin();
			client.setDesinscrito(true);
			em.merge(client);
			em.getTransaction().commit();
		} catch (Exception e) {
			logger.error("Error en consulta {}", e);
		} finally {
			if (em != null && em.isOpen()) {
				if (em.getTransaction().isActive()) {
					em.getTransaction().rollback();
				}
				em.close();
			}
		}
	}

}
