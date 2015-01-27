package br.jus.tjpe.infosistelecom.dao;

import java.util.ArrayList;

import br.jus.tjpe.infosistelecom.modelo.Log;
import br.jus.tjpe.infosistelecom.modelo.Ramal;

public interface LogDao {
	
	public ArrayList<Log> listarTudo();
	
	public void adicionar (Log l);
	
	public void recuperarLogPorRamal(Ramal r);
	
	public void recuperarLogPorUsuario(String usuario);

}
