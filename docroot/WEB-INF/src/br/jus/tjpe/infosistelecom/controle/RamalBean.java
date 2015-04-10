package br.jus.tjpe.infosistelecom.controle;

import br.jus.tjpe.infosistelecom.dao.RamalDao;

import br.jus.tjpe.infosistelecom.factory.RamalDaoFactory;

import br.jus.tjpe.infosistelecom.modelo.Ramal;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

@ManagedBean
@SessionScoped
public class RamalBean {

	private ArrayList<Ramal> ramais;
	private Ramal selectRamal;

	

	public Ramal getSelectRamal() {
		return selectRamal;
	}

	public void setSelectRamal(Ramal selectRamal) {
		this.selectRamal = selectRamal;
	}

	public ArrayList<Ramal> getRamais() {
		return ramais;
	}

	public void setRamais(ArrayList<Ramal> ramais) {
		this.ramais = ramais;
	}

	@PostConstruct
	public void init() {

		RamalDao dao = RamalDaoFactory.createRamalDao();
		ramais = dao.listarTudo();

	}

	public void atualizar() {

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Campo Atualizado"));
		RamalDao dao = RamalDaoFactory.createRamalDao();
		dao.atualizar(selectRamal);

		System.out.println(selectRamal.getCentroDeCusto());
		System.out.println(selectRamal.getFone());
		System.out.println(selectRamal.getTipoDeRamal());
		System.out.println(selectRamal.getCategoriaDiurna());
		System.out.println(selectRamal.getCircuito());
		System.out.println(selectRamal.getOrgao().getCidade());
		System.out.println(selectRamal.getOrgao().getEndereco());

	}

	public void cancelar() {

		this.init();

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Ação Cancelada"));
	}

	public void onRowSelect(SelectEvent event) {
		

	}

	
}
