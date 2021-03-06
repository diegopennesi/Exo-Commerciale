package ejb_elettronicaCrud;

import java.util.List;
import javax.ejb.Local;
import model.BollaacquistoElettronica;
import model.Elettronica;

@Local
public interface Ielettronica{
	 public boolean inseriscielettronica(Elettronica el);
	 public void cancellaelettronica(Elettronica el);
	 public void modificaelettronica(Elettronica el);
	 public Elettronica cercaelettronicaperid(Elettronica el);
	 public List<Elettronica> prendilista();
	 public void inseriscibolla(BollaacquistoElettronica bolla);
}
