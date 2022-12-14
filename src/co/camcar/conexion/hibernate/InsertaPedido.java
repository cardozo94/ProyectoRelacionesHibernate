package co.camcar.conexion.hibernate;

import java.util.GregorianCalendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InsertaPedido {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cliente.class).addAnnotatedClass(DetallesCliente.class)
				.addAnnotatedClass(Pedido.class).buildSessionFactory();

		Session session = sessionFactory.openSession();

		try {
			session.beginTransaction();
			// Obtener cliente
			Cliente cliente = session.get(Cliente.class, 7);
			Pedido pedido1 = new Pedido(new GregorianCalendar(2022,11,30));
			Pedido pedido2 = new Pedido(new GregorianCalendar(2022,11,29));
			Pedido pedido3 = new Pedido(new GregorianCalendar(2022,11,28));
			// agreggar pedidos al cliente
			cliente.aggregarPedido(pedido1);
			cliente.aggregarPedido(pedido2);
			cliente.aggregarPedido(pedido3);
			// guardar los pedidos en la tabla de DDBB
			session.save(pedido1);
			session.save(pedido2);
			session.save(pedido3);
			session.getTransaction().commit();
			System.out.println("Registro guardados correctamente");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
