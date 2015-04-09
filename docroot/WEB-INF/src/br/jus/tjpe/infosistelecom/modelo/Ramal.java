package br.jus.tjpe.infosistelecom.modelo;

public class Ramal {

	private String fone;
	private String circuito;
	// private String usuario;
	private String situacao;
	private String categoriaDiurna;
	private String categoriaNoturna;
	private String tipoDeRamal;
	private Orgao orgao;
	// private String setorDeInstalacao;
	private String divulgacao;
	private String nomenclatura;
	private String dataDeAtivacao;
	// private String localDeInstalacaoDiferenteDaOrigem;
	private String compartilhadoCom;
	// private String fax;
	private String observacoes;
	private long centroDeCusto;

	public Ramal() {

		this.fone = "";
		this.circuito = "";
		// this.usuario = "";
		this.categoriaDiurna = "";
		this.tipoDeRamal = "";
		this.orgao = new Orgao();
		// this.setorDeInstalacao = "";
		this.divulgacao = "";
		// this.localDeInstalacaoDiferenteDaOrigem = "";
		this.compartilhadoCom = "";
		// this.fax = "";
		this.observacoes = "";
		this.centroDeCusto = 0;

	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getCategoriaNoturna() {
		return categoriaNoturna;
	}

	public void setCategoriaNoturna(String categoriaNoturna) {
		this.categoriaNoturna = categoriaNoturna;
	}

	public String getNomenclatura() {
		return nomenclatura;
	}

	public void setNomenclatura(String nomeclatura) {
		this.nomenclatura = nomeclatura;
	}

	public String getDataDeAtivacao() {
		return dataDeAtivacao;
	}

	public void setDataDeAtivacao(String dataDeAtivacao) {
		this.dataDeAtivacao = dataDeAtivacao;
	}

	public String getCompartilhadoCom() {
		return compartilhadoCom;
	}

	public void setCompartilhadoCom(String compartilhadoCom) {
		this.compartilhadoCom = compartilhadoCom;
	}

	// public String getFax() {
	// return fax;
	// }
	//
	// public void setFax(String fax) {
	// this.fax = fax;
	// }

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	// public String getLocalDeInstalacao() {
	// return setorDeInstalacao;
	// }
	//
	// public void setLocalDeInstalacao(String localDeInstalacao) {
	// this.setorDeInstalacao = localDeInstalacao;
	// }

	// public String getLocalDeInstalacaoDiferenteDaOrigem() {
	// return localDeInstalacaoDiferenteDaOrigem;
	// }
	//
	// public void setLocalDeInstalacaoDiferenteDaOrigem(
	// String localDeInstalacaoDiferenteDaOrigem) {
	// this.localDeInstalacaoDiferenteDaOrigem =
	// localDeInstalacaoDiferenteDaOrigem;
	// }

	public String getCircuito() {
		return circuito;
	}

	public void setCircuito(String circuito) {
		this.circuito = circuito;
	}

	// public String getSetorDeInstalacao() {
	// return setorDeInstalacao;
	// }
	//
	// public void setSetorDeInstalacao(String setorDeInstalacao) {
	// this.setorDeInstalacao = setorDeInstalacao;
	// }

	public String getDivulgacao() {
		return divulgacao;
	}

	public void setDivulgacao(String divulgacao) {
		this.divulgacao = divulgacao;
	}

	public String getTipoRamal() {
		return tipoDeRamal;
	}

	public void setTipoRamal(String tipoAparelho) {
		this.tipoDeRamal = tipoAparelho;
	}

	public String getCategoriaDiurna() {
		return categoriaDiurna;
	}

	public void setCategoriaDiurna(String categoria) {
		this.categoriaDiurna = categoria;
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

	// public String getUsuario() {
	// return usuario;
	// }
	//
	// public void setUsuario(String nomeUsuario) {
	// this.usuario = nomeUsuario;
	// }

}
