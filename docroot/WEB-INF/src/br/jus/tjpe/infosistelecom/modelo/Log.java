package br.jus.tjpe.infosistelecom.modelo;

public class Log {

	private String ID;
	private String foneRamal;
	private String data;
	private String usuario;
	private String categoriaDiurnaNew;
	private String categoriaDiurnaOld;
	private String categoriaNoturnaNew;
	private String categoriaNoturnaOld;
	private String tipoAparelhoNew;
	private String tipoAparelhoOld;
	private String divulgacaoNew;
	private String divulgacaoOld;
	private String localDeInstalacaoDiferenteDaOrigemNew;
	private String localDeInstalacaoDiferenteDaOrigemOld;
	private String compartilhadoComNew;
	private String compartilhadoComOld;
	private String faxNew;
	private String faxOld;
	private String observacoesNew;
	private String observacoesOld;

	public String getCategoriaDiurnaNew() {
		return categoriaDiurnaNew;
	}

	public void setCategoriaDiurnaNew(String categoriaNew) {
		this.categoriaDiurnaNew = categoriaNew;
	}

	public String getCategoriaDiurnaOld() {
		return categoriaDiurnaOld;
	}

	public void setCategoriaDiurnaOld(String categoriaOld) {
		this.categoriaDiurnaOld = categoriaOld;
	}

	public String getTipoAparelhoNew() {
		return tipoAparelhoNew;
	}

	public void setTipoAparelhoNew(String tipoAparelhoNew) {
		this.tipoAparelhoNew = tipoAparelhoNew;
	}

	public String getTipoAparelhoOld() {
		return tipoAparelhoOld;
	}

	public void setTipoAparelhoOld(String tipoAparelhoOld) {
		this.tipoAparelhoOld = tipoAparelhoOld;
	}

	public String getDivulgacaoNew() {
		return divulgacaoNew;
	}

	public void setDivulgacaoNew(String divulgaçãoNew) {
		this.divulgacaoNew = divulgaçãoNew;
	}

	public String getDivulgacaoOld() {
		return divulgacaoOld;
	}

	public void setDivulgacaoOld(String divulgaçãoOld) {
		this.divulgacaoOld = divulgaçãoOld;
	}

	public String getLocalDeInstalacaoDiferenteDaOrigemNew() {
		return localDeInstalacaoDiferenteDaOrigemNew;
	}

	public void setLocalDeInstalacaoDiferenteDaOrigemNew(
			String localDeInstalacaoDiferenteDaOrigemNew) {
		this.localDeInstalacaoDiferenteDaOrigemNew = localDeInstalacaoDiferenteDaOrigemNew;
	}

	public String getLocalDeInstalacaoDiferenteDaOrigemOld() {
		return localDeInstalacaoDiferenteDaOrigemOld;
	}

	public void setLocalDeInstalacaoDiferenteDaOrigemOld(
			String localDeInstalacaoDiferenteDaOrigemOld) {
		this.localDeInstalacaoDiferenteDaOrigemOld = localDeInstalacaoDiferenteDaOrigemOld;
	}

	public String getCompartilhadoComNew() {
		return compartilhadoComNew;
	}

	public void setCompartilhadoComNew(String compartilhadoComNew) {
		this.compartilhadoComNew = compartilhadoComNew;
	}

	public String getCompartilhadoComOld() {
		return compartilhadoComOld;
	}

	public void setCompartilhadoComOld(String compartilhadoComOld) {
		this.compartilhadoComOld = compartilhadoComOld;
	}

	public String getFaxNew() {
		return faxNew;
	}

	public void setFaxNew(String faxNew) {
		this.faxNew = faxNew;
	}

	public String getFaxOld() {
		return faxOld;
	}

	public void setFaxOld(String faxOld) {
		this.faxOld = faxOld;
	}

	public String getObservacoesNew() {
		return observacoesNew;
	}

	public void setObservacoesNew(String observacoesNew) {
		this.observacoesNew = observacoesNew;
	}

	public String getObservacoesOld() {
		return observacoesOld;
	}

	public void setObservacoesOld(String observacoesOld) {
		this.observacoesOld = observacoesOld;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getFoneRamal() {
		return foneRamal;
	}

	public void setFoneRamal(String foneRamal) {
		this.foneRamal = foneRamal;
	}

	public String getData() {
		return data.substring(0, 19);
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getCategoriaNoturnaNew() {
		return categoriaNoturnaNew;
	}

	public void setCategoriaNoturnaNew(String categoriaNoturnaNew) {
		this.categoriaNoturnaNew = categoriaNoturnaNew;
	}

	public String getCategoriaNoturnaOld() {
		return categoriaNoturnaOld;
	}

	public void setCategoriaNoturnaOld(String categoriaNoturnaOld) {
		this.categoriaNoturnaOld = categoriaNoturnaOld;
	}

}
