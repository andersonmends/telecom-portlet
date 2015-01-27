package br.jus.tjpe.infosistelecom.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.jus.tjpe.infosistelecom.dao.ComarcaDao;
import br.jus.tjpe.infosistelecom.factory.ConnectionFactory;
import br.jus.tjpe.infosistelecom.modelo.Orgao;
import br.jus.tjpe.infosistelecom.modelo.Tecnico;

public class JDBCComarcaDao implements ComarcaDao {

	private Connection con;

	public JDBCComarcaDao() {

		con = ConnectionFactory.getConnection();
	}

	@Override
	public ArrayList<Orgao> listarTudo() {

		ArrayList<Orgao> comarcas = new ArrayList<Orgao>();

		try {
			PreparedStatement prst = con
					.prepareStatement("SELECT * FROM COMARCA ORDER BY COMAR_NM_Cidade ASC, COMAR_NM_Orgao ASC");

			ResultSet rs = prst.executeQuery();

			while (rs.next()) {

//				Orgao comarca = new Orgao();
//				comarca.setCentroDeCusto(rs.getLong(("COMAR_ID_CentroCusto")));
//				comarca.setCidade(rs.getString("COMAR_NM_Cidade"));
//				comarca.setBairro(rs.getString("COMAR_NM_Bairro"));
//				comarca.setCep(rs.getString("COMAR_TX_CEP"));
//				comarca.setComplemento(rs.getString("COMAR_NM_Complemento"));
//				comarca.setEndereco(rs.getString("COMAR_NM_Endereco"));
//				comarca.setNumero(rs.getString("COMAR_VL_Numero"));
//				comarca.setNome(rs.getString("COMAR_NM_Orgao"));
//				comarca.setPolo(rs.getString("COMAR_NM_Polo"));
//				comarcas.add(comarca);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return comarcas;

	}

	@Override
	public void adicionar(Orgao c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remover(Orgao c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizar(Orgao c) {
		// TODO Auto-generated method stub

	}

	@Override
	public Tecnico buscar(Orgao c) {
		// TODO Auto-generated method stub
		return null;
	}

}
