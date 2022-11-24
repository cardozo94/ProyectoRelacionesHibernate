package co.camcar.pruebas.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class PruebasJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String jdbcUrl="jdbc:mysql://localhost:3306/relacioenshibernate?useSSL=false";
		String user ="root";
		String pass ="";
		try {
			
			System.out.println("intentando conectar a la BBDD: "+jdbcUrl);
			Connection miConnection= DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Conexión exitosa!!");
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
