package it.dstech.gestionebiblioteca;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Scaffale implements Serializable {

	private List<Libro> listaLibri;
	private String genere;
	private int quantitaLibri;

	public Scaffale(String genere, int qnt) {
		super();
		this.quantitaLibri = qnt;
		this.listaLibri = new ArrayList<>();
		this.genere = genere;
	}
	
	
	public Scaffale(String genere) {
		super();
		this.genere = genere;
	}

	

	public boolean aggiungiLibroAScaffale(Libro l) {
		if (!this.getListaLibri().contains(l)) {
			this.getListaLibri().add(l);
			return true;
		}
	return false;

	}

	public boolean rimuoviLibroDaScaffale(Libro l) {
		if (this.getListaLibri().contains(l)) {
			this.getListaLibri().remove(l);
			return true;
		}
	return false;
		
	}

	public List<Libro> getListaLibri() {
		return listaLibri;
	}

	public void setListaLibri(List<Libro> listaLibri) {
		this.listaLibri = listaLibri;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	
	public int getQuantitaLibri() {
		return quantitaLibri;
	}

	public void setQuantitaLibri(int quantitaLibri) {
		this.quantitaLibri = quantitaLibri;
	}

	@Override
	public String toString() {
		return "Scaffale [listaLibri=" + listaLibri + ", genere=" + genere + ", quantitaLibri=" + quantitaLibri + "]";
	}

	

}
