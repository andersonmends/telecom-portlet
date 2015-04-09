package br.jus.tjpe.infosistelecom.modelo;


public class Orgao {
	
	private String centroDeCusto;
	private String localidade;
	private String suborgao;
	private String centroDeCustoAntigo;
	private String polo;
	private String cidade;
	private String endereco;
	//private String complemento;
	//private String cep;
	//private String numero;
	//private String bairro;
	
	public Orgao(){
		
		this.centroDeCusto = "";
		this.centroDeCustoAntigo = "";
		this.localidade = "";
		this.suborgao = "";
		this.cidade = "";
		this.polo = "";
		//this.complemento = "";
		this.endereco = "";
		this.centroDeCusto = "";
		//this.cep = "";
		//this.numero = "";
		//this.bairro = "";	
	}

	public String getCentroDeCusto() {
		return centroDeCusto;
	}
	public void setCentroDeCusto(String centroDeCustoOrgao) {
		this.centroDeCusto = centroDeCustoOrgao;
	}
	public String getCentroDeCustoAntigo() {
		return centroDeCustoAntigo;
	}
	public void setCentroDeCustoAntigo(String centroDeCustoOrgaoSuperior) {
		this.centroDeCustoAntigo = centroDeCustoOrgaoSuperior;
	}
	public String getLocalidade() {
		return localidade;
	}
	public void setLocalidade(String nome) {
		this.localidade = nome;
	}
	public String getSubOrgao() {
		return suborgao;
	}
	public void setSubOrgao(String nomeOrgaoSuperior) {
		this.suborgao = nomeOrgaoSuperior;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getPolo() {
		return polo;
	}
	public void setPolo(String regiao) {
		this.polo = regiao;
	}
//	public String getComplemento() {
//		return complemento;
//	}
//	public void setComplemento(String complemento) {
//		this.complemento = complemento;
//	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
//	public String getCep() {
//		return cep;
//	}
//	public void setCep(String cep) {
//		this.cep = cep;
//	}
//	public String getNumero() {
//		return numero;
//	}
//	public void setNumero(String numero) {
//		this.numero = numero;
//	}
//	public String getBairro() {
//		return bairro;
//	}
//	public void setBairro(String bairro) {
//		this.bairro = bairro;
//	}
//	
	

}
