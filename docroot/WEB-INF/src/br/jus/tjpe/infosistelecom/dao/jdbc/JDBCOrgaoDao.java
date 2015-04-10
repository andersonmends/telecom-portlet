package br.jus.tjpe.infosistelecom.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.jus.tjpe.infosistelecom.dao.OrgaoDao;
import br.jus.tjpe.infosistelecom.factory.ConnectionFactory;
import br.jus.tjpe.infosistelecom.modelo.Orgao;

public class JDBCOrgaoDao implements OrgaoDao {

	private Connection con;

	public JDBCOrgaoDao() {

		con = ConnectionFactory.getConnection();
	}

	@Override
	public ArrayList<Orgao> listarTudo() {

		ArrayList<Orgao> orgaos = new ArrayList<Orgao>();

		try {
			PreparedStatement prst = con
					.prepareStatement("select * from ORGAO order by ORGAO_NM_Cidade asc, ORGAO_NM_Localidade asc");

			ResultSet rs = prst.executeQuery();

			while (rs.next()) {

				Orgao orgao = new Orgao();
				orgao.setCentroDeCusto(rs.getString(("PK_ORGAO_CentroDeCusto")));
				orgao.setLocalidade(rs.getString("ORGAO_NM_Localidade"));
				orgao.setSuborgao(rs
						.getString("ORGAO_NM_Suborgao"));
				orgao.setCentroDeCustoAntigo(Long.toString(rs
						.getLong("ORGAO_ID_CentroDeCustoAntigo")));
				orgao.setCidade(rs.getString("ORGAO_NM_Cidade"));
				orgao.setEndereco(rs.getString("ORGAO_NM_Endereco"));		
				System.out.println(orgao);
				orgaos.add(orgao);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return orgaos;

	}

	@Override
	public void adicionar(Orgao c) {

		try {
			PreparedStatement prst = con
					.prepareStatement("INSERT INTO ORGAO VALUES (?,?,?,?,?,?,?) ");

			prst.setString(1, c.getCentroDeCusto());
			prst.setString(2, c.getLocalidade());
			prst.setString(3, c.getSuborgao());
			prst.setString(4, c.getCentroDeCustoAntigo());
			prst.setString(5, c.getPolo());
			prst.setString(6, c.getCidade());
			prst.setString(7, c.getEndereco());
			prst.execute();
			prst.close();

			System.out.println("insert Successfully!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
	public Orgao buscar(String c) {
		Orgao orgao = new Orgao();
		try {
			PreparedStatement prst = con
					.prepareStatement("SELECT * FROM ORGAO WHERE ORGAO_NM_Localidade = ?");
			prst.setString(1, c);
			ResultSet rs = prst.executeQuery();

			while (rs.next()) {

				orgao.setCentroDeCusto(rs.getString(("PK_ORGAO_CentroDeCusto")));
				orgao.setLocalidade(rs.getString("ORGAO_NM_Localidade"));
				orgao.setSuborgao(rs
						.getString("ORGAO_NM_SubOrgao"));
				orgao.setCentroDeCustoAntigo(Long.toString(rs
						.getLong("ORGAO_ID_CentroDeCustoAntigo")));
				orgao.setCidade(rs.getString("ORGAO_NM_Cidade"));
				orgao.setEndereco(rs.getString("ORGAO_NM_Endereco"));


			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return orgao;
	}

	@Override
	public ArrayList<String> listarCidades() {
		ArrayList<String> cidades = new ArrayList<String>();

		try {
			PreparedStatement prst = con
					.prepareStatement("SELECT ORGAO_NM_Cidade FROM `ORGAO` Group by ORGAO_NM_Cidade ASC");

			ResultSet rs = prst.executeQuery();

			while (rs.next()) {

				String cidade;
				cidade = rs.getString("ORGAO_NM_Cidade");
				cidades.add(cidade);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cidades;
	}

}
