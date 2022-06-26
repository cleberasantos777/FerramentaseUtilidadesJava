package insertobjcomp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import objcompdto.Filho;
import objcompdto.Pai;

public class Principal {

	private static Connection con;
	private static PreparedStatement pst;
	private static ResultSet res;

	public static void main(String[] args) {
		insert();
	}

	public static void insertDao(Pai p) {

		try {
			String sqlPai = "INSERT INTO tbpai (nomepai) VALUES (?)";
			con = Conexao.getConnectionDAO();
			pst = con.prepareStatement(sqlPai, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, p.getNomePai());
			pst.executeUpdate();
			res = pst.getGeneratedKeys();
			int n = 0;
			if (res.next()) {
				n = res.getInt(1);				
			}
			Long codGen = (long) n;
			String sqlFilho = "INSERT INTO tbfilho (codpai, nomefilho) VALUES (?, ?)";
			con = Conexao.getConnectionDAO();
			pst = con.prepareStatement(sqlFilho);
			p.getObjFilho().forEach(list -> {
				try {
					pst.setLong(1, codGen);
					pst.setString(2, list.getNomeFilho());
					pst.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			});

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void insert() {

		Filho salomao = new Filho(1L, "Salomão");
		Filho miria = new Filho(1L, "Miriã");
		Filho jan = new Filho(1L, "Jan");
		Filho salomao2 = new Filho(1L, "Sal2");
		Filho miria2 = new Filho(1L, "Mimi2");
		List<Filho> listFilho = new ArrayList<>();
		listFilho.add(salomao);
		listFilho.add(miria);
		listFilho.add(jan);
		listFilho.add(salomao2);
		listFilho.add(miria2);

		Pai cleber = new Pai("Cleber", listFilho);

		insertDao(cleber);

	}

}
