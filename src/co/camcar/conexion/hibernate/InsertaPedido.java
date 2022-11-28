package co.camcar.conexion.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InsertaPedido {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(DetallesCliente.class)
				.addAnnotatedClass(Pedido.class)
				.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			//Obtener  cliente
			Cliente cliente = session.get(Cliente.class, 1);
			Pedido pedido = new Pedido(new Date());
			cliente.aggregarPedido(pedido);
			session.getTransaction().commit();
			session.close();
		}
		finally {
			sessionFactory.close();
		}
	}

}
