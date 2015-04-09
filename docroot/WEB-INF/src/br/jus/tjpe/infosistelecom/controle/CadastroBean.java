package br.jus.tjpe.infosistelecom.controle;

import br.jus.tjpe.infosistelecom.dao.OrgaoDao;
import br.jus.tjpe.infosistelecom.dao.RamalDao;
import br.jus.tjpe.infosistelecom.factory.OrgaoDaoFactory;
import br.jus.tjpe.infosistelecom.factory.RamalDaoFactory;
import br.jus.tjpe.infosistelecom.modelo.Orgao;
import br.jus.tjpe.infosistelecom.modelo.Ramal;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class CadastroBean {

	private ArrayList<String> cidades = new ArrayList<String>();
	private ArrayList<String> orgaos = new ArrayList<String>();
	private String selectCidade;
	private String selectLocal;
	private Orgao selectOrgao;
	private Ramal selectRamal;

	public Ramal getSelectRamal() {
		return selectRamal;
	}

	public void setSelectRamal(Ramal selectRamal) {
		this.selectRamal = selectRamal;
	}

	public String getSelectLocal() {
		return selectLocal;
	}

	public void setSelectLocal(String selectLocal) {
		this.selectLocal = selectLocal;
	}

	public Orgao getSelectOrgao() {
		return selectOrgao;
	}

	public void setSelectOrgao(Orgao selectOrgao) {
		this.selectOrgao = selectOrgao;
	}

	public ArrayList<String> getCidades() {
		return cidades;
	}

	public void setCidades(ArrayList<String> cidades) {
		this.cidades = cidades;
	}

	public ArrayList<String> getOrgaos() {
		return orgaos;
	}

	public void setOrgaos(ArrayList<String> orgaos) {
		this.orgaos = orgaos;
	}

	public String getSelectCidade() {
		return selectCidade;
	}

	public void setSelectCidade(String selectCidade) {
		this.selectCidade = selectCidade;
	}

	public void stateChangeListenerCidade() {

		ArrayList<String> orgaosTemp = new ArrayList<String>();
		OrgaoDao dao = OrgaoDaoFactory.createOrgaoDao();
		ArrayList<Orgao> orgaos = dao.listarTudo();

		for (Orgao orgao : orgaos) {
			if (selectCidade.equals(orgao.getCidade())) {
				orgaosTemp.add(orgao.getLocalidade());
			}
		}

		this.orgaos = orgaosTemp;

		if (!selectCidade.equals("semSelecao")) {

			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Cidade Selecionada", null));
		}

	}

	public void stateChangeListenerOrgao() {

	
		
		
			if (selectLocal.equals("semSelecao")) {
				
			} else {
				
				System.out.println(selectLocal);
				System.out.println("sdsdsdsds");
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_INFO, "Órgão Selecionado", null));

				OrgaoDao dao = OrgaoDaoFactory.createOrgaoDao();
				selectOrgao = dao.buscar(selectLocal);
				selectRamal.setOrgao(dao.buscar(selectLocal));
				System.out.println(selectLocal);
				System.out.println("sdsdsdsds");
				System.out.println(selectRamal.getFone());

			}

	}

	@PostConstruct
	public void init() {

		selectCidade = "";
		OrgaoDao dao = OrgaoDaoFactory.createOrgaoDao();
		ArrayList<Orgao> orgaosTemp = dao.listarTudo();
		
			for (Orgao orgao : orgaosTemp) {

				if (selectCidade.equals(orgao.getCidade())) {

					this.orgaos.add(orgao.getLocalidade());
				}
			}
		

		cidades = dao.listarCidades();

	}

	public void cadastrarRamal() {

		

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Novo Ramal Cadastrado"));
			RamalDao dao = RamalDaoFactory.createRamalDao();

			System.out.println("jhfgjkfsdhgkjsfhkjh");
			
			System.out.println(selectRamal);
			System.out.println(selectRamal.getCentroDeCusto());
			System.out.println(selectCidade);
			dao.adicionar(selectRamal);


	}

}
