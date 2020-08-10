package ejb_fatturaCrud;

import java.util.List;

import javax.ejb.Local;

import model.Fattura;

@Local
public interface Ifattura {
	public boolean inseriscifattura(Fattura fa);
	//public void modificafattura(Fattura fa);//non so neanche se lo usiamo(?)
	public List<Fattura> cercafatturaperId(Fattura fa);
	public List<Fattura> cercafatturaperIdUtente(Fattura fa);
	public void cancellafattura(Fattura fa);

}
