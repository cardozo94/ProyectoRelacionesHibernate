package co.camcar.conexion.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EliminaCliente {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(DetallesCliente.class)
				.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			Cliente cliente = session.get(Cliente.class, 3);
			if(cliente!= null) {
				session.delete(cliente);
				session.getTransaction().commit();
				System.out.println("Registro eliminado correctamente en BBDD");
			}else
				System.out.println("Nada que eliminar");
			session.close();
		}
		finally {
			sessionFactory.close();
		}

	}

}
