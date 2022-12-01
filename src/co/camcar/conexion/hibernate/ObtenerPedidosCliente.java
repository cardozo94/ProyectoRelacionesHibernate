package co.camcar.conexion.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ObtenerPedidosCliente {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cliente.class).addAnnotatedClass(DetallesCliente.class)
				.addAnnotatedClass(Pedido.class).buildSessionFactory();

		Session session = sessionFactory.openSession();

		try {
			session.beginTransaction();
			// Obtener cliente
			//Cliente cliente = session.get(Cliente.class, 7);
			Query<Cliente> consulta = session.createQuery("SELECT cl FROM Cliente cl JOIN FETCH cl.pedidos WHERE cl.id=:clienteId", Cliente.class);
			consulta.setParameter("clienteId", 7);
			Cliente cliente = consulta.getSingleResult();
			
			System.out.println("Cliente: "+cliente);

			session.getTransaction().commit();
			session.close();
			System.out.println("Pedidos: "+cliente.getPedidos());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
