package br.jus.tjpe.infosistelecom.controle;


import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;

import java.text.SimpleDateFormat;
import java.util.Date;

@ManagedBean
@ViewScoped
public class LogBean {

	private String fone = "";
	private String usuario ="";
	private Date dataInicio = new Date();
	private Date dataFim= new Date();

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public void consultarLog() {
		// FacesContext facesContext = FacesContext.getCurrentInstance();
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			String d = format.format(dataFim);
			System.out.print(d);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@PostConstruct
	public void init() {

	}

}
