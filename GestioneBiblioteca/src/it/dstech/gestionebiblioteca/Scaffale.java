package it.dstech.gestionebiblioteca;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Scaffale implements Serializable {

	private List<Libro> listaLibri;
	private String genere;

	public Scaffale(String genere) {
		super();
		this.listaLibri = new ArrayList<>();
		this.genere = genere;
	}

	public boolean mettiLibro(Libro libro) {
		this.listaLibri.add(libro);
		return true;
	}

	public boolean togliLibro(Libro libro) {
		this.listaLibri.remove(libro);
		return true;
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

	@Override
	public String toString() {
		return "Scaffale [listaLibri=" + listaLibri + ", genere=" + genere + "]";
	}

}
