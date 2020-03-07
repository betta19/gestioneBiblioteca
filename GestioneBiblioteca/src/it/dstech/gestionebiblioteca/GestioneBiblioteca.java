package it.dstech.gestionebiblioteca;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class GestioneBiblioteca {

	public static void main(String[] args) {

		try {
			Scanner scanner = new Scanner(System.in);

			VenditaLibro libreria = caricaLibreria();

			while (true) {

				

				menu();
				int scelta = scanner.nextInt();
				scanner.nextLine();
				switch (scelta) {

				case 1: {
					
					aggiungiLibroAScaffale(scanner, creaScaffale(scanner, libreria), libreria);
					break;

				}
				case 2: {
					creaCliente(scanner);
					vendiLibroACliente(scanner, libreria);
					break;
				}

				case 3: {
					stampaLibriDalPiuAlMenoVenduto(libreria);
					break;
				}

				case 4: {
					stampaListaScaffali(libreria);
					break;
				}
				case 5: {
					stampaListaClienti(libreria);
					break;
				}
				case 6: {
					salvaLibreria(libreria);
					break;
				}
				default: {
					salvaLibreria(libreria);
					System.exit(0);
				}
				}

			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void stampaLibriDalPiuAlMenoVenduto(VenditaLibro negozio) {
		

		List<Libro> lista = negozio.getLibriAcquistatiDaiClienti();
		Collections.sort(lista, new Comparator<Libro>() {

			@Override
			public int compare(Libro o1, Libro o2) {

				if (o1.getQuantitaVenduta() > o2.getQuantitaVenduta())
					return -1;
				if (o1.getQuantitaVenduta() < o2.getQuantitaVenduta())
					return 1;
				return 0;
			}

		});
		System.out.println(lista);
	}

	public static void menu() {
		System.out.println("#############################à");
		System.out.println("1. crea libro e aggiungilo allo scaffale scegliendone il genere");
		System.out.println("2. crea cliente e vendigli libri");
		System.out.println("3. stampa libri dal più venduto al meno venduto");
		System.out.println("4. stampa lista scaffali");
		System.out.println("5. stampa lista clienti");
		System.out.println("6. SALVA!");
		

	}

	public static void stampaListaClienti(VenditaLibro negozio) {
		for (Cliente c : negozio.getListaClienti()) {
			System.out.println(c);
		}
	}
	
	public static void stampaListaScaffali(VenditaLibro negozio) {
		for (Scaffale s : negozio.getListaScaffale()) {
			System.out.println(s);
		}
	}
	
	
	

	public static Scaffale creaScaffale(Scanner scanner, VenditaLibro l) {
		System.out.println("Inserisci il genere dello scaffale");
		String genere = scanner.nextLine();
		Scaffale scaffale = new Scaffale(genere);
		l.getListaScaffale().add(scaffale);
		return scaffale;

	}

	public static Cliente creaCliente(Scanner scanner) {
		System.out.println("Dammi il cognome del cliente");
		String co = scanner.nextLine();
		System.out.println("Dammi l'id della tessera");
		String id = scanner.nextLine();

		return new Cliente(co, id);

	}

	public static void vendiLibroACliente(Scanner scanner, VenditaLibro negozio) {

		
		
		for (int i = 0; i < negozio.getListaScaffale().size(); i++) {
			System.out.println(" [ " + i + " ]" + negozio.getListaScaffale().get(i));

		}
		System.out.println("da quale scaffale vuoi prendere il libro?");
		int scegliScaffale = scanner.nextInt();
		scanner.nextLine();
		negozio.getListaScaffale().get(scegliScaffale);
		
		
	
		for (int i = 0; i < negozio.getListaScaffale().get(scegliScaffale).getListaLibri().size(); i++) {
			System.out.println("[ " +i+ " ]" +negozio.getListaScaffale().get(scegliScaffale).getListaLibri().get(i));
		}
		
		System.out.println("quale libro vuole acquistare dallo scaffale scelto, dammi l'indice?");
		int scegliLibro = scanner.nextInt();
		scanner.nextLine();
	
		System.out.println("quanti ne vuoi acquistare?");
		int quantita = scanner.nextInt();
		scanner.nextLine();
		
		
		if (negozio.checkVendita(negozio.getListaScaffale().get(scegliLibro), quantita)) {
			
			
			negozio.vendiLibro(negozio.getListaScaffale().get(scegliLibro), quantita);
		}

	}

	public static void aggiungiLibroAScaffale(Scanner scanner,Scaffale s, VenditaLibro l) {
		
		Libro libro =	aggiungiLibro(scanner);
		s.aggiungiLibroAScaffale(libro);
		l.aggiungiScaffaleANegozio(s);
		System.out.println(l.getListaScaffale());
			
			
			System.out.println("quanti di questo libro ne vuoi aggiungere?");
			int qnt = scanner.nextInt();
			scanner.nextLine();
			s.setQuantitaLibri(qnt);
			
			
			
	}

	public static Libro aggiungiLibro(Scanner scanner) {
		
		System.out.println("Inserisci l'id del libro");
		String id = scanner.nextLine();

		System.out.println("Inserisci l'autore");
		String nome = scanner.nextLine();
		System.out.println("Inserisci il costo del libro");
		double costo = scanner.nextDouble();
		scanner.nextLine();
		
		
		return new Libro(id, nome, costo);
		
		
	}

	public static void salvaLibreria(VenditaLibro n) throws IOException {
		File file = new File("libreria.ad");
		FileOutputStream out = new FileOutputStream(file);
		ObjectOutputStream stream = new ObjectOutputStream(out);
		stream.writeObject(n);
		stream.close();
	}

	public static VenditaLibro caricaLibreria() throws IOException, ClassNotFoundException {

		File file = new File("libreria.ad");
		if (!file.exists()) {
			return new VenditaLibro();
		}
		FileInputStream in = new FileInputStream(file);
		ObjectInputStream stream = new ObjectInputStream(in);
		VenditaLibro n = (VenditaLibro) stream.readObject();
		stream.close();
		return n;
	}
}