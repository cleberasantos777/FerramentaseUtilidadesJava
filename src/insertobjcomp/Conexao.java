package insertobjcomp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class Conexao {

	private static final String driver = "org.postgresql.Driver";
	private static final String caminho = "jdbc:postgresql://localhost:5432/objcomp";
	private static final String usuario = "postgres";
	private static final String senha = "1234";

	public static Connection getConnectionDAO() {

		try {
			Class.forName(driver);
			System.out.println("driver1: " + driver);
			return DriverManager.getConnection(caminho, usuario, senha);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null,
					ex);
			System.out.println("dao.ConexaoDAO.getConnectionDAO()dddd");
		} catch (SQLException ex) {
			Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null,
					ex);
			JOptionPane.showMessageDialog(null,
					"Problema ao acessar o banco de dados, contate o setor de TI");
		}
		return null;

	}

}
