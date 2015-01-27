package br.jus.tjpe.infosistelecom.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.jus.tjpe.infosistelecom.dao.LogDao;
import br.jus.tjpe.infosistelecom.factory.ConnectionFactory;
import br.jus.tjpe.infosistelecom.modelo.Log;
import br.jus.tjpe.infosistelecom.modelo.Ramal;

public class JDBCLogDao implements LogDao {

	private Connection con;

	public JDBCLogDao() {

		con = ConnectionFactory.getConnection();
	}

	@Override
	public void listarTudo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void adicionar(Log l) {

		try {
			PreparedStatement prst = con
					.prepareStatement("INSERT INTO LOG VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");

			prst.setNull(1, 0);
			prst.setString(2, l.getData());
			prst.setString(3, l.getUsuario());
			prst.setString(4, l.getCategoriaNew());
			prst.setString(5, l.getCategoriaOld());
			prst.setString(6, l.getTipoAparelhoNew());
			prst.setString(7, l.getTipoAparelhoOld());
			prst.setString(8, l.getDivulgaçãoNew());
			prst.setString(9, l.getDivulgaçãoOld());
			prst.setString(10, l.getCompartilhadoComNew());
			prst.setString(11, l.getCompartilhadoComOld());
			prst.setString(12, l.getFaxNew());
			prst.setString(13, l.getFaxOld());
			prst.setString(14, l.getObservacoesNew());
			prst.setString(15, l.getObservacoesOld());
			prst.setLong(16, Long.parseLong(l.getFoneRamal()));
			prst.execute();
			prst.close();

			System.out.println("insert Successfully! LOG");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void recuperarLogPorRamal(Ramal r) {
		// TODO Auto-generated method stub

	}

	@Override
	public void recuperarLogPorUsuario(String usuario) {
		// TODO Auto-generated method stub

	}

}
