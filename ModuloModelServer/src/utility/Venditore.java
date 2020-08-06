package utility;

import java.util.ArrayList;
import java.util.HashMap;

import model.Abbigliamento;
import model.Alimentari;
import model.Elettronica;

public class Venditore {

	 private static Venditore istance=null; // riferimento all' istanza

	  private Venditore() {} // costruttore

	  public static Venditore getIstance() {
	    if(istance==null)
	      istance = new Venditore();
	    return istance;
	  }

	public HashMap<Integer,ArrayList> getLista() {
		HashMap<Integer,ArrayList> mappa = new HashMap<Integer,ArrayList>();
		ArrayList<Abbigliamento> ab= new ArrayList<Abbigliamento>();
		ArrayList<Elettronica> el= new ArrayList<Elettronica>();
		ArrayList<Alimentari> al= new ArrayList<Alimentari>();
		mappa.put(1, ab);
		mappa.put(2, el);
		mappa.put(3, al);
		ab.add(new Abbigliamento("Cappello rosso","Unica","rosso","un semplice cappello rosso, resiste ai salti",5,15.50));
		ab.add(new Abbigliamento("Maglia Verde","XL","Verde","Una maglia verde, adatta all'avventura",3,33.99));
		ab.add(new Abbigliamento("Tuta blu","M","Blu","Una Salopette blu, per chi corre tra i palazzi e lancia limoni",2,45.00));
		ab.add(new Abbigliamento("Pantalonicini marroni", "M","Marrone","Un pantaloncino marrone, adatto per esplorazioni in grotte vecchie",7,19.99));
		ab.add(new Abbigliamento("Cappotto rosso","XL","Rosso","Un cappotto adatto ad incontri impegnativi dell'altro mondo",1,199.99));
		ab.add(new Abbigliamento("Bandana nera","Unica","Nera","Una semplice bandana nera, adatta per avere infiniti oggetti",4,29.99));
		
		//fate voi per test altri oggetti nelle liste alimenti ed elettronica
		//qui ho fatto tornare un POJO strasformato in JSON in oggetto
		//possiamo usare il response.status per verificare se sei cliente o se sei Finanziere
		return mappa;
	}
	
}
