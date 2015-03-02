package com.cr4studio.cr4builder.to;

import java.io.Serializable;

public class Informacoes implements Serializable {

	/**
	 * ID de serialização
	 */
	private static final long serialVersionUID = 215597009916123253L;
	private String titulo;
	private String descricao;
	private String modelo_site;
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getModelo_site() {
		return modelo_site;
	}
	public void setModelo_site(String modelo_site) {
		this.modelo_site = modelo_site;
	}

}
