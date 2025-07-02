package com.betacom.car.Models;

public class Bici extends Veicolo{

	private Integer numeroMarche; // 1 - n
	private String tipoSospenzione; // senza, mono, bi, ....,
	private Boolean piegevole;
	
	public Integer getNumeroMarche() {
		return numeroMarche;
	}
	public void setNumeroMarche(Integer numeroMarche) {
		this.numeroMarche = numeroMarche;
	}
	public String getTipoSospenzione() {
		return tipoSospenzione;
	}
	public void setTipoSospenzione(String tipoSospenzione) {
		this.tipoSospenzione = tipoSospenzione;
	}
	public Boolean getPiegevole() {
		return piegevole;
	}
	public void setPiegevole(Boolean piegevole) {
		this.piegevole = piegevole;
	}
	@Override
	public String toString() {
		return "Bici [Id=" + getId() + ", TipoVeicolo=" + getTipoVeicolo() + ", NumeroRuote="
				+ getNumeroRuote() + ", TipoAlimentazione=" + getTipoAlimentazione() + ", Categoria="
				+ getCategoria() + ", getColore()=" + getColore() + ", getMarca()=" + getMarca()
				+ ", AnnoProduzione=" + getAnnoProduzione() + ", Modello=" + getModello() 
				+ ", numeroMarche=" + numeroMarche + ", tipoSospenzione=" + tipoSospenzione + ", piegevole="
				+ piegevole +"]";
	}
	
}
