package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	// Obtém conexão com o banco de dados
	public static Connection obtemConexao() throws SQLException {
		  String servidor = "localhost";
	      String porta = "3306";
	      String database = "pais";
	      String usuario = "root";
	      String senha = "root";

		return DriverManager
				.getConnection("jdbc:mysql://"+servidor+":"+porta+"/"+database+"?user="+usuario+"&password="+senha);
	}


}
