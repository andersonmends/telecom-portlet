package br.jus.tjpe.infosistelecom.dao;

import java.util.ArrayList;

import br.jus.tjpe.infosistelecom.modelo.Orgao;
import br.jus.tjpe.infosistelecom.modelo.Foto;


public interface FotoDao {
	
	public ArrayList<Foto> listarTudo(Orgao c);

	public void adicionar(Foto f);

	public void remover(Foto f);

	public void atualizar(Foto f);


}
