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
					.prepareStatement("select * from ORGAO order by ORGAO_NM_Cidade asc, ORGAO_NM_Nome asc");

			ResultSet rs = prst.executeQuery();

			while (rs.next()) {

				Orgao orgao = new Orgao();
				orgao.setCentroDeCustoOrgao(Long.toString(rs
						.getLong(("PK_ORGAO_CentroCusto"))));
				orgao.setNome(rs.getString("ORGAO_NM_Nome"));
				orgao.setNomeOrgaoSuperior(rs
						.getString("ORGAO_NM_OrgaoSuperior"));
				orgao.setCentroDeCustoOrgaoSuperior(Long.toString(rs
						.getLong("ORGAO_ID_CentroCustoOrgaoSuperior")));
				orgao.setComplemento(rs.getString("ORGAO_DS_Complemento"));
				orgao.setCidade(rs.getString("ORGAO_NM_Cidade"));
				orgao.setEndereco(rs.getString("ORGAO_NM_Endereco"));
				orgao.setNumero(rs.getString("ORGAO_NU_Numero"));
				orgao.setBairro(rs.getString("ORGAO_NM_Bairro"));
				orgao.setCep(rs.getString("ORGAO_NU_CEP"));
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
					.prepareStatement("INSERT INTO ORGAO VALUES (?,?,?,?,?,?,?,?,?,?,?) ");

			prst.setLong(1, Long.parseLong(c.getCentroDeCustoOrgao()));
			prst.setString(2, c.getNome());
			prst.setString(3, c.getNomeOrgaoSuperior());
			prst.setString(4, c.getCentroDeCustoOrgaoSuperior());
			prst.setString(5, c.getRegiao());
			prst.setString(6, c.getComplemento());
			prst.setString(7, c.getCidade());
			prst.setString(8, c.getEndereco());
			prst.setString(9, c.getNumero());
			prst.setString(10, c.getBairro());
			prst.setString(11, c.getCep());
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
					.prepareStatement("SELECT * FROM ORGAO WHERE ORGAO_NM_Nome = ?");
			prst.setString(1, c);
			ResultSet rs = prst.executeQuery();

			while (rs.next()) {

				orgao.setCentroDeCustoOrgao(Long.toString(rs
						.getLong(("PK_ORGAO_CentroCusto"))));
				orgao.setNome(rs.getString("ORGAO_NM_Nome"));
				orgao.setNomeOrgaoSuperior(rs
						.getString("ORGAO_NM_OrgaoSuperior"));
				orgao.setCentroDeCustoOrgaoSuperior(Long.toString(rs
						.getLong("ORGAO_ID_CentroCustoOrgaoSuperior")));
				orgao.setComplemento(rs.getString("ORGAO_DS_Complemento"));
				orgao.setCidade(rs.getString("ORGAO_NM_Cidade"));
				orgao.setEndereco(rs.getString("ORGAO_NM_Endereco"));
				orgao.setNumero(rs.getString("ORGAO_NU_Numero"));
				orgao.setBairro(rs.getString("ORGAO_NM_Bairro"));
				orgao.setCep(rs.getString("ORGAO_NU_CEP"));

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
