package co.camcar.conexion.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ObtenerCliente {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(DetallesCliente.class)
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			//Obtener detalles cliente
			DetallesCliente detallesCliente = session.get(DetallesCliente.class, 1);
			System.out.println(detallesCliente);
			System.out.println(detallesCliente.getCliente());
			session.getTransaction().commit();
			session.close();
		}finally {
			sessionFactory.close();
		}

	}

}
