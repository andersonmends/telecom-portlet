package br.jus.tjpe.infosistelecom.controle;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.jus.tjpe.infosistelecom.dao.OrgaoDao;
import br.jus.tjpe.infosistelecom.factory.OrgaoDaoFactory;

import br.jus.tjpe.infosistelecom.modelo.Orgao;

@ManagedBean
@ViewScoped
public class CadastroOrgaoBean {

	private ArrayList<String> cidades = new ArrayList<String>();
	private Orgao selectOrgao;
	private String selectCidade;

	public ArrayList<String> getCidades() {
		return cidades;
	}

	public void setCidades(ArrayList<String> cidades) {
		this.cidades = cidades;
	}

	public String getSelectCidade() {
		return selectCidade;
	}

	public void setSelectCidade(String selectCidade) {
		this.selectCidade = selectCidade;
	}

	public Orgao getSelectOrgao() {
		return selectOrgao;
	}

	public void setSelectOrgao(Orgao selectOrgao) {
		this.selectOrgao = selectOrgao;
	}

	@PostConstruct
	public void init() {

		this.selectOrgao = new Orgao();
		selectCidade = "";

		OrgaoDao dao = OrgaoDaoFactory.createOrgaoDao();
		cidades = dao.listarCidades();

	}

	public void stateChangeListenerCidade() {

		System.out.println(selectCidade);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Cidade Selecionada", null));
	}

	public void cadastrar() {

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Novo Órgão Cadastrado"));
		OrgaoDao dao = OrgaoDaoFactory.createOrgaoDao();
		dao.adicionar(selectOrgao);

		this.selectOrgao = new Orgao();
		selectCidade = "";

	}

}
