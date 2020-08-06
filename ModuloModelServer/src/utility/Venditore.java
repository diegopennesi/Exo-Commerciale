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
		ab.add(new Abbigliamento("Cappello rosso","Unica","rosso","un semplice cappello rosso, resiste ai salti",5,true,15.50));
		ab.add(new Abbigliamento("Maglia Verde","XL","Verde","Una maglia verde, adatta all'avventura",3,true,33.99));
		ab.add(new Abbigliamento("Tuta blu","M","Blu","Una Salopette blu, per chi corre tra i palazzi e lancia limoni",2,true,45.00));
		ab.add(new Abbigliamento("Pantalonicini marroni", "M","Marrone","Un pantaloncino marrone, adatto per esplorazioni in grotte vecchie",7,true,19.99));
		ab.add(new Abbigliamento("Cappotto rosso","XL","Rosso","Un cappotto adatto ad incontri impegnativi dell'altro mondo",1,true,199.99));
		ab.add(new Abbigliamento("Bandana nera","Unica","Nera","Una semplice bandana nera, adatta per avere infiniti oggetti",4,true,29.99));
		el.add(new Elettronica("CanonMP450","Macchina fotografica di penultima generazione",4,true,99.89));
		el.add(new Elettronica("Bimbi 7000","Impastatrice\robot cucina capace di cucinare molti piatti. Versione Non filippina ",2,true,299.99));
		el.add(new Elettronica("Iphone12","Cellulare trendy con un bottone. Facile da usare.Prezzo corretto",1,true,839.99));
		el.add(new Elettronica("Alienware CF5031K","Portatile di ultima generazione, ci giochi a Minecraft a 320fps",2,true,759.99));
		el.add(new Elettronica("Drone Tomcat4000","Drone multi-Elica rotativa giroscopica tapiocante auto-bilanciante antani",5,true,59.99));
		el.add(new Elettronica("Traduttore PocoCostoso","Traduttore tascabile dotato di inteligenza artificiale. Non è dotato del senso dell'umorismo",10,true,15.89));
		al.add(new Alimentari("Banane","13/9","Un casco di banane multipli di due",10,true,5.59));
		al.add(new Alimentari("Cocco","12/5","Noci di cocco, fanno bene alla pelle",8,true,9.25));
		al.add(new Alimentari("Porro","4/7","Gustoso porro, utile anche per la LevanPolka",14,true,1.23));
		al.add(new Alimentari("Zucchine","1/5","Quelle romanesche. Ci si cantano canzoni",25,true,4.59));
		al.add(new Alimentari("Stracchino","14/8","Squaqquerone per piadine.Si spalma con la forchetta",10,true,7.25));
		al.add(new Alimentari("Latte di Mandorla","2/3","Un latte di mandrola poco dolce. Attoro al 90% di zucchero",5,true,8.49));
		//fate voi per test altri oggetti nelle liste alimenti ed elettronica
		//qui ho fatto tornare un POJO strasformato in JSON in oggetto
		//possiamo usare il response.status per verificare se sei cliente o se sei Finanziere
		return mappa;
	}
	
}
