package br.jus.tjpe.infosistelecom.controle;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.jus.tjpe.infosistelecom.dao.ComarcaDao;
import br.jus.tjpe.infosistelecom.factory.ComarcaDaoFactory;
import br.jus.tjpe.infosistelecom.modelo.Orgao;

@ManagedBean
@ViewScoped
public class ComarcaBean {

	private ArrayList<String> cidades = new ArrayList<String>();
	private ArrayList<String> orgaos = new ArrayList<String>();
	private String selectCidade;
	private String selectOrgao;
	private boolean fotoVisivel = false;
	private boolean infraestruturaVisivel = false;
	private boolean peconectadoVisivel = false;
	private boolean energiaVisivel = false;
	private boolean telefoniaVisivel = false;

	public boolean isTelefoniaVisivel() {
		return telefoniaVisivel;
	}

	public void setTelefoniaVisivel(boolean telefoniaVisivel) {
		this.telefoniaVisivel = telefoniaVisivel;
	}

	public boolean isFotoVisivel() {
		return fotoVisivel;
	}

	public void setFotoVisivel(boolean fotoVisivel) {
		this.fotoVisivel = fotoVisivel;
	}

	public boolean isInfraestruturaVisivel() {
		return infraestruturaVisivel;
	}

	public void setInfraestruturaVisivel(boolean infraestruturaVisivel) {
		this.infraestruturaVisivel = infraestruturaVisivel;
	}

	public boolean isPeconectadoVisivel() {
		return peconectadoVisivel;
	}

	public void setPeconectadoVisivel(boolean peconectadoVisivel) {
		this.peconectadoVisivel = peconectadoVisivel;
	}

	public boolean isEnergiaVisivel() {
		return energiaVisivel;
	}

	public void setEnergiaVisivel(boolean energiaVisivel) {
		this.energiaVisivel = energiaVisivel;
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

	public String getSelectOrgao() {
		return selectOrgao;
	}

	public void setSelectOrgao(String selectOrgao) {
		this.selectOrgao = selectOrgao;
	}

	@PostConstruct
	public void init() {

		ComarcaDao dao = ComarcaDaoFactory.createComarcaDao();
		boolean verificador = false;
		ArrayList<Orgao> comarcas = dao.listarTudo();
		cidades.add(comarcas.get(0).getCidade());

		for (Orgao comarca : comarcas) {
			String temp = comarca.getCidade();

			for (int i = 0; i < cidades.size(); i++) {

				if (temp.equals(cidades.get(i))) {
					verificador = true;
				}
			}

			if (verificador == false) {
				cidades.add(temp);

			}

			verificador = false;

		}

	}

	public void stateChangeListenerCidade() {

		ArrayList<String> orgaosTemp = new ArrayList<String>();
		ComarcaDao dao = ComarcaDaoFactory.createComarcaDao();
		ArrayList<Orgao> comarcas = dao.listarTudo();

		for (Orgao comarca : comarcas) {
			if (selectCidade.equals(comarca.getCidade())) {
				orgaosTemp.add(comarca.getLocalidade());
			}
		}

		orgaos = orgaosTemp;

		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Cidade Selecionada", null));

	}

	public void stateChangeListenerOrgao() {

		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Órgão Selecionado", null));
		HttpSession session = (HttpSession) context.getExternalContext()
				.getSession(false);
		ComarcaDao dao = ComarcaDaoFactory.createComarcaDao();
		ArrayList<Orgao> comarcas = dao.listarTudo();

		for (Orgao comarca : comarcas) {

			if (comarca.getCidade().equals(selectCidade)
					&& comarca.getLocalidade().equals(selectOrgao)) {
				session.setAttribute("comarca", comarca);
				mostraFieldset();
			}
		}

	}

	// metedo responsavel para mostrar os modulos do sistema, caso seja selecionado true, se ficar em false não será mostrado
	// aqui serve para configura quais modulos serão mostrado aos usuário, de acordo com o progresso de dev do sistema
	public void mostraFieldset() {
		fotoVisivel = true;
		energiaVisivel = true;
		infraestruturaVisivel = true;
		peconectadoVisivel = true;
		telefoniaVisivel = true;
		
	}
}
