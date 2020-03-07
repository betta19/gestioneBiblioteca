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

			Scaffale sc = null;
			Libro libro= null;
			
			menu();
			int scelta = scanner.nextInt();
			scanner.nextLine();
			switch (scelta) {
			case 1: {
				libro = aggiungiLibro(scanner, libreria);
				break;

			}
			
			case 2 : {
				sc.togliLibro(libro);
				break;
			}

			case 3: {
				
				break;

			}
			case 4: {
				
				break;
			}

			case 5: {
			
				break;
			}
			case 13: {
				
				break;
			}
			case 14: {
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



private static void stampaClientiCheHannoSpesoDiPiu(VenditaLibro negozio, boolean primi) { 
	/*cambiare il comparator per libro+venduto*/

	List<Cliente> listaClienti = negozio.getListaClienti();
	Collections.sort(listaClienti, new Comparator<Cliente>() {

		@Override
		public int compare(Cliente o1, Cliente o2) {
			double costoTotaleO1 = 0.0;
			for (Libro l : o1.getLibriAcquistati()) {
				costoTotaleO1 += l.getCosto() * l.getQuantitaLibri();
			}
			double costoTotaleO2 = 0.0;
			for (Libro l: o2.getLibriAcquistati()) {
				costoTotaleO2 += l.getCosto() * l.getQuantitaLibri();
			}
			if (costoTotaleO1 < costoTotaleO2)
				return -1;
			if (costoTotaleO1 > costoTotaleO2)
				return 1;
			return 0;
		}
	});

	if (primi) {
		// stampo i primi
		for (int i = 0; i < 5; i++) {
			System.out.println(listaClienti.get(i));
		}

	} else {
//		stampo ultimi
		for (int i = listaClienti.size() - 1; i > listaClienti.size() - 6; i--) {
			System.out.println(listaClienti.get(i));
		}
	}
}

private static void menu() {
	System.out.println("1. aggiungi libro");
	System.out.println("2. rimuovi libro");
	System.out.println("3. cambia costo prodotto");
	System.out.println("4. crea cliente");
	System.out.println("5. vendi prodotto");
	System.out.println("6. 5 prodotti pių cari");
	System.out.println("7. 5 prodotti pių economici");
	System.out.println("8. 5 clienti che hanno speso di pių");
	System.out.println("9. 3 clienti per spesa pių economica");
	System.out.println("10. 3 prodotti pių venduti");
	System.out.println("11. 3 prodotti meno venduti");
	System.out.println("12. Stampa lista prodotti");
	System.out.println("13. stampa lista clienti");
	System.out.println("14. SALVA!");

}

private static void stampaListaClienti(VenditaLibro negozio) {
	for (Cliente c : negozio.getListaClienti()) {
		System.out.println(c);
	}
}

private static void stampaListaLibri(VenditaLibro negozio) {
	for (Libro l : negozio.getListaLibri()) {
		System.out.println(l);
	}
}

private static Libro aggiungiLibro(Scanner scanner, VenditaLibro negozio) {
	System.out.println("Inserisci l'id del libro");
	String id = scanner.nextLine();
	
	System.out.println("Inserisci l' autore");
	String nome = scanner.nextLine();
	System.out.println("Inserisci il costo del libro");
	double costo = scanner.nextDouble();
	scanner.nextLine();
	System.out.println("Inserisci quanti libri ci sono");
	int qta = scanner.nextInt();
	scanner.nextLine();
	Libro libro = new Libro(id, nome, costo, qta);
	negozio.aggiungiLibro(libro);
	return libro;
}

private static void salvaLibreria(VenditaLibro n) throws IOException {
	File file = new File("libreria.xd");
	FileOutputStream out = new FileOutputStream(file);
	ObjectOutputStream stream = new ObjectOutputStream(out);
	stream.writeObject(n);
	stream.close();
}

private static VenditaLibro caricaLibreria() throws IOException, ClassNotFoundException {

	File file = new File("libreria.xd");
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
