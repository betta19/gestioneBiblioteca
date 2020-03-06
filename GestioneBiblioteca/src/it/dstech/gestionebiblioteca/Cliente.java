package it.dstech.gestionebiblioteca;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cliente implements Serializable {

	private String cognome;
	private String idTessera;
	private List<Libro> libriAcquistati;

	public Cliente(String cognome, String idTessera) {
		super();
		this.cognome = cognome;
		this.idTessera = idTessera;
		this.libriAcquistati = new ArrayList<>();

	}

	public boolean compraLibro(Libro libro) {
		this.libriAcquistati.add(libro);
		return true;

	}

	public boolean rimuoviLibro(Libro libro) {
		this.libriAcquistati.remove(libro);
		return true;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getIdTessera() {
		return idTessera;
	}

	public void setIdTessera(String idTessera) {
		this.idTessera = idTessera;
	}

	public List<Libro> getLibriAcquistati() {
		return libriAcquistati;
	}

	public void setLibriAcquistati(List<Libro> libriAcquistati) {
		this.libriAcquistati = libriAcquistati;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTessera == null) ? 0 : idTessera.hashCode());
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
		Cliente other = (Cliente) obj;
		if (idTessera == null) {
			if (other.idTessera != null)
				return false;
		} else if (!idTessera.equals(other.idTessera))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [cognome=" + cognome + ", idTessera=" + idTessera + ", libriAcquistati=" + libriAcquistati
				+ "]";
	}

}