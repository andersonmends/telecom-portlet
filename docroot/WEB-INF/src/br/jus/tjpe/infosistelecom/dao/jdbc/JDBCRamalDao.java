package br.jus.tjpe.infosistelecom.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.jus.tjpe.infosistelecom.dao.RamalDao;
import br.jus.tjpe.infosistelecom.factory.ConnectionFactory;
import br.jus.tjpe.infosistelecom.modelo.Orgao;
import br.jus.tjpe.infosistelecom.modelo.Ramal;

public class JDBCRamalDao implements RamalDao {

	private Connection con;

	public JDBCRamalDao() {

		con = ConnectionFactory.getConnection();
	}

	@Override
	public ArrayList<Ramal> listarTudo() {
		ArrayList<Ramal> ramais = new ArrayList<Ramal>();

		try {
			PreparedStatement prst = con
					.prepareStatement("select * from RAMAL, ORGAO where PK_ORGAO_CentroCusto = FK_ORGAO_RAMAL_CentroCusto");
			ResultSet rs = prst.executeQuery();

			while (rs.next()) {
				Ramal r = new Ramal();
				Orgao o = new Orgao();

				// recuperação da tabela órgão
				o.setCentroDeCustoOrgao(Long.toString(rs.getLong("FK_ORGAO_RAMAL_CentroCusto")));
				o.setNome(rs.getString("ORGAO_NM_Nome"));
				o.setNomeOrgaoSuperior(rs.getString("ORGAO_NM_OrgaoSuperior"));
				o.setCentroDeCustoOrgaoSuperior(Long.toString(rs.getLong("ORGAO_ID_CentroCustoOrgaoSuperior")));
				o.setRegiao(rs.getString("ORGAO_NM_Regiao"));
				o.setComplemento(rs.getString("ORGAO_DS_Complemento"));
				o.setCidade(rs.getString("ORGAO_NM_Cidade"));
				o.setEndereco(rs.getString("ORGAO_NM_Endereco"));
				o.setNumero(rs.getString("ORGAO_NU_Numero"));
				o.setBairro(rs.getString("ORGAO_NM_Bairro"));
				o.setCep(rs.getString("ORGAO_NU_CEP"));

				// recuperação da tabela ramal

				r.setFone(Long.toString(rs.getLong("PK_RAMAL_Fone")));
				r.setCircuito(rs.getString("RAMAL_ID_Circuito"));
				r.setUsuario(rs.getString("RAMAL_NM_Usuario"));
				r.setCategoria(rs.getString("RAMAL_ST_Categoria"));
				r.setTipoAparelho(rs.getString("RAMAL_ST_TipoAparelho"));
				r.setOrgao(o);
				r.setSetorDeInstalacao(rs.getString("RAMAL_NM_SetorInstalacao"));
				r.setDivulgacao(rs.getString("RAMAL_ST_Divulgacao"));
				r.setLocalDeInstalacaoDiferenteDaOrigem(rs
						.getString("RAMAL_ST_LocalDiferenteDaOrigem"));
				r.setCompartilhadoCom(rs.getString("RAMAL_DS_CompartilhadoCom"));
				r.setFax(rs.getString("RAMAL_ST_Fax"));
				r.setDivulgacao(rs.getString("RAMAL_DS_Observacoes"));
				r.setCentroDeCusto(rs.getLong("FK_ORGAO_RAMAL_CentroCusto"));

				ramais.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ramais;
	}

	@Override
	public void adicionar(Ramal r) {

		try {
			PreparedStatement prst = con
					.prepareStatement("INSERT INTO RAMAL VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?) ");

			prst.setLong(1, Long.parseLong(r.getFone()));
			prst.setString(2, r.getCircuito());
			prst.setString(3, r.getUsuario());
			prst.setString(4, r.getCategoria());
			prst.setString(5, r.getTipoAparelho());
			prst.setString(6, r.getOrgao().getNome());
			prst.setString(7, r.getSetorDeInstalacao());
			prst.setString(8, r.getDivulgacao());
			prst.setString(9, r.getLocalDeInstalacaoDiferenteDaOrigem());
			prst.setString(10, r.getCompartilhadoCom());
			prst.setString(11, r.getFax());
			prst.setString(12, r.getObservacoes());
			prst.setLong(13, Long.parseLong(r.getOrgao().getCentroDeCustoOrgao()));
			prst.execute();
			prst.close();

			System.out.println("insert Successfully!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void remover(Ramal r) {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizar(Ramal r) {

		try {
			PreparedStatement prst = con.prepareStatement("update RAMAL set "
					+ "RAMAL_ID_Circuito = ? , " + "RAMAL_NM_Usuario = ? , "
					+ "RAMAL_ST_Categoria = ? , "
					+ "RAMAL_ST_TipoAparelho = ? , " + "RAMAL_NM_Orgao = ?, "
					+ "RAMAL_NM_SetorInstalacao = ?, "
					+ "RAMAL_ST_Divulgacao = ?, "
					+ "RAMAL_ST_LocalDiferenteDaOrigem = ?, "
					+ "RAMAL_ST_Fax = ?, " + "RAMAL_DS_Observacoes = ?, "
					+ "FK_ORGAO_RAMAL_CentroCusto = ? "
					+ "where PK_RAMAL_Fone = ?");
			prst.setString(1, r.getCircuito());
			prst.setString(2, r.getUsuario());
			prst.setString(3, r.getCategoria());
			prst.setString(4, r.getTipoAparelho());
			prst.setString(5, r.getOrgao().getNome());
			prst.setString(6, r.getSetorDeInstalacao());
			prst.setString(7, r.getDivulgacao());
			prst.setString(8, r.getLocalDeInstalacaoDiferenteDaOrigem());
			prst.setString(9, r.getFax());
			prst.setString(10, r.getObservacoes());
			prst.setLong(11, Long.parseLong(r.getOrgao().getCentroDeCustoOrgao()));
			prst.setLong(12, Long.parseLong(r.getFone()));
			prst.executeUpdate();
			prst.close();

			System.out.println("Updated Successfully! RAMAL JDBC");

		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	@Override
	public Ramal buscarPorNumero(int a) {

		return null;
	}

	@Override
	public ArrayList<Ramal> buscarTudoPorComarca(Orgao c) {
		return null;
	}

}
