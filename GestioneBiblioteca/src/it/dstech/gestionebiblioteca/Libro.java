package it.dstech.gestionebiblioteca;

import java.io.Serializable;

public class Libro implements Serializable {

	private String id;
	private String autore;
	private double costo;

	private int quantitaVenduta;
	

	public Libro(String id, String autore, double costo) {
		super();
		this.id = id;
		this.autore = autore;
		this.costo = costo;
		
		
	}


	
	public int getQuantitaVenduta() {
		return quantitaVenduta;
	}



	public void setQuantitaVenduta(int quantitaVenduta) {
		this.quantitaVenduta = quantitaVenduta;
	}

}