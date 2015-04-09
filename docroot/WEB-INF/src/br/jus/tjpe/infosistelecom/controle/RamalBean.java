package br.jus.tjpe.infosistelecom.controle;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.model.Layout;
import com.liferay.portal.theme.ThemeDisplay;

import br.jus.tjpe.infosistelecom.dao.OrgaoDao;
import br.jus.tjpe.infosistelecom.dao.RamalDao;
import br.jus.tjpe.infosistelecom.factory.OrgaoDaoFactory;
import br.jus.tjpe.infosistelecom.factory.RamalDaoFactory;
import br.jus.tjpe.infosistelecom.modelo.Orgao;
import br.jus.tjpe.infosistelecom.modelo.Ramal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.event.SelectEvent;

@ManagedBean
@SessionScoped
public class RamalBean {

	private ArrayList<Ramal> ramais;
	private Ramal selectRamal;
//	private ArrayList<String> cidades = new ArrayList<String>();
//	private ArrayList<String> orgaos = new ArrayList<String>();
	//private String selectCidade;
	//private String selectOrgao;

//	public ArrayList<String> getCidades() {
//		return cidades;
//	}
//
//	public void setCidades(ArrayList<String> cidades) {
//		this.cidades = cidades;
//	}
//
//	public ArrayList<String> getOrgaos() {
//		return orgaos;
//	}
//
//	public void setOrgaos(ArrayList<String> orgaos) {
//		this.orgaos = orgaos;
//	}

//	public String getSelectCidade() {
//		return selectCidade;
//	}
//
//	public void setSelectCidade(String selectCidade) {
//		this.selectCidade = selectCidade;
//	}

//	public String getSelectOrgao() {
//		return selectOrgao;
//	}
//
//	public void setSelectOrgao(String selectOrgao) {
//		this.selectOrgao = selectOrgao;
//	}

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
		System.out.println(selectRamal.getTipoRamal());
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
//		this.selectCidade = selectRamal.getOrgao().getCidade();
//		this.selectOrgao = selectRamal.getOrgao().getNome();
//
//		OrgaoDao dao = OrgaoDaoFactory.createComarcaDao();
//
//		ArrayList<Orgao> orgaosTemp = dao.listarTudo();
//
//		for (Orgao orgao : orgaosTemp) {
//			if (selectCidade.equals(orgao.getCidade())) {
//				this.orgaos.add(orgao.getNome());
//			}
//		}
//
//		cidades = dao.listarCidades();

	}
	
	
//	public void stateChangeListenerCidade() {
//
//		ArrayList<String> orgaosTemp = new ArrayList<String>();
//		OrgaoDao dao = OrgaoDaoFactory.createComarcaDao();
//		ArrayList<Orgao> orgaos = dao.listarTudo();
//
//		for (Orgao orgao : orgaos) {
//			if (selectCidade.equals(orgao.getCidade())) {
//				orgaosTemp.add(orgao.getNome());
//			}
//		}
//
//		this.orgaos = orgaosTemp;
//
//		if (!selectCidade.equals("semSelecao")) {
//
//			FacesContext.getCurrentInstance().addMessage(
//					null,
//					new FacesMessage(FacesMessage.SEVERITY_INFO,
//							"Cidade Selecionada", null));
//		}
//
//	}

//	public void stateChangeListenerOrgao() {
//
//		if (selectOrgao.equals("semSelecao")) {
//
//		} else {
//			FacesContext context = FacesContext.getCurrentInstance();
//			context.addMessage(null, new FacesMessage(
//					FacesMessage.SEVERITY_INFO, "Órgão Selecionado", null));
//
//			OrgaoDao dao = OrgaoDaoFactory.createComarcaDao();
//			Orgao orgao = dao.buscar(selectOrgao);
//			selectRamal.setOrgao(orgao);
//			// this.init();
//		}
//
//	}

	
	
}
