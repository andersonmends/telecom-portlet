package br.jus.tjpe.infosistelecom.controle;

import br.jus.tjpe.infosistelecom.dao.OrgaoDao;
import br.jus.tjpe.infosistelecom.dao.RamalDao;
import br.jus.tjpe.infosistelecom.factory.OrgaoDaoFactory;
import br.jus.tjpe.infosistelecom.factory.RamalDaoFactory;
import br.jus.tjpe.infosistelecom.modelo.Ramal;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.event.NodeCollapseEvent;
import org.primefaces.event.NodeExpandEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

@ManagedBean
@ViewScoped
public class RelatorioBean {

	private ArrayList<Ramal> ramais;
	private ArrayList<String> cidades;
	private String[] selectedCidades;
	private TreeNode root = new DefaultTreeNode("Root Node", null);; 
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
		return root;
	}

	public void setRaiz(TreeNode raiz) {
		this.root = raiz;
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
		
//		DefaultTreeNode no = new DefaultTreeNode("hgshdgs", this.root);
//		DefaultTreeNode no1 = new DefaultTreeNode("hgssdsdshdgs", this.root);
//		DefaultTreeNode no2 = new DefaultTreeNode("hgshdnjhsdghjdagjhggs", no1);
//		DefaultTreeNode no3 = new DefaultTreeNode("hgshdnjhsdghjdagjhggs", this.root);
//		DefaultTreeNode no24= new DefaultTreeNode("hgshdnjhsdghjdagjhggs", no3);
		
	

	}

	public void montarRaiz() {

		//System.out.println("diuyfuidyfuidyfuidy");

//		root = new DefaultTreeNode("Root Node", null);
//		ramais = new ArrayList<Ramal>();
//		RamalDao daoRamal = RamalDaoFactory.createRamalDao();
//		ramais = daoRamal.listarTudo();
		
		
//		DefaultTreeNode no = new DefaultTreeNode(ramais.get(0), raiz); 
//		DefaultTreeNode no1 = new DefaultTreeNode(ramais.get(1), raiz); 
//		
//		for (Ramal ramal : ramais) {
//			
//			new DefaultTreeNode(ramal, this.root);
//			
//		}
//	
		DefaultTreeNode no = new DefaultTreeNode("hgshdgs", this.root);
		DefaultTreeNode no1 = new DefaultTreeNode("hgssdsdshdgs", this.root);
		DefaultTreeNode no2 = new DefaultTreeNode("hgshdnjhsdghjdagjhggs", no1);
		DefaultTreeNode no3 = new DefaultTreeNode("hgshdnjhsdghjdagjhggs", this.root);
		DefaultTreeNode no24= new DefaultTreeNode("hgshdnjhsdghjdagjhggs", no3);

		
//		System.out.println(selectedCidades[0]);
//		System.out.println(selectedCidades[1]);

		
	}
	


}
