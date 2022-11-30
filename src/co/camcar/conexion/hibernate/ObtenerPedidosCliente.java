package co.camcar.conexion.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ObtenerPedidosCliente {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cliente.class).addAnnotatedClass(DetallesCliente.class)
				.addAnnotatedClass(Pedido.class).buildSessionFactory();

		Session session = sessionFactory.openSession();

		try {
			session.beginTransaction();
			// Obtener cliente
			Cliente cliente = session.get(Cliente.class, 7);
			System.out.println("Cliente: "+cliente);
			System.out.println("Pedidos: "+cliente.getPedidos());
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
