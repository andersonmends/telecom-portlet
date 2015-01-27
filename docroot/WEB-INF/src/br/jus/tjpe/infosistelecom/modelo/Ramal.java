package br.jus.tjpe.infosistelecom.modelo;

public class Ramal {

	private String fone;
	private String circuito;
	private String usuario;
	private String categoria;
	private String tipoAparelho;
	private Orgao orgao;
	private String setorDeInstalacao;
	private String divulgacao;
	private String localDeInstalacaoDiferenteDaOrigem;
	private String compartilhadoCom;
	private String fax;
	private String observacoes;
	private long centroDeCusto;
	
	public Ramal(){
		
		this.fone = "";
		this.circuito = "";
		this.usuario = "";
		this.categoria = "";
		this.tipoAparelho = "";
		this.orgao = new Orgao();
		this.setorDeInstalacao = "";
		this.divulgacao = "";
		this.localDeInstalacaoDiferenteDaOrigem = "";
		this.compartilhadoCom = "";
		this.fax = "";
		this.observacoes = "";
		this.centroDeCusto = 0;
		
		
	}
	
	public String getCompartilhadoCom() {
		return compartilhadoCom;
	}

	public void setCompartilhadoCom(String compartilhadoCom) {
		this.compartilhadoCom = compartilhadoCom;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getLocalDeInstalacao() {
		return setorDeInstalacao;
	}

	public void setLocalDeInstalacao(String localDeInstalacao) {
		this.setorDeInstalacao = localDeInstalacao;
	}

	public String getLocalDeInstalacaoDiferenteDaOrigem() {
		return localDeInstalacaoDiferenteDaOrigem;
	}

	public void setLocalDeInstalacaoDiferenteDaOrigem(
			String localDeInstalacaoDiferenteDaOrigem) {
		this.localDeInstalacaoDiferenteDaOrigem = localDeInstalacaoDiferenteDaOrigem;
	}

	
	
	public String getCircuito() {
		return circuito;
	}

	public void setCircuito(String circuito) {
		this.circuito = circuito;
	}
	public String getSetorDeInstalacao() {
		return setorDeInstalacao;
	}

	public void setSetorDeInstalacao(String setorDeInstalacao) {
		this.setorDeInstalacao = setorDeInstalacao;
	}

	public String getDivulgacao() {
		return divulgacao;
	}

	public void setDivulgacao(String divulgacao) {
		this.divulgacao = divulgacao;
	}

	public String getTipoAparelho() {
		return tipoAparelho;
	}

	public void setTipoAparelho(String tipoAparelho) {
		this.tipoAparelho = tipoAparelho;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Orgao getOrgao() {
		return orgao;
	}

	public void setOrgao(Orgao orgao) {
		this.orgao = orgao;
	}

	public long getCentroDeCusto() {
		return centroDeCusto;
	}

	public void setCentroDeCusto(long centroDeCusto) {
		this.centroDeCusto = centroDeCusto;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String numero) {
		this.fone = numero;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String nomeUsuario) {
		this.usuario = nomeUsuario;
	}
	
	

}
