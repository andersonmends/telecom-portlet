package br.jus.tjpe.infosistelecom.modelo;


public class Orgao {
	
	private String centroDeCustoOrgao;
	private String centroDeCustoOrgaoSuperior;
	private String nome;
	private String nomeOrgaoSuperior;
	private String cidade;
	private String regiao;
	private String complemento;
	private String endereco;
	private String cep;
	private String numero;
	private String bairro;
	
	public Orgao(){
		
		this.centroDeCustoOrgao = "";
		this.centroDeCustoOrgaoSuperior = "";
		this.nome = "";
		this.nomeOrgaoSuperior = "";
		this.cidade = "";
		this.regiao = "";
		this.complemento = "";
		this.endereco = "";
		this.centroDeCustoOrgao = "";
		this.cep = "";
		this.numero = "";
		this.bairro = "";
		
	}


	public String getCentroDeCustoOrgao() {
		return centroDeCustoOrgao;
	}
	public void setCentroDeCustoOrgao(String centroDeCustoOrgao) {
		this.centroDeCustoOrgao = centroDeCustoOrgao;
	}
	public String getCentroDeCustoOrgaoSuperior() {
		return centroDeCustoOrgaoSuperior;
	}
	public void setCentroDeCustoOrgaoSuperior(String centroDeCustoOrgaoSuperior) {
		this.centroDeCustoOrgaoSuperior = centroDeCustoOrgaoSuperior;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeOrgaoSuperior() {
		return nomeOrgaoSuperior;
	}
	public void setNomeOrgaoSuperior(String nomeOrgaoSuperior) {
		this.nomeOrgaoSuperior = nomeOrgaoSuperior;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getRegiao() {
		return regiao;
	}
	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	

}
