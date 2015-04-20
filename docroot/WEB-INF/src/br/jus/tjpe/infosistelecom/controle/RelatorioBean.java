package br.jus.tjpe.infosistelecom.controle;

import br.jus.tjpe.infosistelecom.dao.OrgaoDao;
import br.jus.tjpe.infosistelecom.dao.RamalDao;
import br.jus.tjpe.infosistelecom.factory.OrgaoDaoFactory;
import br.jus.tjpe.infosistelecom.factory.RamalDaoFactory;
import br.jus.tjpe.infosistelecom.modelo.Ramal;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.model.TreeNode;

@ManagedBean
@RequestScoped
public class RelatorioBean {

	private ArrayList<Ramal> ramais;
	private ArrayList<String> cidades;
	private String[] selectedCidades;
	
	private TreeNode raiz;
	private boolean polo;
	private String teste;

	public String getTeste() {
		return teste;
	}

	public void setTeste(String teste) {
		this.teste = teste;
	}

	public boolean getPolo() {
		return polo;
	}

	public void setPolo(boolean polo) {
		this.polo = polo;
	}

	public String[] getSelectedCidades() {
		return selectedCidades;
	}

	public void setSelectedCidades(String[] selectedCidades) {
		this.selectedCidades = selectedCidades;
	}

	public ArrayList<String> getCidades() {
		return cidades;
	}

	public void setCidades(ArrayList<String> cidades) {
		this.cidades = cidades;
	}

	public TreeNode getRaiz() {
		return raiz;
	}

	public void setRaiz(TreeNode raiz) {
		this.raiz = raiz;
	}

	public ArrayList<Ramal> getRamais() {
		return ramais;
	}

	public void setRamais(ArrayList<Ramal> ramais) {
		this.ramais = ramais;
	}

	@PostConstruct
	public void init() {

		cidades = new ArrayList<String>();
		OrgaoDao daoOrgao = OrgaoDaoFactory.createOrgaoDao();
		cidades = daoOrgao.listarCidades();

//		ramais = new ArrayList<Ramal>();
//		RamalDao daoRamal = RamalDaoFactory.createRamalDao();
//		ramais = daoRamal.listarTudo();

	}

	public void montarRaiz() {

		//System.out.println("diuyfuidyfuidyfuidy");
		// raiz = new DefaultTreeNode("Raiz", null);
		// System.out.println(raiz);
		// // System.out.println(selectedCidades.length);
		// System.out.println("RE");
		// DefaultTreeNode no = new DefaultTreeNode("hgshdgs", raiz);
		// DefaultTreeNode no1 = new DefaultTreeNode("hgshdgs", no);
		// DefaultTreeNode no = new DefaultTreeNode(cidade, raiz);
		// DefaultTreeNode no1 = new DefaultTreeNode(cidade, no);
		// for (String cidade : selectedCidades) {
		// System.out.println(cidade);
		//
		// // DefaultTreeNode no = new DefaultTreeNode(cidade, raiz);
		// DefaultTreeNode no1 = new DefaultTreeNode(cidade, no);
		// System.out.println(no);
		// System.out.println(no1);
		// }

		// System.out.println(no);
		// System.out.println(no1);
		//
		
		ramais = new ArrayList<Ramal>();
//		RamalDao daoRamal = RamalDaoFactory.createRamalDao();
//		ramais = daoRamal.listarTudo();
		
		
		
		System.out.println(selectedCidades);
		System.out.println(selectedCidades[0]);
		System.out.println(selectedCidades[1]);
		System.out.println(teste);
		System.out.println(polo);
		
	}

}
