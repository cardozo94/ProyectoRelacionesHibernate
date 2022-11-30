package co.camcar.conexion.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InsertaCliente {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(DetallesCliente.class)
				.addAnnotatedClass(Pedido.class)
				.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		try {
			Cliente cliente = new Cliente("Lorena", "Cardozo", "Calle 54");
			DetallesCliente detallesCliente = new DetallesCliente("wwww.lorena.co", "123456789", "tercer cliente");
			//asociar los objetos
			cliente.setDetallesCliente(detallesCliente);
			session.beginTransaction();
			//Esto guarda la información en las dos tablas relacionadas
			session.save(cliente);
			session.getTransaction().commit();
			System.out.println("Registro insertado correctamente en BBDD");
			session.close();
		}
		finally {
			sessionFactory.close();
		}

	}

}
