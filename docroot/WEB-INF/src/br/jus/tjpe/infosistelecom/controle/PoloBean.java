package br.jus.tjpe.infosistelecom.controle;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.jus.tjpe.infosistelecom.dao.TecnicoDao;
import br.jus.tjpe.infosistelecom.factory.TecnicoDaoFactory;
import br.jus.tjpe.infosistelecom.modelo.Tecnico;

@ManagedBean
@ViewScoped
public class PoloBean {

	private ArrayList<Tecnico> tecnicos;
	private String selectTecnico;
	private String teste;
	private boolean visivel = false;
	
	public boolean isVisivel() {
		return visivel;
	}


	public void setVisivel(boolean visivel) {
		this.visivel = visivel;
	}


	public String getTeste() {
		return teste;
	}


	public void setTeste(String teste) {
		this.teste = teste;
	}


	public String getSelectTecnico() {
		return selectTecnico;
	}


	public void setSelectTecnico(String selectTecnico) {
		this.selectTecnico = selectTecnico;
	}


	public ArrayList<Tecnico> getTecnicos() {
		return tecnicos;
	}


	public void setTecnicos(ArrayList<Tecnico> tecnicos) {
		this.tecnicos = tecnicos;
	}


	@PostConstruct
	public void init() {

		TecnicoDao dao = TecnicoDaoFactory.createTecnicoDao();
		Tecnico t = dao.buscarPorLogin("Anderson Mendes dos Santos");
		selectTecnico = t.getNome();
		System.out.print(t.getNome());

	}
	
	public void stateChangeListener()
	{
	    System.out.print(selectTecnico);
	}
	
	public void mostrar(){
		this.visivel = true;
	}

}
