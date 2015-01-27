package br.jus.tjpe.infosistelecom.modelo;

import java.util.ArrayList;

public class Polo {
	
	private String nome;
	private ArrayList<Orgao> comarca;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<Orgao> getCidade() {
		return comarca;
	}
	public void setCidade(ArrayList<Orgao> comarca) {
		this.comarca = comarca;
	}

}
