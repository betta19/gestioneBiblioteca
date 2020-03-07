package it.dstech.gestionebiblioteca;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cliente implements Serializable {

	private String cognome;
	private String idTessera;
	private List<Libro> libriAcquistatiDaiClienti;

	public Cliente(String cognome, String idTessera) {
		super();
		this.cognome = cognome;
		this.idTessera = idTessera;
		this.libriAcquistatiDaiClienti = new ArrayList<>();

	}
	public boolean compraLibro(Libro libro ) {
		
		this.libriAcquistatiDaiClienti.add(libro);
		return true;

	}


	public boolean rimuoviLibro(Libro libro) {
		this.libriAcquistatiDaiClienti.remove(libro);
		return true;
	}
	

	public List<Libro> getLibriAcquistatiDaiClienti() {
		return libriAcquistatiDaiClienti;
	}



	public void setLibriAcquistatiDaiClienti(List<Libro> libriAcquistatiDaiClienti) {
		this.libriAcquistatiDaiClienti = libriAcquistatiDaiClienti;
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
		return "Cliente [cognome=" + cognome + ", idTessera=" + idTessera + ", libriAcquistatiDaiClienti="
				+ libriAcquistatiDaiClienti + "]";
	}

	

}