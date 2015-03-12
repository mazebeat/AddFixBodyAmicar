package cl.intelidata.amicar.db;

public class ConsultasDB {

	public ConsultasDB() {

	}

	/*******************************************************************************************************/
	/************************************* Metodos de Consulta *********************************************/
	/**
	 * ***************************************************************************************************
	 */

	@SuppressWarnings("unchecked")
	public cl.intelidata.amicar.bd.Clientes returnCliente(String rutCliente, String emailCliente) {
		cl.intelidata.amicar.bd.Clientes cliente = null;
		try {
			java.util.List<cl.intelidata.amicar.bd.Clientes> clientes = new java.util.ArrayList<cl.intelidata.amicar.bd.Clientes>();
			javax.persistence.Query query = cl.intelidata.amicar.bd.EntityManagerHelper.createQuery("SELECT c FROM ClientesDiario c WHERE c.rutCliente = :rutCliente AND c.emailCliente = :emailCliente");
			query.setParameter("rutCliente", rutCliente);
			query.setParameter("emailCliente", emailCliente);
			clientes = query.getResultList();
			for (cl.intelidata.amicar.bd.Clientes c : clientes) {
				cliente = c;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cl.intelidata.amicar.bd.EntityManagerHelper.closeEntityManager();
		}
		return cliente;
	}

	public void updateCliente(cl.intelidata.amicar.bd.Clientes cliente) {
		try {
			cl.intelidata.amicar.bd.ClientesDAO clientesDAO = new cl.intelidata.amicar.bd.ClientesDAO();
			cl.intelidata.amicar.bd.EntityManagerHelper.beginTransaction();
			clientesDAO.update(cliente);
			cl.intelidata.amicar.bd.EntityManagerHelper.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cl.intelidata.amicar.bd.EntityManagerHelper.closeEntityManager();
		}
	}
}
