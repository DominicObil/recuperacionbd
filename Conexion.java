import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	//Comprueba en la URL que el puerto sea el correcto
	private static final String URL = "jdbc:mysql://localhost:33061/classicmodels?allowPublicKeyRetrieval=true&useSSL=false";
	
	private static final String USUARIO = "root"; //Modifica
	private static final String CLAVE = "secret";//Modifica

	static {
		try {
			Class.forName(CONTROLADOR);
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el controlador");
			e.printStackTrace();
		}
	}

	public static Connection conectar() {
		Connection conexion = null;

		try {
			conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
			System.out.println("Conexión OK");

		} catch (SQLException e) {
			System.out.println("Error en la conexión");
			e.printStackTrace();
		}

		return conexion;
	}
}