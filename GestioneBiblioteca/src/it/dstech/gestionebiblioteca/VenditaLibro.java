package it.dstech.gestionebiblioteca;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class VenditaLibro implements Serializable {

	
	private List<Cliente> listaClienti;
	private List<Libro> libriAcquistatiDaiClienti;
	private List<Scaffale> listaScaffale;

	public VenditaLibro() {
		super();
	
		this.listaClienti = new ArrayList<>();
		this.libriAcquistatiDaiClienti = new ArrayList<>();
		this.listaScaffale = new ArrayList<>();
	}
	


	public List<Scaffale> getListaScaffale() {
		return this.listaScaffale;
	}



	public void setListaScaffale(List<Scaffale> listaScaffale) {
		this.listaScaffale = listaScaffale;
	}




	public boolean vendiLibroACliente(Cliente c, Libro libro, Scaffale s, int q) {

		if (checkVendita(s,  q)) {
			
		
		int posizioneCliente = this.getListaClienti().indexOf(c);
		Cliente cliente = this.getListaClienti().get(posizioneCliente);
		return cliente.compraLibro(libro);
	}
		System.out.println("non abbiamo abbastanza libri da vendere");
		return false;
	}
	public List<Libro> getLibriAcquistatiDaiClienti() {
		return libriAcquistatiDaiClienti;
	}

	public void setLibriAcquistatiDaiClienti(List<Libro> libriAcquistatiDaiClienti) {
		this.libriAcquistatiDaiClienti = libriAcquistatiDaiClienti;
	}

	public boolean togliLibroACliente(Cliente c, Libro l) {

		int posizioneCliente = this.getListaClienti().indexOf(c);
		Cliente cliente = this.getListaClienti().get(posizioneCliente);
		return cliente.rimuoviLibro(l);

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

	public boolean checkVendita(Scaffale s, int quantita) {

		int posizione = getListaScaffale().indexOf(s);
		Scaffale scaffale = getListaScaffale().get(posizione);
		if (scaffale.getQuantitaLibri() > quantita) {
			return true;
		}
		System.out.println("Libri non disponibili");
		return false;

	}
	
	
	public boolean aggiungiScaffaleANegozio(Scaffale s) {
		if (!this.getListaScaffale().contains(s)) {
			this.getListaScaffale().add(s);
			return true;
		}
		int posizione = getListaScaffale().indexOf(s);
		Scaffale scaffale = getListaScaffale().get(posizione);
		scaffale.setQuantitaLibri(scaffale.getQuantitaLibri() + s.getQuantitaLibri());
		return true;

	}

	public boolean vendiLibro(Scaffale l, int quantita) {

		int posizione = getListaScaffale().indexOf(l);
		Scaffale scaf = getListaScaffale().get(posizione);
		scaf.setQuantitaLibri(scaf.getQuantitaLibri() - quantita);
		return true;

	}

	
	public List<Cliente> getListaClienti() {
		return listaClienti;
	}

	public void setListaClienti(List<Cliente> listaClienti) {
		this.listaClienti = listaClienti;
	}



	@Override
	public String toString() {
		return "VenditaLibro [ listaClienti=" + listaClienti
				+ ", libriAcquistatiDaiClienti=" + libriAcquistatiDaiClienti + ", listaScaffale=" + listaScaffale + "]";
	}

	

}
