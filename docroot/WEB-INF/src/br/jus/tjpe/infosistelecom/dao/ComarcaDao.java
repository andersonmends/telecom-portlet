package br.jus.tjpe.infosistelecom.dao;

import java.util.ArrayList;

import br.jus.tjpe.infosistelecom.modelo.Orgao;
import br.jus.tjpe.infosistelecom.modelo.Tecnico;

public interface ComarcaDao {
	
	public ArrayList<Orgao> listarTudo();

	public void adicionar(Orgao c);

	public void remover(Orgao c);

	public void atualizar(Orgao c);
	
	public Tecnico buscar(Orgao c);


}
