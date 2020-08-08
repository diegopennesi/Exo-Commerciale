package ejb_elettronicaCrud;

import java.util.List;

import javax.ejb.Local;

import model.Elettronica;

@Local
public interface Ielettronica{
	 public boolean inseriscielettronica(Elettronica el);
	 public void cancellaelettronica(Elettronica el);
	 public void modificautente(Elettronica el);
	 public Elettronica cercautenteperid(Elettronica el);
	 // ?
}
