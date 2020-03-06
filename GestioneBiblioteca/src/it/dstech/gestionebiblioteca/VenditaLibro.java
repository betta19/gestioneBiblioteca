package it.dstech.gestionebiblioteca;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class VenditaLibro implements Serializable {

	private List<Libro> listaLibri;
	private List<Cliente> listaClienti;

	public VenditaLibro() {
		super();
		this.listaLibri = new ArrayList<>();
		this.listaClienti = new ArrayList<>();
	}

	public boolean vendiLibroACliente(Cliente c, Libro l) {

		int posizioneCliente = this.getListaClienti().indexOf(c);
		Cliente cliente = this.getListaClienti().get(posizioneCliente);
		return cliente.compraLibro(l);
	}

	public boolean togliLibroACliente(Cliente c, Libro l) {

		int posizioneCliente = this.getListaClienti().indexOf(c);
		Cliente cliente = this.getListaClienti().get(posizioneCliente);
		return cliente.rimuoviLibro(l);

	}

	public Libro dammiLibro(String codice) {
		for (Libro libro : listaLibri) {
			if (libro.getId() == codice) {
				return libro;
			}

		}
		return null;

	}

	public boolean aggiungiCliente(Cliente c) {
		if (this.getListaClienti().contains(c)) {
			System.out.println("Cliente già esistente!");
			return false;
		}
		this.getListaClienti().add(c);
		return true;

	}

	public boolean rimuoviCliente(Cliente c) {
		if (this.getListaClienti().contains(c)) {
			this.getListaClienti().remove(c);
			return true;
		}

		return false;

	}

	public boolean checkVendita(Libro l, int quantita) {

		int posizione = getListaLibri().indexOf(l);
		Libro libro = getListaLibri().get(posizione);
		if (libro.getQuantitaLibri() > quantita) {
			return true;
		}
		System.out.println("Libri non disponibili");
		return false;

	}

	public boolean aggiungiLibro(Libro l) {
		if (!this.getListaLibri().contains(l)) {
			this.getListaLibri().add(l);
			return true;
		}
		int posizione = getListaLibri().indexOf(l);
		Libro libro = getListaLibri().get(posizione);
		libro.setQuantitaLibri(libro.getQuantitaLibri() + l.getQuantitaLibri());
		return true;

	}

	public boolean vendiLibro(Libro l, int quantita) {

		int posizione = getListaLibri().indexOf(l);
		Libro libro = getListaLibri().get(posizione);
		libro.setQuantitaLibri(libro.getQuantitaLibri() - quantita);
		return true;

	}

	public List<Libro> getListaLibri() {
		return listaLibri;
	}

	public void setListaLibri(List<Libro> listaLibri) {
		this.listaLibri = listaLibri;
	}

	public List<Cliente> getListaClienti() {
		return listaClienti;
	}

	public void setListaClienti(List<Cliente> listaClienti) {
		this.listaClienti = listaClienti;
	}

	@Override
	public String toString() {
		return "VenditaLibro [listaLibri=" + listaLibri + ", listaClienti=" + listaClienti + "]";
	}

}
