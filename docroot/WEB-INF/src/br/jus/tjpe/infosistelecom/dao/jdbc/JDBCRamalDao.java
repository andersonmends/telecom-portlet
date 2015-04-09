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
					.prepareStatement("select * from RAMAL, ORGAO where PK_ORGAO_CentroDeCusto = FK_ORGAO_RAMAL_CentroDeCusto");
			ResultSet rs = prst.executeQuery();

			while (rs.next()) {
				Ramal r = new Ramal();
				Orgao o = new Orgao();

				// recupera��o da tabela �rg�o
				o.setCentroDeCusto(Long.toString(rs
						.getLong("FK_ORGAO_RAMAL_CentroDeCusto")));
				o.setLocalidade(rs.getString("ORGAO_NM_Localidade"));
				o.setSubOrgao(rs.getString("ORGAO_NM_Suborgao"));
				o.setCentroDeCustoAntigo(Long.toString(rs
						.getLong("ORGAO_ID_CentroDeCustoAntigo")));
				o.setPolo(rs.getString("ORGAO_NM_Polo"));
				o.setCidade(rs.getString("ORGAO_NM_Cidade"));
				o.setEndereco(rs.getString("ORGAO_NM_Endereco"));
			
				// recupera��o da tabela ramal

				r.setFone(Long.toString(rs.getLong("PK_RAMAL_Fone")));
				r.setCircuito(rs.getString("RAMAL_ID_Circuito"));
				r.setSituacao(rs.getString("RAMAL_ST_Situacao"));
				r.setCategoriaDiurna(rs.getString("RAMAL_ST_CategoriaDiurna"));
				r.setCategoriaDiurna(rs.getString("RAMAL_ST_CategoriaNoturna"));
				r.setTipoRamal(rs.getString("RAMAL_ST_TipoDeRamal"));
				r.setOrgao(o);
				r.setDivulgacao(rs.getString("RAMAL_ST_Divulgacao"));
				r.setNomenclatura(rs.getString("RAMAL_NM_Nomenclatura"));
				r.setDataDeAtivacao(rs.getString("RAMAL_DT_DataDeAtiva��o"));
				r.setCompartilhadoCom(rs.getString("RAMAL_DS_CompartilhadoCom"));
				r.setDivulgacao(rs.getString("RAMAL_DS_Observacoes"));
				r.setCentroDeCusto(rs.getLong("FK_ORGAO_RAMAL_CentroDeCusto"));

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
			prst.setString(3, r.getSituacao());
			prst.setString(4, r.getCategoriaDiurna());
			prst.setString(4, r.getCategoriaNoturna());
			prst.setString(5, r.getTipoRamal());
			prst.setString(6, r.getOrgao().getLocalidade());
			prst.setString(8, r.getDivulgacao());
			prst.setString(8, r.getNomenclatura());
			prst.setString(9, r.getDataDeAtivacao());
			prst.setString(10, r.getCompartilhadoCom());
			prst.setString(12, r.getObservacoes());
			prst.setLong(13, Long.parseLong(r.getOrgao().getCentroDeCusto()));
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

		try {
			PreparedStatement prst = con
					.prepareStatement("DELETE FROM RAMAL WHERE PK_RAMAL_Fone = ?");

			prst.setLong(1, Long.parseLong(r.getFone()));
			prst.execute();
			prst.close();

			System.out.println("Ramal removido com successo!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void atualizar(Ramal r) {

		try {
			PreparedStatement prst = con.prepareStatement("update RAMAL set "
					+ "RAMAL_ID_Circuito = ? , "
					+ "RAMAL_ST_Situacao = ? , "
					+ "RAMAL_ST_CategoriaDiurna = ? , "
					+ "RAMAL_ST_CategoriaNoturna = ? , " 
					+ "RAMAL_ST_TipoDeRamal = ?, "
					+ "RAMAL_ST_Divulgacao = ?, "
					+ "RAMAL_NM_Localidade = ?, "
					+ "RAMAL_NM_Nomenclatura = ?, "
					+ "RAMAL_DT_DataDeAtivacao = ?, "
					+ "RAMAL_DS_CompartilhadoCom = ?, " 
					+ "RAMAL_DS_Observacoes = ?, "
					+ "FK_ORGAO_RAMAL_CentroDeCusto = ? "
					+ "where PK_RAMAL_Fone = ?");
			prst.setString(1, r.getCircuito());
			prst.setString(2, r.getSituacao());
			prst.setString(3, r.getCategoriaDiurna());
			prst.setString(4, r.getCategoriaNoturna());
			prst.setString(5, r.getTipoRamal());
			prst.setString(6, r.getDivulgacao());
			prst.setString(7, r.getOrgao().getLocalidade());
			prst.setString(8, r.getNomenclatura());
			prst.setString(9, r.getDataDeAtivacao());
			prst.setString(10, r.getCompartilhadoCom());
			prst.setString(11, r.getObservacoes());
			prst.setLong(12, Long.parseLong(r.getOrgao().getCentroDeCusto()));
			prst.setLong(13, Long.parseLong(r.getFone()));
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
