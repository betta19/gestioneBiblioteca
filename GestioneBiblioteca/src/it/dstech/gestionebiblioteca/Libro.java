package it.dstech.gestionebiblioteca;

import java.io.Serializable;

public class Libro implements Serializable {

	private String id;
	private String autore;
	private double costo;
	private int quantitaLibri;
	
	public Libro(String id, String autore, double costo, int quantitaLibri) {
		super();
		this.id = id;
		this.autore = autore;
		this.costo = costo;
		this.quantitaLibri = quantitaLibri;
	}

	public String getId() {
		return id;
	}

	public void setTitolo(String id) {
		this.id = id;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public int getQuantitaLibri() {
		return quantitaLibri;
	}

	public void setQuantitaLibri(int quantitaLibri) {
		this.quantitaLibri = quantitaLibri;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Libro [titolo=" + id + ", autore=" + autore + ", costo=" + costo + ", quantitaLibri=" + quantitaLibri
				+ "]";
	}

}